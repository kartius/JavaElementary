package vadooss1_homework.atm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vadooss1_homework.atm.controller.DTO;
import vadooss1_homework.atm.persisting.ATMserviceDB;
import vadooss1_homework.atm.persisting.DBconnectorMySQL;
import vadooss1_homework.atm.service.ServiceATM;

import java.sql.Connection;

public class Runner {
    public static void main(String[] args) {
        DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
        Connection connection = dBconnectorMySQL.getConnection();
        //If you start the Runner at first time - delete comments and execute a line:
        //dBconnectorMySQL.resetDB(connection);
        //Then you must create objects instances in DB manually
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        DTO dto = new DTO();
        dto.atmId = 1;
        dto.cardId = 1;
        dto.cardType = "visa";
        dto.cardHasChip = false;
        dto.pinUserEnter = 1111;
        dto.serviceKindId = 7;
        dto.accountFromId = 1;
        dto.accountOnId = 2;
        dto.sumEnter = 100;
        dto.OperationSuccess = false;
        dto.message = "";
        dto.returnCard = false;

        ServiceATM serviceATM = new ServiceATM(new ATMserviceDB(connection));

        System.out.println(json.toJson(serviceATM.execute(dto)));
        System.out.println(json.toJson(new DTO()));






    }

   }


