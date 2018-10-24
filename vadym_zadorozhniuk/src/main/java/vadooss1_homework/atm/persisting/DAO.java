package vadooss1_homework.atm.persisting;

import vadooss1_homework.atm.model.*;

import java.sql.*;

public class DAO {
    private static DBconnectorMySQL dBconnectorMySQL = new DBconnectorMySQL();
    private static Connection connection = dBconnectorMySQL.getConnection();

    public static Account getAccount(int id){
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

    public static void setAccount(Account account){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE autoteller_machine.account SET balance = ? WHERE id = ?");
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static ATM getATM(int id){
        ATM atm = new ATM();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.atm WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                atm.setId(resultSet.getInt("id"));
                atm.setCash(resultSet.getInt("cashTotal"));}
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atm;
    }
    public static void setATM(ATM atm){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE autoteller_machine.atm SET cashTotal = ? WHERE id = ?");
            preparedStatement.setInt(1, atm.getCash());
            preparedStatement.setInt(2, atm.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Card getCard(long id){
        Card card = new Card();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.card WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                card.setId(resultSet.getLong("id"));
                card.setPin(resultSet.getInt("pin"));
                card.setType(resultSet.getString("type"));
                card.setHasChip(resultSet.getBoolean("hasChip"));
                card.setDateTerm(resultSet.getDate("dateTerm"));
                card.setLockReason(resultSet.getString("lockReason"));
                card.setEnterPin(resultSet.getInt("enterPin"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    public static void setCard(Card card){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE autoteller_machine.card SET pin = ?, type = ?," +
                    " hasChip = ?, dateTerm = ?, lockReason = ?, enterPin = ?  WHERE id = ?");
            preparedStatement.setInt(1, card.getPin());
            preparedStatement.setString(2, card.getType());
            preparedStatement.setBoolean(3, card.getHasChip());
            preparedStatement.setDate(4, card.getDateTerm());
            preparedStatement.setString(5, card.getLockReason());
            preparedStatement.setInt(6, card.getEnterPin());
            preparedStatement.setLong(7, card.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Money getMoney(int id){
        Money money = new Money();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.money WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                money.setId(resultSet.getInt("id"));
                money.setPar(resultSet.getInt("par"));}
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return money;
    }

    public static void setMoney(Money money){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE autoteller_machine.money SET par = ? WHERE id = ?");
            preparedStatement.setInt(1, money.getPar());
            preparedStatement.setInt(2, money.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Service getService(int id){
        Service service = new Service();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.service WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                service.setId(resultSet.getInt("id"));
                service.setServiceKind(resultSet.getString("serviceKind"));}
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public static void setService(Service service){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE autoteller_machine.service SET serviceKind = ? WHERE id = ?");
            preparedStatement.setString(1, service.getServiceKind());
            preparedStatement.setInt(2, service.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Transactions getTransaction(int id){
        Transactions transaction = new Transactions();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.transactions WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                transaction.setId(resultSet.getInt("id"));
                transaction.setDate(resultSet.getTimestamp("date"));
                transaction.setSuccessTrans(resultSet.getBoolean("successTrans"));
                transaction.setUserId(resultSet.getInt("fk_id_user"));
                transaction.setServiceId(resultSet.getInt("fk_id_service"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    public static void addTransaction(Transactions transaction){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO autoteller_machine.transactions(date, successTrans, fk_id_user, fk_id_service) values (?, ?, ?, ?)");
            preparedStatement.setTimestamp(1, transaction.getDate());
            preparedStatement.setBoolean(2, transaction.getSuccessTrans());
            preparedStatement.setInt(3, transaction.getUserId());
            preparedStatement.setInt(4, transaction.getServiceId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static User getUser(int id){
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autoteller_machine.user WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhone(resultSet.getString("phone"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void setUser(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE autoteller_machine.user SET name = ?, surname = ?, phone = ? WHERE id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
