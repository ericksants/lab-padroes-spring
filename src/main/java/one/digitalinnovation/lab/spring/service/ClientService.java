package one.digitalinnovation.lab.spring.service;

import one.digitalinnovation.lab.spring.model.Client;

/**
 * Interface que define o padrao <b>Strategy</b> no dominio de Cliente.
 * Com isso, se necessario, podemos ter multiplas implementações da mesma interface.
 *
 * @author erick
 */

public interface ClientService {
    Iterable<Client> buscarTodos();
    Client searchById(Long id);
    void insert(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
