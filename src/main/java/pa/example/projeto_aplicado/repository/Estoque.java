package pa.example.projeto_aplicado.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import pa.example.projeto_aplicado.model.Produto;

@Component
public class Estoque {
    ArrayList<Produto> estoque = new ArrayList<Produto>();

    

    public ArrayList<Produto> getAllProdutos(){
        //AQUI ESTARA A CONEXÃO ENTRE O BANCO E O PROGRAMA (SELECT * FROM Produtos)
    }

    public Produto getProdutoporID(int id){
        //AQUI ESTARA A CONEXÃO ENTRE O BANCO E O PROGRAMA (SELECT FROM Produtos WHERE IDProduto = id)
    }

    public Produto cadastraProduto(Produto produto){
        //AQUI ESTARA A CONEXÃO ENTRE O BANCO E O PROGRAMA 
        //(INSERT INTO Produtos VALUES (produto.nome, produto.modelo...))
        
        return produto;
    }

    public void deletarProduto(int id){
        //AQUI ESTARA A CONEXÃO ENTRE O BANCO E O PROGRAMA (DELETE FROM Produtos WHERE IDProduto = id)

    }

    public void alterarProduto(int id, Produto produto){
        //AQUI ESTARA A CONEXÃO ENTRE O BANCO E O PROGRAMA 
        //(UPDATE Produtos SET modelo = +produto.getModelo , cor = +produto.getCor... WHERE IDProduto = id)

    }
}
