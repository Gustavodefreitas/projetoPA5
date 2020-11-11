package pa.example.projeto_aplicado.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idproduto;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private float peso;
    @Column(nullable = false)
    private float volume;


    public void atualizarProduto(Produto atual){

        if(atual.getCor() != null)
            this.cor = atual.getCor();
        
        if(atual.getDescricao() != null)
            this.descricao = atual.getDescricao();

        if(atual.getMarca() != null)
            this.marca = atual.getMarca();

        if(atual.getVolume() != 0)
            this.volume = atual.getVolume();  
        
        if(atual.getPeso() != 0)
            this.peso = atual.getPeso();  
            
        if(atual.getTipo() != null)
            this.tipo = atual.getTipo(); 
    }

    public long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(long idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }



}
