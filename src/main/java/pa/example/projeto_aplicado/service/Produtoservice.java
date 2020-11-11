package pa.example.projeto_aplicado.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.example.projeto_aplicado.model.Produto;
import pa.example.projeto_aplicado.repository.Produtorepository;

@Service
public class Produtoservice {

    @Autowired
    private Produtorepository produtos;

    public Iterable<Produto> getAllProdutos(){
        return produtos.findAll();

    }

    public Produto getProdutobyID(long id){
        Optional<Produto> op = produtos.findById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não cadastrado"));
 
    }

    public Produto salvarProduto(Produto produto){
        return produtos.save(produto);
    }

    public void deletarProdutobyID(long id){
        Produto produto = getProdutobyID(id);

        produtos.delete(produto);
    }

    public Produto alterarProduto(long id, Produto produto){
        Produto newproduto = getProdutobyID(id);
        newproduto.atualizarProduto(produto);
        
        return produtos.save(newproduto);
  
    }
}

