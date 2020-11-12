package pa.example.projeto_aplicado.repository;

import org.springframework.stereotype.Repository;

import pa.example.projeto_aplicado.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface Clientesrepository extends JpaRepository<Cliente, Long>{
    
}
