package pa.example.projeto_aplicado.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pa.example.projeto_aplicado.model.Produto;
import pa.example.projeto_aplicado.service.Produtoservice;

@RequestMapping("/produtos")
@RestController
public class ControleProduto{
    @Autowired
    private Produtoservice srvc;

    @GetMapping()
    public ResponseEntity<Iterable<Produto>> listarAllProdutos() {
        List<Produto> allprodutos = srvc.getAllProdutos();

        if (allprodutos.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(allprodutos);  

    }

    @GetMapping("/{idproduto}")
    public ResponseEntity<Produto> listarProduto(@PathVariable("idproduto") long idproduto) {
        Produto produto = srvc.getProdutobyID(idproduto);

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{idproduto}")
    public ResponseEntity<Void> deletarProduto(@PathVariable int idproduto) {
        srvc.deletarProdutobyID(idproduto);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{idproduto}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable long idproduto, @RequestBody Produto produto){
        produto = srvc.alterarProduto(idproduto, produto);
        
        return ResponseEntity.ok(produto);
    }
}
