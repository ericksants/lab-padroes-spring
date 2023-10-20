package one.digitalinnovation.lab.spring.controller;

import one.digitalinnovation.lab.spring.model.Client;
import one.digitalinnovation.lab.spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de interações (Banco de Dados H2 e API ViaCep) em uma interface simples e coesa (API Rest).
 *
 */


@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> buscarTodos() {
        return ResponseEntity.ok(clientService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.searchById(id));

    }
    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client){
        clientService.insert(client);
        return ResponseEntity.ok(client);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id,@RequestBody Client client){
        clientService.update(id,client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
