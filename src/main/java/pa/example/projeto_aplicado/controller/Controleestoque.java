package pa.example.projeto_aplicado.controller;

import java.util.List;

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

import pa.example.projeto_aplicado.model.Estoque;
import pa.example.projeto_aplicado.model.Produto;
import pa.example.projeto_aplicado.model.Produtoqtd;
import pa.example.projeto_aplicado.service.Estoqueservice;
import pa.example.projeto_aplicado.service.Produtoservice;

@RequestMapping("/estoques")
@RestController
public class ControleEstoque {
    @Autowired
    private Estoqueservice srvc;

    @Autowired
    private Produtoservice srvcp;

    @GetMapping()
    public ResponseEntity<Iterable<Estoque>> listarAllEstoque() {
        List<Estoque> allestoques = srvc.getAllEstoque();

        if (allestoques.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(allestoques);  

    }

    @GetMapping("/{idestoque}")
    public ResponseEntity<Estoque> listarEstoque(@PathVariable("idestoque") long idestoque) {
        Estoque estoque = srvc.getEstoquebyID(idestoque);

        return ResponseEntity.ok(estoque);
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrarEstoque(@RequestBody Estoque estoque, HttpServletRequest request,
            UriComponentsBuilder builder) {

        estoque = srvc.salvarEstoque(estoque);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + estoque.getIdestoque()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{idestoque}")
    public ResponseEntity<Void> deletarEstoque(@PathVariable int idestoque) {
        srvc.deletarEstoquebyID(idestoque);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{idestoque}")
    public ResponseEntity<Estoque> alterarEstoque(@PathVariable long idestoque, @RequestBody Estoque estoque){
        estoque = srvc.alterarEstoque(idestoque, estoque);
        
        return ResponseEntity.ok(estoque);
    }

    @PostMapping("/{idestoque}/cadastrarproduto")
    public ResponseEntity<Void> cadastrarProduto(@RequestBody Produtoqtd produtoqtd, @PathVariable Long idestoque, HttpServletRequest request,
            UriComponentsBuilder builder) {
        Produto produto = srvcp.salvarProduto(produtoqtd.getProduto(), idestoque, produtoqtd.getQuantidade());
        
        UriComponents uriComponents = builder.path(request.getLocalName() + "/produtos/" + produto.getIdproduto()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{idestoque}/produtos/{idproduto}")
    public ResponseEntity<Estoque> alterarQuantidade(@PathVariable long idestoque, @PathVariable long idproduto, @RequestBody Produtoqtd produtoqtd){
        Estoque estoque = srvc.alterarQuantidade(idproduto, idestoque, produtoqtd.getQuantidade());
        
        return ResponseEntity.ok(estoque);
    }
}

