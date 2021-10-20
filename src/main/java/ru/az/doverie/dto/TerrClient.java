package ru.az.doverie.dto;

import lombok.Data;
import ru.az.doverie.db.model.Client;
import ru.az.doverie.xml.model.v2.Individual;

@Data
public class TerrClient {

    private Client client;
    private Individual individual;

    public TerrClient(Client client, Individual individual) {
        this.client = client;
        this.individual = individual;
    }

}
