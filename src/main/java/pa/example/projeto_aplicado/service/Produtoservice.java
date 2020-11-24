package pa.example.projeto_aplicado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.example.projeto_aplicado.model.Estoque;
import pa.example.projeto_aplicado.model.ItemEstoque;
import pa.example.projeto_aplicado.model.Produto;
import pa.example.projeto_aplicado.repository.ItemEstoquerepository;
import pa.example.projeto_aplicado.repository.Produtorepository;

@Service
public class Produtoservice {

    @Autowired
    private Produtorepository produtos;

    @Autowired
    private ItemEstoquerepository itensestoque;

    @Autowired
    private Estoqueservice srvc;

    public List<Produto> getAllProdutos(){
        return produtos.findAll();

    }

    public Produto getProdutobyID(long id){
        Optional<Produto> op = produtos.findById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não cadastrado"));
 
    }

    public Produto salvarProduto(Produto produto, Long idestoque, Integer quantidade){
        Estoque estoque = srvc.getEstoquebyID(idestoque);
        produto = produtos.save(produto);
        ItemEstoque itemestoque = new ItemEstoque(estoque, produto, quantidade);
        itensestoque.save(itemestoque);

        return produto;
    }

    public void deletarProdutobyID(long id){
        Produto produto = getProdutobyID(id);

        produtos.delete(produto);
    }

    public Produto alterarProduto(long id, Produto produto){
        Produto newproduto = getProdutobyID(id);
        
        if(produto.getCor() != null)
            newproduto.setCor(produto.getCor());
        if(produto.getDescricao() != null)
            newproduto.setDescricao(produto.getDescricao());
        if(produto.getMarca() != null)
            newproduto.setMarca(produto.getMarca());
        if(produto.getPeso() != 0)
            newproduto.setPeso(produto.getPeso());
        if(produto.getTipo() != null)
            newproduto.setTipo(produto.getTipo());   
        if(produto.getVolume() != 0)
            newproduto.setVolume(produto.getVolume());       
        
        return produtos.save(newproduto);
  
    }
}

