package ua.od.hillel.groupManager.config;

import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {

    static {
        try {
            Properties properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
            user = properties.getProperty("user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String user;
}
