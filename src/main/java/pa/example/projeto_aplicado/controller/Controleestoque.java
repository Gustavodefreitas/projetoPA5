package pa.example.projeto_aplicado.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import pa.example.projeto_aplicado.model.Estoque;
import pa.example.projeto_aplicado.service.Estoqueservice;

@RequestMapping("/estoque")
@RestController
public class Controleestoque {
    @Autowired
    private Estoqueservice srvc;

    @GetMapping()
    public ResponseEntity<Iterable<Estoque>> listar_todo_estoques() {
        Iterable<Estoque> allestoques = srvc.getAllEstoque();

        if (allestoques != null)
            return ResponseEntity.ok(allestoques);
        else
            return ResponseEntity.notFound().build();

    }

    @GetMapping("/{idestoque}")
    public ResponseEntity<Estoque> listar_produto(@PathVariable("idestoque") long idestoque) {
        Estoque estoque = srvc.getEstoquebyID(idestoque);

        return ResponseEntity.ok(estoque);
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrarProduto(@RequestBody Estoque estoque, HttpServletRequest request,
            UriComponentsBuilder builder) {

        estoque = srvc.salvarEstoque(estoque);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + estoque.getIdestoque()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{idestoque}")
    public ResponseEntity<Void> deletarProduto(@PathVariable int idestoque) {
        srvc.deletarEstoquebyID(idestoque);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{idestoque}")
    public ResponseEntity<Estoque> alteraProduto(@PathVariable long idestoque, @RequestBody Estoque estoque){
        estoque = srvc.alterarEstoque(idestoque, estoque);
        
        return ResponseEntity.ok(estoque);
    }
}

