package ru.az.doverie.repositories;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.az.doverie.xml.model.v2.Individual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Data
public class TerrRepository {

    private List<Individual> individuals = new ArrayList<>();

    public List<String> findAll() {
        return getIndividuals().stream()
                .map(Individual::getFio)
                .collect(Collectors.toList());
    }
    public List<String> findByFio(String fio) {
        return getIndividuals().stream()
                .map(Individual::getFio)
                .filter(fioTerr -> fioTerr.toLowerCase().trim().startsWith(fio.toLowerCase().trim()))
                .collect(Collectors.toList());
    }

    public Stream<Individual> findAllStream() {
        return getIndividuals().stream();
    }

    public Stream<Individual> findByFioStream(String fio) {
        return getIndividuals().stream()
                .filter(individual -> individual.getFio().toLowerCase().trim().startsWith(fio.toLowerCase().trim()));
//        return getIndividuals().stream()
//                .map(Individual::getFio)
//                .filter(fioTerr -> fioTerr.toLowerCase().trim().startsWith(fio.toLowerCase().trim()));
    }

    public Stream<Individual> findAllS(){
        return getIndividuals().parallelStream();
    }

    public Long findCountTerr(){
        return findAllS().count();
    }

}
