package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.ClienteModel; // Asegúrate de que esta importación sea correcta

public interface RepositoryCliente extends JpaRepository<ClienteModel, Long> {
}
