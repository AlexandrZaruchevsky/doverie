package ru.az.doverie.api.rest;

import org.springframework.web.bind.annotation.*;
import ru.az.doverie.dto.TerrClient;
import ru.az.doverie.service.TerrService;
import ru.az.doverie.service.UtilService;
import ru.az.doverie.xml.model.v2.Individual;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/rest/terrs")
@CrossOrigin("*")
public class TerrRestController {

    private final TerrService terrService;
    private final UtilService utilService;

    public TerrRestController(TerrService terrService, UtilService utilService) {
        this.terrService = terrService;
        this.utilService = utilService;
    }

    @GetMapping
    public List<Individual> findTerr(
            @RequestParam(name = "fio", required = false, defaultValue = "") String fio
    ) {
        return terrService.findByFio(fio);
    }

    @GetMapping("count")
    public Long countTerr(){
        return terrService.count();
    }

    @GetMapping("findTerr")
    public List<Individual> findTerrInDb() throws SQLException {
        return utilService.findTerrIntoDb();
    }

    @GetMapping("findTerrCount")
    public Long findTerrCount() throws SQLException {
        return utilService.findTerrCount();
    }

    @GetMapping("clientTerr")
    public List<TerrClient> clientTerr() throws SQLException {
        return utilService.findTerrClient();
    }


}
