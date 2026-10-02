package com.fatec.clientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.clientes.dtos.ClienteRequest;
import com.fatec.clientes.dtos.ClienteResponse;
import com.fatec.clientes.entities.Cliente;
import com.fatec.clientes.mappers.ClienteMapper;
import com.fatec.clientes.repositories.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteResponse findById(Long id) {
        return repository.findById(id).map(ClienteMapper::toDTO).orElseThrow(() -> new EntityNotFoundException("Cliente não cadastrado"));
    }

    public List<ClienteResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(ClienteMapper::toDTO)
                .toList();
    }

    public void deleteById(Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("Cliente não cadastrado");
    }

    public ClienteResponse save(ClienteRequest cliente) {
        Cliente c = repository.save(ClienteMapper.toEntity(cliente));
        return ClienteMapper.toDTO(c);
    }

    public void update(ClienteRequest cliente, Long id) {
        Cliente c = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não cadastrado"));

        c.setAge(cliente.age());
        c.setName(cliente.name());
        c.setEmail(cliente.email());
        c.setNumber(cliente.number());
        c.setCpf(cliente.cpf());

        repository.save(c);
    }
}
