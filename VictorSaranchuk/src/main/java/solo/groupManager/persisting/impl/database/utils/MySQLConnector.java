package solo.groupManager.persisting.impl.database.utils;

import org.apache.log4j.Logger;
import java.sql.*;

import static solo.groupManager.configuration.Config.dbPassword;
import static solo.groupManager.configuration.Config.dbUser;
import static solo.groupManager.configuration.Config.dbUrl;

public class MySQLConnector {
    final static Logger logger=Logger.getLogger(MySQLConnector.class);

    public  MySQLConnector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            logger.error("Wrong driver ", e);
        }
    }

    public Connection getConnection(){
        Connection connection=null;
        try{
            connection=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        }catch (SQLException e){
            logger.error("Wrong connection database ",e);
        }return connection;
    }

}
