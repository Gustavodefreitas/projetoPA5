package pa.example.projeto_aplicado.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Estoque implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idestoque;
    
    private Date datadeentrada;
    private Date datadesaida;
    private float volume;
    private int qtdproduto;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @OneToOne(mappedBy = "estoque")
    private Produto produto;

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

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public int getQtdproduto() {
        return qtdproduto;
    }

    public void setQtdproduto(int qtdproduto) {
        this.qtdproduto = qtdproduto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idestoque ^ (idestoque >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estoque other = (Estoque) obj;
        if (idestoque != other.idestoque)
            return false;
        return true;
    }

    public Estoque(long idestoque, Date datadeentrada, Date datadesaida, float volume, int qtdproduto, Cliente cliente,
            Produto produto) {
        this.idestoque = idestoque;
        this.datadeentrada = datadeentrada;
        this.datadesaida = datadesaida;
        this.volume = volume;
        this.qtdproduto = qtdproduto;
        this.cliente = cliente;
        this.produto = produto;
    }

    public Estoque() {
    }

    
}
