package ru.az.doverie.service;

import org.springframework.stereotype.Service;
import ru.az.doverie.repositories.TerrRepository;
import ru.az.doverie.xml.model.v2.Individual;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TerrService {

    private final TerrRepository terrRepository;

    public TerrService(TerrRepository terrRepository) {
        this.terrRepository = terrRepository;
    }

    public List<Individual> findByFio(String fio) {
        Stream<Individual> byFio = fio != null && !"".equals(fio.trim())
                ? terrRepository.findByFioStream(fio)
                : terrRepository.findAllStream();
        return byFio.limit(15).collect(Collectors.toList());
    }

    public List<Individual> findByFio(String fio, Long limit) {
        Stream<Individual> byFio = fio != null && !"".equals(fio.trim())
                ? terrRepository.findByFioStream(fio)
                : terrRepository.findAllStream();
        return byFio.limit(limit).collect(Collectors.toList());
    }

    public List<Individual> loadAll(List<Individual> individuals) {
        terrRepository.setIndividuals(individuals);
        return terrRepository.getIndividuals();
    }

    public Long count(){
        return terrRepository.findCountTerr();
    }

}
