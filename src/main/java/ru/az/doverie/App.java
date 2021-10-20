package ru.az.doverie;

import ru.az.doverie.xml.model.v2.ListOfTerr;
import ru.az.doverie.xml.util.MarshallerT;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class App {

    private final static String PARAM_FILE_IMPORT_TERR = "--fileTerr";

    private final static String FB_DB_URL = "jdbc:firebirdsql://s039023d:3050/c:/firebird/base/shenk_dov.GDB";
    private final static String FB_DB_USER = "SYSDBA";
    private final static String FB_DB_PASSWORD = "masterkey";
    private final static String FB_DB_ENCODING = "WIN1251";


    public static void main(String[] args) throws JAXBException {
        List<String> params = Arrays.asList(args);
        String paramFileTerr = params.stream().filter(s -> s.contains(PARAM_FILE_IMPORT_TERR)).findFirst().orElse(null);
        if (params.size() != 0 && paramFileTerr != null) {
            String[] argsTerr = paramFileTerr.split("=");
            if (argsTerr.length > 1 && !"".equals(argsTerr[1].trim()) && Files.exists(Paths.get(argsTerr[1].trim()))) {
                MarshallerT<ListOfTerr> marshaller = new MarshallerT<>();
                ListOfTerr listOfTerr = marshaller.unmarshal(ListOfTerr.class, new File(argsTerr[1].trim()));

//                Connection connection = FBConnection.getInstance(FB_DB_URL, FB_DB_USER, FB_DB_PASSWORD, FB_DB_ENCODING).getConnection();
//                ClientService clientService = ClientService.getInstance(connection);
//                clientService.findAllByFio("боты").forEach(System.out::println);
//                List<Client> clients = clientService.findAll();

//                System.out.println(LocalDateTime.now());
//                List<String> collect = listOfTerr.getListOfTerrorist().parallelStream()
//                        .filter(subject -> subject.getIndividual() != null)
//                        .map(Subject::getIndividual)
//                        .map(individual -> individual.getFio().replaceAll("\\s+", "").toUpperCase())
//                        .filter(fioTerr -> !clients.stream()
//                                .map(client -> client.getFullName().replaceAll("\\s+", "").toUpperCase())
//                                .filter(clientFio -> clientFio.equals(fioTerr))
//                                .findFirst()
//                                .equals(Optional.empty()))
//                        .collect(Collectors.toList());
//                System.out.println(LocalDateTime.now());
//                connection.close();

//                System.out.println(marshaller.unmarshal(ListOfTerr.class, new File(argsTerr[1].trim())).getListOfTerrorist().get(1));
            }
        }
//        Connection connection = FBConnection.getInstance(FB_DB_URL, FB_DB_USER, FB_DB_PASSWORD, FB_DB_ENCODING).getConnection();
//        ClientService instance = ClientService.getInstance(connection);
//        instance.findAll().forEach(System.out::println);
//        System.out.println(instance.count());
//        connection.close();
    }

}
