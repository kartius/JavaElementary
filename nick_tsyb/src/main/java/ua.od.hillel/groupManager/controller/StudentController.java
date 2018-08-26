package ua.od.hillel.groupManager.controller;


import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.persisting.impl.db.StudentRepositoryDataBase;
import ua.od.hillel.groupManager.persisting.impl.db.utils.MySQLConnector;
import ua.od.hillel.groupManager.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student")
public class StudentController extends HttpServlet {

    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        studentService.setStudentRepository(new StudentRepositoryDataBase(new MySQLConnector()));
        String id = reqest.getParameter("id");
        response.getWriter().println("Hello World! " + id);
        Student byId = studentService.getById(Integer.valueOf(id));
        System.out.println(byId.getName());
        System.out.println(byId.getId());

    }

}
