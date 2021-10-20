package ru.az.doverie.db.factories;

import ru.az.doverie.db.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ClientFactory {

    private ClientFactory() {
    }

    public synchronized static Client createFromFB15(ResultSet rs) throws SQLException {
        Client client = new Client();
        /*
         * Парсинг для Firebird 1.5
         * */
        client.setId(rs.getLong(1));
        client.setFullName(trimIfNull(rs.getString(2)));
        client.setLastName(trimIfNull(rs.getString(3)));
        client.setFirstName(trimIfNull(rs.getString(4)));
        client.setMiddleName(trimIfNull(rs.getString(5)));
        try {
            client.setBirthday(LocalDate.parse(rs.getString(6).trim().substring(0, 10)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.setBirthPlace(trimIfNull(rs.getString(7)));
        client.setSerialNumberPasport(trimIfNull(rs.getString(8)));
        client.setIssuedBy(trimIfNull(rs.getString(9)));
        client.setPostCode(trimIfNull(rs.getString(10)));
        client.setRegionCode(trimIfNull(rs.getString(11)));
        client.setRegion(trimIfNull(rs.getString(12)));
        client.setDistrict(trimIfNull(rs.getString(13)));
        client.setLocation(trimIfNull(rs.getString(14)));
        client.setStreet(trimIfNull(rs.getString(15)));
        client.setHouse(trimIfNull(rs.getString(16)));
        client.setBlock(trimIfNull(rs.getString(17)));
        client.setBuild(trimIfNull(rs.getString(18)));
        client.setApart(trimIfNull(rs.getString(19)));

        /*
         * Парсинг для FireBird 2.5+
         * */
//        client.setId(rs.getLong("CLIENT_ID"));
//        client.setFullName(rs.getString("CLIENT_NAME").trim().replaceAll("\\s+", " "));
//        client.setLastName(rs.getString("CLIENT_SNAME").trim().replaceAll("\\s+", " "));
//        client.setFirstName(rs.getString("CLIENT_FNAME").trim().replaceAll("\\s+", " "));
//        client.setMiddleName(rs.getString("CLIENT_PNAME").trim().replaceAll("\\s+", " "));
//        client.setBirthday(LocalDate.parse(rs.getString("CLIENT_BIRTHDAY").trim().substring(0, 10)));
//        client.setBirthday(LocalDate.now());
        return client;
    }

    private synchronized static String trimIfNull(String s) {
        return s != null ? s.trim() : null;
    }

}
