package vadooss1_homework.student_management.persisting.toDB;


import vadooss1_homework.student_management.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddToDB {
    static Connection connection = new DBconnectorMySQL().getConnection();

    public static void subjectAdd(String title){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `subject`(title) values (?)");
            preparedStatement.setString(1, title);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void subjectDel(String title){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `subject` WHERE title = ?");
            preparedStatement.setString(1,title);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void schoolClassAdd(int classLevel){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `schoolclass`(classLevel) values (?)");
            preparedStatement.setInt(1, classLevel);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void schoolClassDel(int classLevel){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `schoolclass` WHERE classLevel = ?");
            preparedStatement.setInt(1, classLevel);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void specialClassAdd(int id_subject){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `specialclass`(fk_id_subject) values (?)");
            preparedStatement.setInt(1, id_subject);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void specialClassDel(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `specialclass` WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void studentIntoClass(Student student, int id_schoolClass){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `student` SET  fk_id_schoolClass = ? WHERE id = ?");
            preparedStatement.setInt(1, id_schoolClass);
            preparedStatement.setInt(2, student.id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("SELECT classLevel FROM `schoolclass` WHERE id = ?");
            preparedStatement.setInt(1,id_schoolClass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){student.schoolClassLevel = resultSet.getInt("classLevel");}
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void studentInSpecialclass(Student student, int id_specialClass){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `student` SET  fk_id_specialClass = ? WHERE id = ?");
            preparedStatement.setInt(1, id_specialClass);
            preparedStatement.setInt(2, student.id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("SELECT fk_id_subject FROM `specialclass` WHERE id = ?");
            preparedStatement.setInt(1,id_specialClass);
            ResultSet resultSet = preparedStatement.executeQuery();
            int id_subject = 0;
            while(resultSet.next()){id_subject = resultSet.getInt("fk_id_subject");}
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("INSERT INTO `students_subjects`(fk_id_student, fk_id_subject) VALUES (?, ?)");
            preparedStatement.setInt(1, student.id);
            preparedStatement.setInt(2, id_subject);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
