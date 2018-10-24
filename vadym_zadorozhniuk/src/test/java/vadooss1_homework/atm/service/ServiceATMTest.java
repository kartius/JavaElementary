package vadooss1_homework.atm.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import vadooss1_homework.atm.controller.DTO;
import vadooss1_homework.atm.persisting.ATMserviceDB;
import vadooss1_homework.atm.persisting.DBconnectorMySQL;

//The test works with real data of a present DB
public class ServiceATMTest {

    private ServiceATM serviceATM;

    @Before
    public void setUp(){
        DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
        serviceATM = new ServiceATM(new ATMserviceDB(dBconnectorMySQL.getConnection()));
    }

    @Test
    public void executeGet(){
        DTO dto1 = new DTO();
        dto1.serviceKindId=1; dto1.cardId = 1; dto1.cardType = "visa";
        DTO dto2 = new DTO();
        dto2.serviceKindId=2; dto2.pinUserEnter=1111; dto2.cardId=1;
        DTO dto3 = new DTO();
        dto3.serviceKindId=3; dto3.atmId = 1; dto3.accountFromId = 1; dto3.sumEnter = 100;
        DTO dto4 = new DTO();
        dto4.serviceKindId=4;dto4.accountFromId = 1;dto4.accountOnId=2;dto4.sumEnter=100;
        DTO dto5 = new DTO();
        dto5.serviceKindId=5; dto5.accountFromId = 1;
        DTO dto6 = new DTO();
        dto6.serviceKindId=6; dto6.accountFromId = 1;
        DTO dto7 = new DTO();
        dto7.serviceKindId=7; dto7.accountFromId = 1;
        DTO dto8 = new DTO();
        dto8.serviceKindId=8; dto8.cardId = 1;
        assertEquals(true, serviceATM.execute(dto1).OperationSuccess);
        assertEquals(true, serviceATM.execute(dto2).OperationSuccess);
        assertEquals(true, serviceATM.execute(dto3).OperationSuccess);
        assertEquals(true, serviceATM.execute(dto4).OperationSuccess);
        assertEquals(true, serviceATM.execute(dto5).OperationSuccess);
        assertEquals(true, serviceATM.execute(dto6).OperationSuccess);
        assertEquals(true, serviceATM.execute(dto7).OperationSuccess);
        assertEquals(true, serviceATM.execute(dto8).returnCard);
    }

}
