package com.example.demo.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @GetMapping("/clientes")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("conectado");
    }

}

