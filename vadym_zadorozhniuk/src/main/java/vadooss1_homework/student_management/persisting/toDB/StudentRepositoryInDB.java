package vadooss1_homework.student_management.persisting.toDB;

import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.Subject;
import vadooss1_homework.student_management.persisting.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class StudentRepositoryInDB implements StudentRepository {
    DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
    Connection connection = dBconnectorMySQL.getConnection();

    public StudentRepositoryInDB(){
        dBconnectorMySQL.cleanUpDB(connection);
    }

    @Override
    public void add(Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `student`(name) values (?)");
            preparedStatement.setString(1, student.name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("SELECT id FROM `student` WHERE name = ?");
            preparedStatement.setString(1,student.name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                student.id = resultSet.getInt("id");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student get(int id) {
        Student student = new Student("", 0);
       try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `student` WHERE id = ?"))
       {
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            student.name = resultSet.getString("name");
            student.id = resultSet.getInt("id");}
        }
        catch (SQLException e) {
        e.printStackTrace();
    }
        return student;
    }

    @Override
    public void del(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `student` WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getLevelClassOfStudent(Student student) throws Exception {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `student` LEFT JOIN `schoolclass` ON student.fk_id_schoolClass = schoolclass.id WHERE `student`.id = ?");
            preparedStatement.setInt(1, student.id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("classLevel");
            }
        return 0;
    }

    @Override
    public LinkedList<Subject> getAllSubjects(Student student) {
        LinkedList<Subject> list = new LinkedList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `students_subjects` LEFT JOIN `subject` ON students_subjects.fk_id_subject = subject.id WHERE fk_id_student = ?"))
        {preparedStatement.setInt(1, student.id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
           Subject subject = new Subject(resultSet.getString("title"));
           list.add(subject);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
