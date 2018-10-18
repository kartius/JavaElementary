package vadooss1_homework.atm;

import com.google.gson.Gson;
import vadooss1_homework.atm.controller.DTO;
import vadooss1_homework.atm.model.ATM;
import vadooss1_homework.atm.model.Account;
import vadooss1_homework.atm.model.Card;
import vadooss1_homework.atm.persisting.ATMserviceDB;
import vadooss1_homework.atm.persisting.DAO;
import vadooss1_homework.atm.persisting.DBconnectorMySQL;

import java.sql.Connection;
import java.sql.Date;

public class Runner {
    public static void main(String[] args) {
        DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
        Connection connection = dBconnectorMySQL.getConnection();
        //dBconnectorMySQL.resetDB(connection);
        DAO dao = new DAO();
        Gson json = new Gson();
        DTO dto = new DTO();
        dto.atmId = 1;
        dto = null;
        ATMserviceDB atMserviceDB = new ATMserviceDB();
        Date date = new Date(2019, 10, 18);

        //System.out.println(json.toJson(dao.getAccount(1)));
        Card card = new Card();
        card.setId(1);
        card.setType("visa");
        card.setHasChip(false);
        card.setDateTerm(date);
        ATM atm = new ATM();
        Account ac = new Account();
        System.out.println(atMserviceDB.checkPin(1111, card));
        System.out.println(json.toJson(dto));




    }

   }


