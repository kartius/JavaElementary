package vadooss1_homework.atm.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import vadooss1_homework.atm.persisting.ATMserviceDB;
import vadooss1_homework.atm.persisting.DBconnectorMySQL;
import vadooss1_homework.atm.service.ServiceATM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/atm")
public class Controller extends HttpServlet {

    final static Logger logger = Logger.getLogger(Controller.class);
    DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
    Connection connection = dBconnectorMySQL.getConnection();
    ServiceATM serviceATM = new ServiceATM(new ATMserviceDB(connection));
    Gson json = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DTO dto = new DTO();
        try {
            dto.atmId = Integer.valueOf(req.getParameter("atmId"));
            dto.cardId = Long.valueOf(req.getParameter("cardId"));
            dto.cardType = req.getParameter("cardType");
            dto.cardHasChip = Boolean.valueOf(req.getParameter("cardHasChip"));
            dto.pinUserEnter = Short.valueOf(req.getParameter("pinUserEnter"));
            dto.serviceKindId = Integer.valueOf(req.getParameter("serviceKindId"));
            dto.accountFromId = Integer.valueOf(req.getParameter("accountFromId"));
            dto.accountOnId = Integer.valueOf(req.getParameter("accountOnId"));
            dto.sumEnter = Double.valueOf(req.getParameter("sumEnter"));
            dto.OperationSuccess = false;
            dto.message = "";
            dto.returnCard = false;
            dto = serviceATM.execute(dto);
            resp.getWriter().println(json.toJson(dto));
        }catch (Exception e){
            logger.error(e);
            resp.getWriter().println("Server error");
            resp.setStatus(503);}
        }
}
