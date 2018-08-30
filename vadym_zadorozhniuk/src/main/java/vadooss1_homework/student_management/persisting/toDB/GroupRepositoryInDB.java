package vadooss1_homework.student_management.persisting.toDB;

import vadooss1_homework.student_management.Group;
import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.persisting.GroupRepository;

import java.sql.*;

public class GroupRepositoryInDB implements GroupRepository {
    DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
    Connection connection = dBconnectorMySQL.getConnection();

    public GroupRepositoryInDB(){
        dBconnectorMySQL.cleanUpDB(connection);
    }

    @Override
    public void add(Group group) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `group`(fk_id_subject, hasThreeStudents) values (?, ?)");
            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM `subject` WHERE title = ?");
            preparedStatement2.setString(1, group.subject.title);
            ResultSet resultSet = preparedStatement2.executeQuery();
            int id_subject=0;
            while(resultSet.next()){id_subject = resultSet.getInt("id");}

            preparedStatement.setInt(1, id_subject);
            preparedStatement.setString(2, String.valueOf(group.isAvailable()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Group get(int id){
        Group group = new Group();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM `group` LEFT JOIN `subject` ON group.fk_id_subject = subject.id LEFT JOIN `groups_students`\n" +
                            "ON group.id = groups_students.fk_id_group\n" +
                            "LEFT JOIN `student`\n" +
                            "ON groups_students.fk_id_student = student.id\n" +
                            "WHERE `group`.id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                group.id = resultSet.getInt(1);
                group.hasThreeStudents = resultSet.getBoolean("hasThreeStudents");
                group.subject.title = resultSet.getString("title");
                Student student = new Student(resultSet.getString("name"), resultSet.getInt("fk_id_student"));
                try {
                    group.addStudent(student);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public void del(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `group` WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getAmountOfAvailableGroups() {
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM `group` WHERE hasThreeStudents = 'true'");
        ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()){return resultSet.getInt("count");}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void assignStudentToGroup(Group group, Student student) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `groups_students`(fk_id_group, fk_id_student) VALUES (?, ?)");
        preparedStatement.setInt(1,group.id);
        preparedStatement.setInt(2,student.id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        preparedStatement = connection.prepareStatement("SELECT fk_id_subject FROM `group` WHERE id = ?");
        preparedStatement.setInt(1,group.id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id_subject = 0;
        while(resultSet.next()){id_subject = resultSet.getInt("fk_id_subject");}
        preparedStatement.close();
        preparedStatement = connection.prepareStatement("INSERT INTO `students_subjects`(fk_id_student, fk_id_subject) VALUES (?, ?)");
        preparedStatement.setInt(1, student.id);
        preparedStatement.setInt(2, id_subject);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        student.groups.add(group.id);
        student.subjects.add(group.subject);
        group.addStudent(student);
        preparedStatement = connection.prepareStatement("UPDATE `group` SET  hasThreeStudents = ? WHERE id = ?");
        preparedStatement.setString(1,String.valueOf(group.isAvailable()));
        preparedStatement.setInt(2,group.id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
}
