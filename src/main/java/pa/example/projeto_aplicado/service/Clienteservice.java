package pa.example.projeto_aplicado.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.example.projeto_aplicado.model.Cliente;
import pa.example.projeto_aplicado.repository.Clientesrepository;

@Service
public class Clienteservice {
    
    @Autowired
    private Clientesrepository clientes;

    public Iterable<Cliente> getAllClientes(){
        return clientes.findAll();

    }

    public Cliente getClientebyID(long id){
        Optional<Cliente> op = clientes.findById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public Cliente salvarCliente(Cliente cliente){

        return clientes.save(cliente);
    }

    public void deletarClientebyID(long id){
        Cliente cliente = getClientebyID(id);

        clientes.delete(cliente);
    }

    public Cliente alterarCliente(long id, Cliente cliente){
        Cliente newcliente = getClientebyID(id);
        newcliente.atualizarCliente(cliente);
        
        return clientes.save(newcliente);
  
    }
}
