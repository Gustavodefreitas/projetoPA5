package pa.example.projeto_aplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pa.example.projeto_aplicado.model.Produto;

public interface Produtorepository extends JpaRepository<Produto, Long> {
    
}
