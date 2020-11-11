package pa.example.projeto_aplicado.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import pa.example.projeto_aplicado.model.Produto;
import pa.example.projeto_aplicado.service.Produtoservice;

@RequestMapping("/produtos")
@RestController
public class Controleproduto {
    @Autowired
    private Produtoservice srvc;

    @GetMapping()
    public ResponseEntity<Iterable<Produto>> listar_produtos_estoque() {
        Iterable<Produto> allProdutos = srvc.getAllProdutos();

        if (allProdutos != null)
            return ResponseEntity.ok(allProdutos);
        else
            return ResponseEntity.notFound().build();

    }

    @GetMapping("/{idproduto}")
    public ResponseEntity<Produto> listar_produto(@PathVariable("idproduto") long idproduto) {
        Produto produto = srvc.getProdutobyID(idproduto);

        return ResponseEntity.ok(produto);
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrarProduto(@RequestBody Produto produto, HttpServletRequest request,
            UriComponentsBuilder builder) {
        produto = srvc.salvarProduto(produto);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + produto.getIdproduto()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{idproduto}")
    public ResponseEntity<Void> deletarProduto(@PathVariable int idproduto) {
        srvc.deletarProdutobyID(idproduto);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{idproduto}")
    public ResponseEntity<Produto> alteraProduto(@PathVariable long idproduto, @RequestBody Produto produto){
        produto = srvc.alterarProduto(idproduto, produto);
        
        return ResponseEntity.ok(produto);
    }
}
