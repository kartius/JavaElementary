package solo.groupManager.persisting.impl.database;

import org.apache.log4j.Logger;
import solo.groupManager.model.Group;
import solo.groupManager.model.Student;
import solo.groupManager.model.Subject;
import solo.groupManager.persisting.GroupRepository;

import solo.groupManager.persisting.impl.database.utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryDataBase implements GroupRepository {
    private MySQLConnector mySQLConnector=new MySQLConnector();
    final static Logger logger=Logger.getLogger(GroupRepositoryDataBase.class);


    @Override
    public void assignStudentToGroup(Group group, Student student) {

    }

    @Override
    public int getAmountofAvailableGroups() {
        int count=0;
        List<Integer> groups_id=new ArrayList<>();
        List<Group> groups=new ArrayList<>();

        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM `group`")){
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                while (resultSet.next()){
                    groups_id.add(resultSet.getInt("group_id"));
                }
            }
        }catch (SQLException e){
            logger.error("GET AMOUNT THROWS EX: "+e);
        }
            for(int i=0; i<groups_id.size();i++){
            groups.add(get(groups_id.get(i)));
        }
        for (Group group:groups) {
            if(group.isAvailable()){
                count++;
            }
        }


        return count;
    }

    @Override
    public void add(Group group) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO `group` (group_subject) VALUES(?)")){
            preparedStatement.setString(1, group.getSubject().getName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("ADD GRP THROWS EX: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO `student_group` (group_id, student_id) VALUES (?,?)")){
            for(Student student:group.getStudents()){
                preparedStatement.setInt(1, group.getId());
                preparedStatement.setInt(2, student.getId());
                preparedStatement.addBatch();
            } preparedStatement.executeBatch();
        }catch (SQLException e){
            logger.error("ADD STD INTO STD-GRP THROWS EX: "+e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM `group` WHERE group_id=?")){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("DELETE GRP THROWS EX: "+e);
        }
        try (Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM `student_group` WHERE group_id=?")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("DELETE STD-GROUP WITH ID THROWS EX: "+e);
        }
    }

    @Override
    public void update(Group group) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE `group` SET group_subject=? WHERE group_id=?")){
            preparedStatement.setString(1, group.getSubject().getName());
            preparedStatement.setInt(2,group.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("UPDATE GRP THROWS EX: "+e);
        }
        try (Connection connection=mySQLConnector.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM `student_group` WHERE group_id=?")){
            preparedStatement.setInt(1, group.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("DELETE STD-GROUP WITH ID THROWS EX: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO `student_group` (group_id, student_id) VALUES (?,?)")){
            for(Student student:group.getStudents()){
                preparedStatement.setInt(1, group.getId());
                preparedStatement.setInt(2, student.getId());
                preparedStatement.addBatch();
            } preparedStatement.executeBatch();
        }catch (SQLException e){
            logger.error("ADD STD INTO STD-GRP THROWS EX: "+e);
        }

    }

    @Override
    public Group get(int id) {
        Group group=new Group();
        List<Student> students=new ArrayList<>();

        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM `group` WHERE group_id=?")){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                while (resultSet.next()){
                    group.setId(resultSet.getInt("group_id"));
                    Subject subject=new Subject(resultSet.getString("group_subject"));
                    group.setSubject(subject);
                }
            }
        }catch (SQLException e){
            logger.error("GET GRP THROWS EX: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM `student_group` WHERE group_id=?")){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet=preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    Student student=new Student();
                    student.setId(resultSet.getInt("student_id"));
                    students.add(student);
                }
            }
        }catch (SQLException e){
            logger.error("GET STD FROM STD_GRP THROW EX: "+e);
        }
        group.setStudents(students);

        return group;
    }
}
