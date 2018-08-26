package ua.od.hillel.groupManager.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.persisting.StudentRepository;
import ua.od.hillel.groupManager.persisting.impl.db.StudentRepositoryDataBase;
import ua.od.hillel.groupManager.persisting.impl.db.utils.MySQLConnector;
import static org.junit.Assert.assertEquals;

import java.sql.*;

public class StudentDataBaseTest {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @Before
    public void setUp() throws SQLException {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getInt(1)).thenReturn(1);
        Mockito.when(resultSet.getString("name")).thenReturn("test");

        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.when(statement.executeQuery()).thenReturn(resultSet);

        Connection jdbcConnection = Mockito.mock(Connection.class);
        Mockito.when(jdbcConnection.prepareStatement("SELECT * FROM student WHERE id= ?")).thenReturn(statement);

        MySQLConnector mySQLConnector = Mockito.mock(MySQLConnector.class);
        Mockito.when(mySQLConnector.getConnection()).thenReturn(jdbcConnection);
        studentService = new StudentService();
        studentRepository = new StudentRepositoryDataBase(mySQLConnector);
        studentService.setStudentRepository(studentRepository);
    }

    @Test
    public void testGet(){
        Student student = studentService.getById(1);
        assertEquals(1,student.getId());
        assertEquals("test",student.getName());
    }

}
