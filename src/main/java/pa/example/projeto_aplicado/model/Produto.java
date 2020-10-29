package pa.example.projeto_aplicado.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String modelo;
    private String cor;
    private String descricao;
    private float volume;
    private int quantidade_estoque;


    public void atualizarProduto(Produto atual){

        if(atual.getId() != 0)
            this.id = atual.getId();

        if(atual.getCor() != null)
            this.cor = atual.getCor();
        
        if(atual.getDescricao() != null)
            this.descricao = atual.getDescricao();

        if(atual.getModelo() != null)
            this.modelo = atual.getModelo();

        if(atual.getVolume() != 0)
            this.volume = atual.getVolume();  
        
        if(atual.getQuantidade() != 0)
            this.quantidade_estoque = atual.getQuantidade();    
    }

    public String getModelo(){
        return modelo;
    }

    public String getCor(){
        return cor;
    }

    public String getDescricao(){
        return descricao;
    }

    public float getVolume(){
        return volume;
    }

    public int getQuantidade(){
        return quantidade_estoque;
    }

    public void setModelo(String model){
        this.modelo = model;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public void setDescricao(String desc){
        this.descricao = desc;
    }

    public void setVolume(Float vol){
        this.volume = vol;
    }

    public void setQuantidade(int qtd){
        this.quantidade_estoque = qtd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
