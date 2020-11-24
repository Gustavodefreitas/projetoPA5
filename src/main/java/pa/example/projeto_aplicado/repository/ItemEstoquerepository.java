package pa.example.projeto_aplicado.repository;

import org.springframework.stereotype.Repository;

import pa.example.projeto_aplicado.model.ItemEstoque;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface ItemEstoquerepository extends JpaRepository<ItemEstoque, Long> {
    
    @Query(value = "SELECT * FROM item_estoque WHERE produto_id = ?1 AND estoque_id = ?2", nativeQuery = true)
    Optional<ItemEstoque> findByids(Long idproduto, Long idestoque);
}
