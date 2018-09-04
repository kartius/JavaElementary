package ua.od.hillel.groupManager.controller;


import com.google.gson.Gson;
import org.apache.log4j.Logger;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/subject")

public class SubjectController extends HttpServlet {

    final static Logger logger = Logger.getLogger(StudentController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Subject subject = gson.fromJson(req.getReader(), Subject.class);
        logger.info(subject.getName());
    }
}
