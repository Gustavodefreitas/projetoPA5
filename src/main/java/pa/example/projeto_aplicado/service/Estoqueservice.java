package pa.example.projeto_aplicado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.example.projeto_aplicado.model.Estoque;
import pa.example.projeto_aplicado.model.ItemEstoque;
import pa.example.projeto_aplicado.repository.Estoquerepository;
import pa.example.projeto_aplicado.repository.ItemEstoquerepository;

@Service
public class Estoqueservice {
    @Autowired
    private Estoquerepository estoques;

    @Autowired
    private ItemEstoquerepository itens;

    public List<Estoque> getAllEstoque(){
        return estoques.findAll();

    }

    public Estoque getEstoquebyID(long id){
        Optional<Estoque> op = estoques.findById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não cadastrado"));
    }

    public ItemEstoque getItemEstoquebyID(long idestoque, long idproduto){
        Optional<ItemEstoque> op = itens.findByids(idproduto, idestoque);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não cadastrado"));
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
        
        return estoques.save(newestoque);
    }

    public Estoque alterarQuantidade(long idproduto, long idestoque, Integer quantidade){
        ItemEstoque item = getItemEstoquebyID(idestoque, idproduto);
        item.setQuantidade(quantidade);

        return itens.save(item).getEstoque();
    }
}
