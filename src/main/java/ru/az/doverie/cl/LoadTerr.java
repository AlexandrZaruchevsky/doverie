package ru.az.doverie.cl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.az.doverie.service.TerrService;
import ru.az.doverie.xml.model.v2.Individual;
import ru.az.doverie.xml.model.v2.ListOfTerr;
import ru.az.doverie.xml.model.v2.Subject;
import ru.az.doverie.xml.util.MarshallerT;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Order(1)
@Slf4j
public class LoadTerr implements CommandLineRunner {

    private final static String PARAM_FILE_IMPORT_TERR = "--fileTerr";

    private final TerrService terrService;

    public LoadTerr(TerrService terrService) {
        this.terrService = terrService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> params = Arrays.asList(args);
        String paramFileTerr = params.stream().filter(s -> s.contains(PARAM_FILE_IMPORT_TERR)).findFirst().orElse(null);
        if (params.size() != 0 && paramFileTerr != null) {
            String[] argsTerr = paramFileTerr.split("=");
            if (argsTerr.length > 1 && !"".equals(argsTerr[1].trim()) && Files.exists(Paths.get(argsTerr[1].trim()))) {
                MarshallerT<ListOfTerr> marshaller = new MarshallerT<>();
                ListOfTerr listOfTerr = marshaller.unmarshal(ListOfTerr.class, new File(argsTerr[1].trim()));
                List<Individual> terrs = listOfTerr.getListOfTerrorist().stream()
                        .map(Subject::getIndividual)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                terrService.loadAll(terrs);
                log.info("Load {} records", terrs.size());
            }
        }
    }
}
