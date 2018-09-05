package ua.od.hillel.groupManager.persisting.impl.db;

import org.apache.log4j.Logger;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;
import ua.od.hillel.groupManager.persisting.StudentRepository;
import ua.od.hillel.groupManager.persisting.impl.db.utils.DBConnector;
import ua.od.hillel.groupManager.persisting.impl.db.utils.MySQLConnector;
import ua.od.hillel.groupManager.persisting.impl.file.StudentRepositoryFile;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryDataBase implements StudentRepository {

    private DBConnector dbConnector;
    final static Logger logger = Logger.getLogger(StudentRepositoryDataBase.class);


    public StudentRepositoryDataBase(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

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
            try (Connection conn = dbConnector.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO student (name,class_id) VALUES (?,?)")) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getSchoolClass().getId());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            logger.error(e);
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
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM student WHERE id= ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    logger.info("JNDI student name - " + resultSet.getString("name"));
                    logger.info("JNDI student id - " + resultSet.getInt("id"));
                    student = new Student();
                    student.setName(resultSet.getString("name"));
                    student.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
}
