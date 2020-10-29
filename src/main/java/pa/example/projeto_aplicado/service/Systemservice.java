package pa.example.projeto_aplicado.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.example.projeto_aplicado.model.Produto;
import pa.example.projeto_aplicado.repository.Estoque;

@Service
public class Systemservice {

    @Autowired
    private Estoque estoque;

    public Iterable<Produto> getAllProdutos(){
        return estoque.findAll();

    }

    public Produto getProdutobyID(long id){
        Produto produto = estoque.findByid(id);
        Optional<Produto> op;

        if(produto != null)
            op = Optional.of(produto);
        else
            op = Optional.empty();

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não cadastrado"));
 
    }

    public Produto salvarProduto(Produto produto){
        return estoque.save(produto);
    }

    public void deletarProdutobyID(long id){
        Produto produto = getProdutobyID(id);

        estoque.delete(produto);
    }

    public Produto alterarProduto(long id, Produto produto){
        Produto newproduto = getProdutobyID(id);
        newproduto.atualizarProduto(produto);
        
        return estoque.save(newproduto);
  
    }
}
