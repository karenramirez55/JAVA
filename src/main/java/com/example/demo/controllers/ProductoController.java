package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ProductoModel;
import com.example.demo.repository.RepositoryProducto;

@RestController
public class ProductoController {
    
    @Autowired
    private RepositoryProducto repoProducto;

    //Lista productos

    @GetMapping("/productos")
    public List <ProductoModel> getId_producto() {
        return repoProducto.findAll();
    }

    //Alta producto

    @PostMapping("/alta-producto")
    public String post (@RequestBody ProductoModel productoModel){
        repoProducto.save(productoModel);
        return "Guardado correctamente";
    }

    //Modificar productos

    //@PutMapping("modificar-producto/{id}")

    //Eliminar producto
    @DeleteMapping("eliminar-producto/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id){
        try {
            Optional<ProductoModel> optionalProducto = repoProducto.findById(id);
            if (optionalProducto.isPresent()) {
                ProductoModel deleteProductoModel = optionalProducto.get();
                repoProducto.delete(deleteProductoModel);
                return ResponseEntity.ok("Producto eliminado exitosamente");
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el producto");
        }
    }




}
