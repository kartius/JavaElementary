package vadooss1_homework.atm.persisting;

import vadooss1_homework.atm.model.ATM;
import vadooss1_homework.atm.model.Account;
import vadooss1_homework.atm.model.Card;


import java.sql.*;

public class ATMserviceDB implements ATMserviceRepository {
    DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
    Connection connection = dBconnectorMySQL.getConnection();

    @Override
    public boolean checkCard(Card card) {
        Date nowdate = new Date(2018, 10, 18);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.card WHERE id = ?" +
                                        " && type = ? && hasChip = ? && dateTerm >= ? && lockReason IS NULL || lockReason < '3'");
            preparedStatement.setLong(1, card.getId());
            preparedStatement.setString(2, card.getType());
            preparedStatement.setBoolean(3, card.getHasChip());
            preparedStatement.setDate(4, nowdate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                preparedStatement.close();
                return true;}
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkPin(int pin, Card card) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.card WHERE id = ? && pin = ?");
            preparedStatement.setLong(1, card.getId());
            preparedStatement.setInt(2,pin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                preparedStatement.close();
                return true;}
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE autoteller_machine.card SET lockReason = lockReason + 1 WHERE id = ?");
            preparedStatement.setLong(1, card.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void transferMoney(Account ac1, Account ac2, double sum) {

    }

    @Override
    public void getCash(ATM atm, Account ac, int sum) {

    }

    @Override
    public double getBalanceOnScreen(Account ac) {
        return 0;
    }

    @Override
    public double getBalanceInSMS(Account ac) {
        return 0;
    }

    @Override
    public double getBalancePrint(Account ac) {
        return 0;
    }
}
