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
    public int getLevelClassOfStudent(Student student) {
        int level=-1;
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT school_class FROM student WHERE student_id=?")){
            preparedStatement.setInt(1,student.getSchoolClass().getLevel());
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                level=resultSet.getInt("school_class");
            }
        }catch (SQLException e){
            logger.error("Get level class of student throws ex: "+e);
        }
        return level;
    }

    @Override
    public List<Subject> getAllSubjects(Student student) {
        List<Subject> subjects=new ArrayList<>();
        Subject subject;
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT subject_name WHERE subject_level=?")){
            preparedStatement.setInt(1, student.getSchoolClass().getLevel());
            try(ResultSet resultSet=preparedStatement.executeQuery()) {
                while(resultSet.next()){
                    subject=new Subject(resultSet.getString("subject_name"));
                    subjects.add(subject);
                }
            }
        }catch (SQLException e){
            logger.error("Get all subjects of student throws ex: "+e);
        }




        return subjects;
    }

    @Override
    public void add(Student student) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO " +
                "student (student_name, school_class) VALUES(?,?)")){

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getSchoolClass().getLevel());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("ADD student to DataBase throws ex: "+e);
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM student WHERE student_id=?")){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("Delete student throws ex: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM student_group WHERE student_id=?")){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("Delete student throws ex: "+e);
        }
    }

    @Override
    public void update(Student student) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE student SET student_name=?, school_class=? WHERE student_id=?")){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2, student.getSchoolClass().getLevel());
            preparedStatement.setInt(3, student.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("Update student throws ex: "+e);
        }

    }

    @Override
    public Student get(int id) {
        Student student=null;
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM STUDENT WHERE student_id= ?")){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                while(resultSet.next()){
                    student=new Student();
                    student.setName(resultSet.getString("student_name"));
                    student.setId(id);
                    SchoolClass schoolClass=new SchoolClass();
                    schoolClass.setLevel(1);
                }
            }
        }catch (SQLException e){
            logger.error("Get student throws ex: "+e);
        }

        List<Subject> subjects=new ArrayList<>();
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT subject_name FROM subjects WHERE subject_level= ?")){
            preparedStatement.setInt(1, student.getSchoolClass().getLevel());
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                while(resultSet.next()){
                    Subject subject=new Subject(resultSet.getString("subject_name"));
                    subjects.add(subject);
                }
            }
        }catch (SQLException e){
            logger.error("Get student throws ex: "+e);
        }
            student.getSchoolClass().setSubjects(subjects);

        return student;
    }
}
