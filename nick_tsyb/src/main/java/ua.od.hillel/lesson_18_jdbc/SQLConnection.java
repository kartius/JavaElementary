package ua.od.hillel.lesson_18_jdbc;

import java.sql.*;

import static ua.od.hillel.groupManager.config.ApplicationConfig.dbPassword;
import static ua.od.hillel.groupManager.config.ApplicationConfig.dbUrl;
import static ua.od.hillel.groupManager.config.ApplicationConfig.dbUser;

public class SQLConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test (id) VALUES (?)");
            preparedStatement.setInt(1, 45);

            preparedStatement.executeUpdate();

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
