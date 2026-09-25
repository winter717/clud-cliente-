package com.fatec.clientes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fatec.clientes.entities.Cliente;
import com.fatec.clientes.repositories.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("Produto não cadastrado");
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public void update(Cliente cliente, Long id) {
        Cliente p = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não cadastrado"));

        p.setAge(cliente.getAge());
        p.setName(cliente.getName());
        p.setWeight(cliente.getWeight());
        p.setEmail(cliente.getEmail());

        repository.save(p);

    }
}
