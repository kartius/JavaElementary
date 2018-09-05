package ua.od.hillel.groupManager.persisting.impl.db.utils;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.*;

import static ua.od.hillel.groupManager.config.ApplicationConfig.dbPassword;
import static ua.od.hillel.groupManager.config.ApplicationConfig.dbUrl;
import static ua.od.hillel.groupManager.config.ApplicationConfig.dbUser;

public class MySQLConnector implements DBConnector{
    final static Logger logger = Logger.getLogger(MySQLConnector.class);

    @Override
    public Connection getConnection() {
        PoolProperties p = new PoolProperties();
        p.setUrl(dbUrl);
        p.setDriverClassName("com.mysql.cj.jdbc.Driver");
        p.setUsername(dbUser);
        p.setPassword(dbPassword);
        p.setMaxAge(100);
        p.setInitialSize(100);
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);
        Connection connection = null;
        try {
            connection = datasource.getConnection();
        } catch (SQLException e) {
            logger.error("Connection to db is wrong ", e);
        }
        return connection;
    }
}
