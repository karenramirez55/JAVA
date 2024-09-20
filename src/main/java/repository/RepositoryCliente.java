package repository;

import models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository <ClienteModel, Long> {
}
//ver si es a ClienteModel que le tiene que pegar o a otra clase Cliente