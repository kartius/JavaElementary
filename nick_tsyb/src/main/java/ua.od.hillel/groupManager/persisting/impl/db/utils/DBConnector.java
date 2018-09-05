package ua.od.hillel.groupManager.persisting.impl.db.utils;

import java.sql.Connection;

public interface DBConnector {

    Connection getConnection();
}
