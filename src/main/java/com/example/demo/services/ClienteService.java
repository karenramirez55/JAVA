package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.demo.models.ClienteModel;
import com.example.demo.repository.RepositoryCliente;


@Service
public class ClienteService {

    @Autowired
    private RepositoryCliente repoService;
    
    //Eliminar un cliente

    public ResponseEntity<String> deleteCliente(Long id) {
    Optional<ClienteModel> optionalCliente = repoService.findById(id);
    if (optionalCliente.isPresent()) {
        ClienteModel deleteClienteModel = optionalCliente.get();
        repoService.delete(deleteClienteModel);
        return ResponseEntity.ok("Eliminado exitosamente");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
    }
}


    //Modificar cliente

    

}

