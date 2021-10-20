package ru.az.doverie.service;

import org.springframework.stereotype.Service;
import ru.az.doverie.db.factories.ClientFactory;
import ru.az.doverie.db.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final static String FIELDS = "" +
            "CLIENT_ID, " +
            "CLIENT_NAME, " +
            "CLIENT_SNAME, " +
            "CLIENT_FNAME, " +
            "CLIENT_PNAME, " +
            "CLIENT_BIRTHDAY, " +
            "CLIENT_BIRTHPLACE, " +
            "CLIENT_PASPORT, " +
            "CLIENT_PASPORT_VIDAN, " +
            "CLIENT_LEG_ADR_POSTCOD, " +
            "CLIENT_LEG_ADR_REGION_COD, " +
            "CLIENT_LEG_ADR_REGION, " +
            "CLIENT_LEG_ADR_DISTRICT, " +
            "CLIENT_LEG_ADR_LOCATION, " +
            "CLIENT_LEG_ADR_STREET, " +
            "CLIENT_LEG_ADR_HOUSE, " +
            "CLIENT_LEG_ADR_BLOCK, " +
            "CLIENT_LEG_ADR_BUILD, " +
            "CLIENT_LEG_ADR_APART ";

    private final static String TEST_QUERY = "" +
            "select " +
            FIELDS +
            "from CLIENT where CLIENT.CLIENT_ID > 0";

    private final static String CLIENT_COUNT = "select count(*) from CLIENT where CLIENT_ID > 0";
    private final static String CLIENT_FIND_ALL = "select " + FIELDS + "from CLIENT where CLIENT_ID > 0 order by CLIENT_NAME";
    private final static String CLIENT_FIND_ALL_BY_FIO = "select " + FIELDS + "from CLIENT where CLIENT_ID > 0 and UPPER(CLIENT_NAME) LIKE '=()=%' order by CLIENT_NAME";

    private final Connection connection;

    private static volatile ClientService clientService;

    public ClientService(Connection connection) {
        this.connection = connection;
    }

//    public static synchronized ClientService getInstance(Connection connection) {
//        ClientService localClientService = clientService;
//        if (localClientService == null)
//            synchronized (ClientService.class) {
//                localClientService = clientService;
//                if (localClientService == null) {
//                    clientService = localClientService = new ClientService();
//                    localClientService.connection = connection;
//                }
//            }
//        return localClientService;
//    }

    public void testQuery() throws SQLException {
        ResultSet rs = getResultset(TEST_QUERY);
        ResultSetMetaData metaData = rs.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.println(metaData.getColumnName(i));
        }
    }

    public List<Client> findAll() throws SQLException {
        ResultSet rs = getResultset(CLIENT_FIND_ALL);
        return getClients(rs);
    }

    public List<Client> findAllByFio(String fio) throws SQLException {
        ResultSet rs = getResultset(CLIENT_FIND_ALL_BY_FIO.replace("=()=", fio.toUpperCase()));
        return getClients(rs);
    }

    public synchronized Long count() throws SQLException {
        ResultSet rs = getResultset(CLIENT_COUNT);
        rs.next();
        return rs.getLong("COUNT");
    }

    private synchronized ResultSet getResultset(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
        return stmt.getResultSet();
    }

    private synchronized List<Client> getClients(ResultSet rs) throws SQLException {
        List<Client> clients = new ArrayList<>();
        while (rs.next()) {
            clients.add(ClientFactory.createFromFB15(rs));
        }
        return clients;
    }

}


