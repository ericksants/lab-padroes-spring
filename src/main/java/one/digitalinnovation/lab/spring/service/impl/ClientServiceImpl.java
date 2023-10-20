package one.digitalinnovation.lab.spring.service.impl;

import one.digitalinnovation.lab.spring.model.Address;
import one.digitalinnovation.lab.spring.model.AddressRepository;
import one.digitalinnovation.lab.spring.model.Client;
import one.digitalinnovation.lab.spring.model.ClientRepository;
import one.digitalinnovation.lab.spring.service.ClientService;
import one.digitalinnovation.lab.spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> buscarTodos() {
        return clientRepository.findAll();
    }

    @Override
    public Client searchById(Long id) {
        Optional<Client> cliente = clientRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void insert(Client client) {
        SaveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clienteBd = clientRepository.findById(id);
        if (clienteBd.isPresent()) {
            SaveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void SaveClientWithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
