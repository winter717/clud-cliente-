package com.fatec.clientes.dtos;

public record ClienteResponse(

        Long id,
        String name,
        Integer age,
        String email,
        String number,
        String cpf) {

}