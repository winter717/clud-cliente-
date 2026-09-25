package com.fatec.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.clientes.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
