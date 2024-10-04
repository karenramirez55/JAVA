package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ClienteModel; 
import com.example.demo.repository.RepositoryCliente;
import com.example.demo.services.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private RepositoryCliente repo;

    @Autowired
    private ClienteService clienteService;

    //usa dos Autowired porque usa lo de jpa y controller hace match con services
    
    //Lista de clientes

    @GetMapping("/clientes")
    public List<ClienteModel> getId_cliente() {
        return repo.findAll();
    }
 
    //Alta cliente

    @PostMapping("/alta")
    public String post (@RequestBody ClienteModel clienteModel){
        repo.save(clienteModel);
        return "Guardado exitosamente";
    }

    //Modificar Cliente

    @PutMapping("modificar/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Long id, @RequestBody ClienteModel clienteModel) {
    try {
        Optional<ClienteModel> optionalCliente = repo.findById(id);
        if (optionalCliente.isPresent()) {
            ClienteModel updateClienteModel = optionalCliente.get();
            updateClienteModel.setNombre(clienteModel.getNombre());
            updateClienteModel.setEmail(clienteModel.getEmail());
            updateClienteModel.setDireccion(clienteModel.getDireccion());
            updateClienteModel.setApellido(clienteModel.getApellido());
            repo.save(updateClienteModel);
            return ResponseEntity.ok("Modificado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar el cliente");
    }

    //Eliminar un cliente (completo con service y controller)
    
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        try {
            return clienteService.deleteCliente(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el cliente");
        }
    }
    
    
    
    
    
    


    
}
