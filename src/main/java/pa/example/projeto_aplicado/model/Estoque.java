package pa.example.projeto_aplicado.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estoque implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idestoque;
    
    @Column(nullable = false)
    private Date datadeentrada;
    @Column(nullable = false)
    private Date datadesaida;
    @Column(nullable = false)
    private int qtdedoproduto;
    @Column(nullable = false)
    private float volume;
    @OneToOne
    private Produto produto;


    public void atualizarEstoque(Estoque atual){

        if(atual.getDatadeentrada() != null)
            this.datadeentrada = atual.getDatadeentrada();
        
        if(atual.getDatadesaida() != null)
            this.datadesaida = atual.getDatadesaida();

        if(atual.getQtdedoproduto() != 0)
            this.qtdedoproduto = atual.getQtdedoproduto();

        if(atual.getVolume() != 0)
            this.volume = atual.getVolume();  
            
    }


    public long getIdestoque() {
        return idestoque;
    }

    public void setIdestoque(long idestoque) {
        this.idestoque = idestoque;
    }

    public Date getDatadeentrada() {
        return datadeentrada;
    }

    public void setDatadeentrada(Date datadeentrada) {
        this.datadeentrada = datadeentrada;
    }

    public Date getDatadesaida() {
        return datadesaida;
    }

    public void setDatadesaida(Date datadesaida) {
        this.datadesaida = datadesaida;
    }

    public int getQtdedoproduto() {
        return qtdedoproduto;
    }

    public void setQtdedoproduto(int qtdedoproduto) {
        this.qtdedoproduto = qtdedoproduto;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


}
