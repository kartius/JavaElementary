package ua.od.hillel.groupManager.persisting.impl.db.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JNDIConnector implements DBConnector {

    Context initContext = new InitialContext();
    DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/mysql");

    public JNDIConnector() throws NamingException {
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (initContext != null) {
                try {
                    initContext.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }
}
