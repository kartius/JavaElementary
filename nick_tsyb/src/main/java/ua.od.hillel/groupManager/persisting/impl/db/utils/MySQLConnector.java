package ua.od.hillel.groupManager.persisting.impl.db.utils;

import java.sql.*;

public class MySQLConnector {

    public MySQLConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection result = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_manager?serverTimezone=UTC&useSSL=false", "root", "password")) {
            result = connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_manager?serverTimezone=UTC&useSSL=false", "root", "password");

            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test (id) VALUES (?)");
            preparedStatement.setInt(1, 45);

            preparedStatement.executeUpdate();
//
//            int resultSet = statement.executeUpdate("INSERT INTO test (id) VALUES (4)");
//            System.out.println(resultSet);

            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM test");
            while (resultSet1.next()) {
                int id = resultSet1.getInt("id");
                System.out.println(id);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
