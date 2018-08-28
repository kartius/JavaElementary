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
        List<Group> groups=new ArrayList<>();
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM groups")){
            try(ResultSet resultSet=preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    groups.add(get(resultSet.getInt("group_id")));
                }
            }
        }catch (SQLException e){
            logger.error("get Amount of Available groups throws ex: "+e);
        }

        for (Group group:groups
                ) {if(group.isAvailable()){
            count++;
        }
        }
        return count;
    }

    @Override
    public void add(Group group) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO groups(group_id, group_subject_name) VALUES (?,?)")){
            preparedStatement.setInt(1,group.getId());
            preparedStatement.setString(2,group.getSubject().getName());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            logger.error("Add group throws ex: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO student_group (student_id,, group_id) VALUES(?,?)")){
            for(Student student:group.getStudents()){
                preparedStatement.setInt(1,student.getId());
                preparedStatement.setInt(2,group.getId());
                preparedStatement.addBatch();
            }   preparedStatement.executeBatch();
        }catch (SQLException e){
            logger.error("Add group throws ex: "+e);
        }

    }

    @Override
    public void delete(int id) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM groups WHERE group_id=?")){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("Delete group throws ex: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM student_group WHERE group_id=?")){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("Delete group throws ex: "+e);
        }

    }

    @Override
    public void update(Group group) {
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE groups SET group_subject_name=? WHERE group_id=?")){
            preparedStatement.setString(1,group.getSubject().getName());
            preparedStatement.setInt(2, group.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            logger.error("Update group throws ex: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE student_group WHERE group_id=?")){
            preparedStatement.setInt(1,group.getId());
        }catch (SQLException e){
            logger.error("Update group throws ex: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO student_group (student_id,, group_id) VALUES(?,?)")){
            for(Student student:group.getStudents()){
                preparedStatement.setInt(1,student.getId());
                preparedStatement.setInt(2,group.getId());
                preparedStatement.addBatch();
            }   preparedStatement.executeBatch();
        }catch (SQLException e) {
            logger.error("Add group throws ex: " + e);
        }

    }

    @Override
    public Group get(int id) {
        Group group=null;
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM groups WHERE group_id=?")){
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                while (resultSet.next()){
                    group=new Group();
                    group.setId(id);
                    Subject subject=new Subject(resultSet.getString("group_subject_name"));
                    group.setSubject(subject);
                }
            }
        }catch (SQLException e){
            logger.error("Get group throws ex: "+e);
        }
        try(Connection connection=mySQLConnector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT student_id FROM student_group WHERE group_id=?")){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                List<Student> students=new ArrayList<>();
                Student student=null;
                while (resultSet.next()){
                    student.setId(resultSet.getInt("student_id"));
                    students.add(student);
                }
                group.setStudents(students);
            }

        }catch (SQLException e){
            logger.error("Get group throws ex: "+e);
        }

        return group;
    }
}
