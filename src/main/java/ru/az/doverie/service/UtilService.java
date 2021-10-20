package ru.az.doverie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.az.doverie.db.model.Client;
import ru.az.doverie.dto.TerrClient;
import ru.az.doverie.repositories.TerrRepository;
import ru.az.doverie.xml.model.v2.Individual;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilService {

    private final TerrRepository terrRepository;
    private final ClientService clientService;

    public UtilService(TerrRepository terrRepository, ClientService clientService) {
        this.terrRepository = terrRepository;
        this.clientService = clientService;
    }

    public List<Individual> findTerrIntoDb() throws SQLException {
        List<Client> clients = clientService.findAll();
        return terrRepository.findAllS()
                .filter(individual -> !clients.stream()
                        .map(client -> client.getFullName().replaceAll("\\s+", "").toUpperCase())
                        .filter(clientFio -> clientFio.equals(individual.getFio().replaceAll("\\s+", "").toUpperCase()))
                        .findFirst()
                        .equals(Optional.empty()))
                .collect(Collectors.toList());
    }

    public Long findTerrCount() throws SQLException {
        List<Client> clients = clientService.findAll();
        return terrRepository.findAllS()
                .filter(individual -> !clients.stream()
                        .map(client -> client.getFullName().replaceAll("\\s+", "").toUpperCase())
                        .filter(clientFio -> clientFio.equals(individual.getFio().replaceAll("\\s+", "").toUpperCase()))
                        .findFirst()
                        .equals(Optional.empty()))
                .count();
    }

    public List<TerrClient> findTerrClient() throws SQLException {
        List<Client> clients = clientService.findAll();
        return terrRepository.findAllS()
                .map(individual -> {
                    Optional<Client> clientTerr = clients.stream()
                            .filter(client -> client
                                    .getFullName().replaceAll("\\s+", "").toUpperCase()
                                    .equals(individual.getFio().replaceAll("\\s+", "").toUpperCase()))
                            .findFirst();
                    TerrClient terrClient = null;
                    if (clientTerr.isPresent() && !clientTerr.equals(Optional.empty())) {
                        terrClient = new TerrClient(clientTerr.get(), individual);
                    }
                    return terrClient;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

//    public Long findTerrCount() throws SQLException {
//        return (long) findTerrIntoDb().size();
//    }
//

}
