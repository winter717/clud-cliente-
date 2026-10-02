package com.fatec.clientes.dtos;

public record ClienteRequest (

    String name,
    Integer age,
    String email,
    String number,
    String cpf
) {
    
}