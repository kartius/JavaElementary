package lesson_23_servlets;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/servlet")
public class CustomServlet extends HttpServlet {

    private CustomService customService = new CustomService();
    private Gson gson = new Gson();
    final static Logger logger = Logger.getLogger(CustomServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        String id = req.getParameter("id") ;
        CustomModel model = customService.get(Integer.valueOf(id));
        resp.getWriter().println(gson.toJson(model));}
        catch (Exception e){
        logger.error(e);
        resp.getWriter().println("Server internal error");
        resp.setStatus(503);
    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomModel model = gson.fromJson(req.getReader(), CustomModel.class);
        customService.add(model);

    }
}
