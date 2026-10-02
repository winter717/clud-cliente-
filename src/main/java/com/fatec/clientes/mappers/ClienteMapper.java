package com.fatec.clientes.mappers;

import com.fatec.clientes.dtos.ClienteRequest;
import com.fatec.clientes.dtos.ClienteResponse;
import com.fatec.clientes.entities.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteRequest request) {
        Cliente c = new Cliente();
        c.setName(request.name());
        c.setAge(request.age());
        c.setEmail(request.email());
        c.setNumber(request.number());
        c.setCpf(request.cpf());

        return c;
    }

    public static ClienteResponse toDTO(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getName(),
                cliente.getAge(),
                cliente.getEmail(),
                cliente.getNumber(),
                cliente.getCpf());
    }
}
