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

import pa.example.projeto_aplicado.model.Cliente;
import pa.example.projeto_aplicado.service.Clienteservice;

@RestController
@RequestMapping("/clientes")
public class Controleclientes {
    @Autowired
    private Clienteservice srvc;

    @GetMapping()
    public ResponseEntity<Iterable<Cliente>> listar_todos_cliente() {
        Iterable<Cliente> allclientes = srvc.getAllClientes();

        if (allclientes != null)
            return ResponseEntity.ok(allclientes);
        else
            return ResponseEntity.notFound().build();

    }

    @GetMapping("/{idcliente}")
    public ResponseEntity<Cliente> listar_Cliente(@PathVariable("idcliente") long idcliente) {
        Cliente cliente = srvc.getClientebyID(idcliente);

        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrarCliente(@RequestBody Cliente cliente, HttpServletRequest request,
            UriComponentsBuilder builder) {

        cliente = srvc.salvarCliente(cliente);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + cliente.getIdcliente()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{idcliente}")
    public ResponseEntity<Void> deletarCliente(@PathVariable int idcliente) {
        srvc.deletarClientebyID(idcliente);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{idcliente}")
    public ResponseEntity<Cliente> alteraCliente(@PathVariable long idcliente, @RequestBody Cliente cliente){
        cliente = srvc.alterarCliente(idcliente, cliente);
        
        return ResponseEntity.ok(cliente);
    }
}
