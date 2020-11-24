package pa.example.projeto_aplicado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.example.projeto_aplicado.model.Cliente;
import pa.example.projeto_aplicado.model.Endereco;
import pa.example.projeto_aplicado.repository.Clientesrepository;
import pa.example.projeto_aplicado.repository.EnderecoRepository;

@Service
public class Clienteservice {
    
    @Autowired
    private Clientesrepository clientes;

    @Autowired
    private EnderecoRepository enderecos;

    public List<Cliente> getAllClientes(){
        return clientes.findAll();

    }

    public Cliente getClientebyID(long id){
        Optional<Cliente> op = clientes.findById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public Endereco getEnderecobyID(long id){
        Optional<Endereco> op = enderecos.findById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado"));
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

        if(cliente.getNome() != null)
            newcliente.setNome(cliente.getNome());
        if(cliente.getCnpj() != null)
            newcliente.setCnpj(cliente.getCnpj());
        if(cliente.getEmail() != null)
            newcliente.setEmail(cliente.getEmail());
        
        return clientes.save(newcliente);
  
    }

    public Endereco salvarEndereco(Endereco endereco, Long idcliente){
        Cliente cliente = getClientebyID(idcliente);
        endereco.setCliente(cliente);

        return enderecos.save(endereco);
    }

    public Endereco alterarEndereco(long idendereco, Endereco endereco){
        Endereco newendereco = getEnderecobyID(idendereco);

        if(endereco.getRua() != null)
            newendereco.setRua(endereco.getRua());
        if(endereco.getNumero() != 0)
            newendereco.setNumero(endereco.getNumero());
        if(endereco.getBairro() != null)
            newendereco.setBairro(endereco.getBairro());
        if(endereco.getComplemento() != null)
            newendereco.setComplemento(endereco.getComplemento());
        if(endereco.getCep() != null)
            newendereco.setCep(endereco.getCep());
        if(endereco.getCidade() != null)
            newendereco.setCidade(endereco.getCidade());
        if(endereco.getEstado() != null)
            newendereco.setEstado(endereco.getEstado());
        if(endereco.getPais() != null)
            newendereco.setPais(endereco.getPais());

        return enderecos.save(newendereco);
  
    }
}
