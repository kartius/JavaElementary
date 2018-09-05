package ua.od.hillel.groupManager.controller;


import com.google.gson.Gson;
import org.apache.log4j.Logger;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.persisting.impl.db.StudentRepositoryDataBase;
import ua.od.hillel.groupManager.persisting.impl.db.utils.JNDIConnector;
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

    public StudentController() {
        try {
            studentService.setStudentRepository(new StudentRepositoryDataBase(new JNDIConnector()));
        } catch (NamingException e) {
            logger.error(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = reqest.getParameter("id");
            Student student = studentService.getById(Integer.valueOf(id));
            Gson gson = new Gson();
            response.getWriter().println(gson.toJson(student));
        } catch (Exception e) {
            logger.error(e);
            response.getWriter().println("Server internal error");
            response.setStatus(503);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Student student = gson.fromJson(req.getReader(), Student.class);
        studentService.add(student);
    }
}
