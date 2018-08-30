package solo.groupManager.persisting.impl.database;

import org.apache.log4j.Logger;
import solo.groupManager.model.Group;
import solo.groupManager.model.SchoolClass;
import solo.groupManager.model.Student;
import solo.groupManager.model.Subject;
import solo.groupManager.persisting.StudentRepository;

import solo.groupManager.persisting.impl.database.utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentRepositoryDataBase implements StudentRepository {
    private MySQLConnector mySQLConnector=new MySQLConnector();
    final static Logger logger=Logger.getLogger(StudentRepositoryDataBase.class);


    @Override
    public int getLevelClassOfStudent(Student student) throws Exception {
        return get(student.getId()).getSchoolClass().getLevel();
    }

    @Override
    public List<Subject> getAllSubjects(Student student) {
        return  get(student.getId()).getSchoolClass().getSubjects();
    }

    @Override
    public void add(Student student) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO `student` (student_name, student_level) VALUES(?,?)")){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getSchoolClass().getLevel());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("ADD STD THROWS EX: "+e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM `student` WHERE student_id=?")){
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("DELETE STD THROWS EX: "+e);
        }
        try (Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM `student_group` WHERE student_id=?")){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("DELETE STD FROM STD_GRP THROWS EX: "+e);
        }

    }

    @Override
    public void update(Student student) {
        try (Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE `student` SET student_name=?, student_level=? WHERE student_id=?")){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getSchoolClass().getLevel());
            preparedStatement.setInt(3,student.getId());
        }catch (SQLException e){
            logger.error("UPDT STD THROWS EX: "+e);
        }

    }

    @Override
    public Student get(int id) {
        Student student=new Student();
        SchoolClass schoolClass=new SchoolClass();
        List<Subject> subjects=new ArrayList<>();
        List<Group> groups=new ArrayList<>();

        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM `student` WHERE student_id=?")){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                while (resultSet.next()){
                    student.setId(resultSet.getInt("student_id"));
                    student.setName(resultSet.getString("student_name"));
                    schoolClass.setLevel(resultSet.getInt("student_level"));
                }
            }
        }catch (SQLException e){
            logger.error("GET STD THROWS EX: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM `subject` WHERE subject_level=?")){
            preparedStatement.setInt(1, schoolClass.getLevel());
            try (ResultSet resultSet=preparedStatement.executeQuery()){
                while (resultSet.next()){
                    Subject subject=new Subject(resultSet.getString("subject_name"));
                    subjects.add(subject);
                }
            }
        }catch (SQLException e){
            logger.error("GET SBJCS FOR STD THROWS EX: "+e);
        }

        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM `student_group` WHERE student_id=?")){
            preparedStatement.setInt(1,id);
        try(ResultSet resultSet=preparedStatement.executeQuery()){
            while (resultSet.next()){
                Group group=new Group();
                group.setId(resultSet.getInt("group_id"));
                groups.add(group);
            }
        }
        }catch (SQLException e){
            logger.error("GET GRPS FROM STD-GRP THROWS EX: "+e);
        }
                    schoolClass.setSubjects(subjects);
                    student.setSchoolClass(schoolClass);
                    student.setGroups(groups);


        return student;
    }
}
