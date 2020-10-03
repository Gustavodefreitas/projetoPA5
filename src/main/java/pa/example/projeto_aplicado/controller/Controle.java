package pa.example.projeto_aplicado.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pa.example.projeto_aplicado.model.Produto;
import pa.example.projeto_aplicado.repository.Estoque;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controle {
    
    @Autowired
    private Estoque estoque;

    @GetMapping("/produtos")
    public ArrayList<Produto> listar_produtos_estoque(){
        ArrayList<Produto> produtos = estoque.getAllProdutos();

        return produtos;
    }


    @GetMapping("/produtos/{idproduto}")
    public ResponseEntity<Produto> listar_produto(@PathVariable int idproduto){
        Produto produto = estoque.getProdutoporID(idproduto);

        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/produtos")
    public ResponseEntity<Void> cadastrarProduto(@RequestBody Produto produto) {
        produto = estoque.cadastraProduto(produto);
        URI uri = URI.create("http://localhost:8080/produtos/" + produto.getCodigo());
        
        return ResponseEntity.created(uri).build();
    }
    
    @DeleteMapping("/produtos/{idproduto}")
    public ResponseEntity<Void> deletarProduto(@PathVariable int idproduto){
        Produto produto = estoque.getProdutoporID(idproduto);

        if(produto != null){
            estoque.deletarProduto(idproduto);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/produtos/{idproduto}")
    public ResponseEntity<Produto> alteraProduto(@PathVariable int idproduto, @RequestBody Produto produto){
        Produto p1 = estoque.getProdutoporID(idproduto);

        if(p1 != null){
            estoque.alterarProduto(idproduto, produto);
            return ResponseEntity.ok(p1);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }
}
