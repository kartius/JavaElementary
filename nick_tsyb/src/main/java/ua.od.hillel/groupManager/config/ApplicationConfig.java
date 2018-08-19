package ua.od.hillel.groupManager.config;

import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {

    static {
        try {
            Properties properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
            user = properties.getProperty("user");
            dbUrl = properties.getProperty("db_url");
            dbUser = properties.getProperty("db_user");
            dbPassword = properties.getProperty("db_password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String user;
    public static String dbUrl;
    public static String dbUser;
    public static String dbPassword;
}
