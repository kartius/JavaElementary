package vadooss1_homework.atm.persisting;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    public static String urlDB;
    public static String userDB;
    public static String passwordDB;

    static {
        try{
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        urlDB = properties.getProperty("urlDB");
        userDB = properties.getProperty("userDB");
        passwordDB = properties.getProperty("passwordDB");
    }catch(IOException e){e.printStackTrace();}
    }
}
