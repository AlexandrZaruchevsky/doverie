package ru.az.doverie.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FBConnection {

    private static volatile FBConnection fbConnection;

    private String dbPath;
    private String dbUser;
    private String dbPassword;
    private String dbEncoding;

    private final static String DRIVER_NAME = "org.firebirdsql.jdbc.FBDriver";

    private FBConnection() {
    }

    public static synchronized FBConnection getInstance(String dbPath, String dbUser, String dbPassword, String dbEncoding) {
        FBConnection localFbConnection = fbConnection;
        if (localFbConnection == null)
            synchronized (FBConnection.class) {
                localFbConnection = fbConnection;
                if (localFbConnection == null) {
                    fbConnection = localFbConnection = new FBConnection();
                    localFbConnection.dbPath = dbPath;
                    localFbConnection.dbUser = dbUser;
                    localFbConnection.dbPassword = dbPassword;
                    localFbConnection.dbEncoding = dbEncoding;
                }
            }
        return localFbConnection;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_NAME);
        Properties properties = new Properties();
        properties.setProperty("user", dbUser);
        properties.setProperty("password", dbPassword);
        properties.setProperty("encoding", dbEncoding);
        return DriverManager.getConnection(dbPath, properties);
    }

}
