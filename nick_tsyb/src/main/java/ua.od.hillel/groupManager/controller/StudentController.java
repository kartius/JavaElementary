package ua.od.hillel.groupManager.controller;


import org.apache.log4j.Logger;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.persisting.impl.db.StudentRepositoryDataBase;
import ua.od.hillel.groupManager.persisting.impl.db.utils.MySQLConnector;
import ua.od.hillel.groupManager.services.StudentService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/student")
public class StudentController extends HttpServlet {

    StudentService studentService = new StudentService();
    final static Logger logger = Logger.getLogger(StudentController.class);

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        studentService.setStudentRepository(new StudentRepositoryDataBase(new MySQLConnector()));
        String id = reqest.getParameter("id");
        response.getWriter().println("Hello World! " + id);
        Student student = studentService.getById(Integer.valueOf(id));
        logger.info("JDBC connection student name - " + student.getName());
        logger.info("JDBC connection student id  - " + student.getId());
    }

}
