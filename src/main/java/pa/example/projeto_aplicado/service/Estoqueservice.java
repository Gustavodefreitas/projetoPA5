package pa.example.projeto_aplicado.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.example.projeto_aplicado.model.Estoque;
import pa.example.projeto_aplicado.repository.Estoquerepository;

@Service
public class Estoqueservice {
    @Autowired
    private Estoquerepository estoques;

    public Iterable<Estoque> getAllEstoque(){
        return estoques.findAll();

    }

    public Estoque getEstoquebyID(long id){
        Optional<Estoque> op = estoques.findById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não cadastrado"));
    }

    public Estoque salvarEstoque(Estoque estoque){

        return estoques.save(estoque);
    }

    public void deletarEstoquebyID(long id){
        Estoque estoque = getEstoquebyID(id);

        estoques.delete(estoque);
    }

    public Estoque alterarEstoque(long id, Estoque estoque){
        Estoque newestoque = getEstoquebyID(id);
        
        if(estoque.getDatadeentrada() != null)
            newestoque.setDatadeentrada(estoque.getDatadeentrada());
        if(estoque.getDatadesaida() != null)
            newestoque.setDatadesaida(estoque.getDatadesaida());
        if(estoque.getQtdproduto() != 0)
            newestoque.setQtdproduto(estoque.getQtdproduto());
        if(estoque.getVolume() != 0)
            newestoque.setVolume(estoque.getVolume());    
        
        return estoques.save(newestoque);
  
    }
}
