package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.ProductoModel;

public interface RepositoryProducto extends JpaRepository <ProductoModel, Long>{
}
