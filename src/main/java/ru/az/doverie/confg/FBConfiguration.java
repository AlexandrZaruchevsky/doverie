package ru.az.doverie.confg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.az.doverie.db.FBConnection;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class FBConfiguration {

    @Value("${firebird.url}")
    private String FB_DB_URL;
    @Value("${firebird.user}")
    private String FB_DB_USER;
    @Value("${firebird.password}")
    private String FB_DB_PASSWORD;
    @Value("${firebird.encoding}")
    private String FB_DB_ENCODING;

    @Bean
    public Connection getConnection() throws SQLException, ClassNotFoundException {
            return getFBConnection().getConnection();
    }

    @Bean
    public FBConnection getFBConnection(){
        return FBConnection.getInstance(FB_DB_URL, FB_DB_USER, FB_DB_PASSWORD, FB_DB_ENCODING);
    }

}
