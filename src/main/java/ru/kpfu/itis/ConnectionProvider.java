package ru.kpfu.itis;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.kpfu.itis.exeptions.DBExeption;

import javax.sql.DataSource;

public class ConnectionProvider {
    private static ConnectionProvider _instance;
    private final DriverManagerDataSource dataSource;
    private static final String DB_USERNAME = "landreas";
    private static final String DB_PASSWORD = "Cirilla15683#$";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/webappdb";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    private ConnectionProvider() throws DBExeption {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);
    }

    public static ConnectionProvider getInstance() throws DBExeption {
        if (_instance == null)
            _instance = new ConnectionProvider();
        return _instance;
    }

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }
}
