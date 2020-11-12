package pa.example.projeto_aplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pa.example.projeto_aplicado.model.Produto;

@Repository
public interface Produtorepository extends JpaRepository<Produto, Long> {
    
}
