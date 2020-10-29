package pa.example.projeto_aplicado.repository;

import org.springframework.data.repository.CrudRepository;

import pa.example.projeto_aplicado.model.Produto;

public interface Estoque extends CrudRepository<Produto, String>{
    Produto findByid(long id);
    void deleteByid(long id);
    
}
