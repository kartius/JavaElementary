package vadooss1_homework.atm.persisting;

import vadooss1_homework.atm.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    private DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
    private Connection connection = dBconnectorMySQL.getConnection();

    public Account getAccount(int id){
        Account account = new Account();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.account WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                account.setId(resultSet.getInt("id"));
                account.setBalance(resultSet.getDouble("balance"));}
                preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
    public ATM getATM(int id){
        return null;
    }
    public Card getCard(int id){
        return null;
    }
    public Money getMoney(int id){
        return null;
    }
    public Service getService(int id){
        return null;
    }
    public Transactions getTransactions(int id){
        return null;
    }
    public User getUser(int id){
        return null;
    }

}
