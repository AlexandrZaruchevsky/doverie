package ru.az.doverie.api.rest;

import org.springframework.web.bind.annotation.*;
import ru.az.doverie.db.model.Client;
import ru.az.doverie.service.ClientService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/rest/clients")
@CrossOrigin("*")
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findByFio(
            @RequestParam(name = "fio", required = false, defaultValue = "") String fio
    ) throws SQLException {
        List<Client> clients;
        if ("".equals(fio.trim())) {
            clients = clientService.findAll();
        } else
            clients = clientService.findAllByFio(fio);
        return clients.stream().limit(15).collect(Collectors.toList());
    }

    @GetMapping("count")
    public Long count() throws SQLException {
        return clientService.count();
    }

}
