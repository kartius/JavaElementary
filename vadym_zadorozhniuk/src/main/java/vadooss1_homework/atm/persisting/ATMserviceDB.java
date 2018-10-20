package vadooss1_homework.atm.persisting;

import vadooss1_homework.atm.model.ATM;
import vadooss1_homework.atm.model.Account;
import vadooss1_homework.atm.model.Card;
import vadooss1_homework.atm.model.Transactions;


import java.sql.*;

public class ATMserviceDB implements ATMserviceRepository {
    Connection connection;

    public ATMserviceDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String checkCard(long cardId, String cardType) {
        if(cardId == 0){
            return "Insert card correctly! Result:false";
        }
        if (cardId!=DAO.getCard(cardId).getId()||!cardType.equals(DAO.getCard(cardId).getType())){
            return "Wrong card! Result:false";
        }
        Card card = DAO.getCard(cardId);
        Date nowdate = new Date(System.currentTimeMillis());
        if (card.getDateTerm().before(nowdate)){
            return "Card expired! Result:false";
        }
        if (!card.getLockReason().equals("absent")||card.getEnterPin()>3){
            return "Card is locked! Result:false";
        }

        return "Card is correct. Result:true";
    }

    @Override
    public boolean checkPin(int pin, long cardId) {
        Card card = DAO.getCard(cardId);
        if (pin==card.getPin()){
            return true;}
            else
                {card.setEnterPin(card.getEnterPin()+1);
                DAO.setCard(card);
                if (card.getEnterPin()>=3){
                    card.setLockReason("Pin was entered more than 3 times");
                    DAO.setCard(card);
                }
                return false;
        }
    }

    @Override
    public String transferMoney(int fromAccountId, int toAccountId, double sum, int serviceId) {
        Account account1 = DAO.getAccount(fromAccountId);
        Account account2 = DAO.getAccount(toAccountId);
        Transactions transaction  = new Transactions();
        Timestamp date = new Timestamp(System.currentTimeMillis());
        transaction.setDate(date);
        transaction.setServiceId(serviceId);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.account WHERE id = ?");
            preparedStatement.setInt(1,account1.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                transaction.setUserId(resultSet.getInt("fk_id_user"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(account1.getBalance()>=sum){
            account1.setBalance(account1.getBalance()-sum);
            account2.setBalance(account2.getBalance()+sum);
            DAO.setAccount(account1);
            DAO.setAccount(account2);
            transaction.setSuccessTrans(true);
            DAO.addTransaction(transaction);
            return "Transfer is successful! Result:true";
        }else
            {transaction.setSuccessTrans(false);
                DAO.addTransaction(transaction);
                return "Transfer is impossible! Result:false";
            }
    }

    @Override
    public String getCash(int atmId, int fromAccountId, int sum, int serviceId) {
        ATM atm = DAO.getATM(atmId);
        Account account = DAO.getAccount(fromAccountId);
        Transactions transaction  = new Transactions();
        Timestamp date = new Timestamp(System.currentTimeMillis());
        transaction.setDate(date);
        transaction.setServiceId(serviceId);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.account WHERE id = ?");
            preparedStatement.setInt(1,account.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                transaction.setUserId(resultSet.getInt("fk_id_user"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(account.getBalance()>=sum&&atm.getCash()>=sum){
            account.setBalance(account.getBalance()-sum);
            atm.setCash(atm.getCash()-sum);
            DAO.setAccount(account);
            DAO.setATM(atm);
            transaction.setSuccessTrans(true);
            DAO.addTransaction(transaction);
            return "Take money! Result:true";
        }else if(atm.getCash()<sum){
            transaction.setSuccessTrans(false);
            DAO.addTransaction(transaction);
            return "There is not full amount of cash in the ATM! Result:false";}
            else if (account.getBalance()<sum){
            transaction.setSuccessTrans(false);
            DAO.addTransaction(transaction);
            return "The account has not full amount of money! Result:false";}

        return "Result:false";
    }

    @Override
    public double getBalanceOnScreen(int fromAccountId, int serviceId) {
        Account account = DAO.getAccount(fromAccountId);
        Transactions transaction  = new Transactions();
        Timestamp date = new Timestamp(System.currentTimeMillis());
        transaction.setDate(date);
        transaction.setServiceId(serviceId);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.account WHERE id = ?");
            preparedStatement.setInt(1,account.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                transaction.setUserId(resultSet.getInt("fk_id_user"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        transaction.setSuccessTrans(true);
        DAO.addTransaction(transaction);
        return account.getBalance();
    }

    @Override
    public String getBalanceInSMS(int fromAccountId, int serviceId) {
        String phone = "";
        Account account = DAO.getAccount(fromAccountId);
        Transactions transaction  = new Transactions();
        Timestamp date = new Timestamp(System.currentTimeMillis());
        transaction.setDate(date);
        transaction.setServiceId(serviceId);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.account " +
                    "LEFT JOIN autoteller_machine.user ON account.fk_id_user = user.id WHERE account.id = ?");
            preparedStatement.setInt(1,account.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                transaction.setUserId(resultSet.getInt("fk_id_user"));
                phone = resultSet.getString("phone");
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        transaction.setSuccessTrans(true);
        DAO.addTransaction(transaction);
        return phone + " sent SMS(Your balance has " + account.getBalance() + " money). Result:true";
    }

    @Override
    public String getBalancePrint(int fromAccountId, int serviceId) {
        Account account = DAO.getAccount(fromAccountId);
        Transactions transaction  = new Transactions();
        Timestamp date = new Timestamp(System.currentTimeMillis());
        transaction.setDate(date);
        transaction.setServiceId(serviceId);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.account WHERE id = ?");
            preparedStatement.setInt(1,account.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                transaction.setUserId(resultSet.getInt("fk_id_user"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        transaction.setSuccessTrans(true);
        DAO.addTransaction(transaction);
        return "Balance of account" + account.getId() + "  " + account.getBalance() + " money. Result:true";
    }

    @Override
    public String returnCard(long cardId) {
        Card card = DAO.getCard(cardId);
        card.setEnterPin(0);
        DAO.setCard(card);
        return "Card is returned! Result:true";
    }
}
