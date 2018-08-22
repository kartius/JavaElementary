package ua.od.hillel.groupManager.persisting.impl.db;

import org.apache.log4j.Logger;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;
import ua.od.hillel.groupManager.persisting.StudentRepository;
import ua.od.hillel.groupManager.persisting.impl.db.utils.MySQLConnector;
import ua.od.hillel.groupManager.persisting.impl.file.StudentRepositoryFile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryDataBase implements StudentRepository {

    private MySQLConnector mySQLConnector = new MySQLConnector();
    final static Logger logger = Logger.getLogger(StudentRepositoryDataBase.class);

    @Override
    public int getLevelClassOfStudent(Student student) throws Exception {
        return 0;
    }

    @Override
    public List<Subject> getAllSubjects(Student student) {
        return null;
    }

    @Override
    public void add(Student student) {
        try {
            PreparedStatement preparedStatement = mySQLConnector.getConnection().prepareStatement("INSERT INTO student (name,class_id) VALUES (?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getSchoolClass().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Storing student in db is wrong - ", e);
        }
        try {
            PreparedStatement preparedStatement = mySQLConnector.getConnection().prepareStatement("INSERT INTO subject (name,school_class_id) VALUES (?,?)");
            for (Subject subject : student.getSchoolClass().getSubjects()) {
                preparedStatement.setString(1, subject.getName());
                preparedStatement.setInt(2, student.getSchoolClass().getId());
//                preparedStatement.addBatch();
                preparedStatement.executeUpdate();
            }
//            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.error("Storing student in db is wrong - ", e);
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public Student get(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = mySQLConnector.getConnection().prepareStatement("SELECT * FROM student WHERE id= ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setName(resultSet.getString("name"));
                student.setId(id);
            }
        } catch (SQLException e) {
            logger.error("Get user is wrong from db", e);
        }

        return student;
    }
}
