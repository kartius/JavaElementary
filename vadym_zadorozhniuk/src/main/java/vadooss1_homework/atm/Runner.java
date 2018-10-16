package vadooss1_homework.atm;

import com.google.gson.Gson;
import vadooss1_homework.atm.persisting.DAO;
import vadooss1_homework.atm.persisting.DBconnectorMySQL;

import java.sql.Connection;

public class Runner {
    public static void main(String[] args) {
        DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
        Connection connection = dBconnectorMySQL.getConnection();
        dBconnectorMySQL.resetDB(connection);
        DAO dao = new DAO();
        Gson json = new Gson();

        //System.out.println(json.toJson(dao.getAccount(1)));

    }
}
