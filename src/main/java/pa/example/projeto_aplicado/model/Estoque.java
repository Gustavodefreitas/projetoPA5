package pa.example.projeto_aplicado.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Estoque implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idestoque;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date datadeentrada;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date datadesaida;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "id.estoque")
    private Set<ItemEstoque> itens = new HashSet<>();

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ItemEstoque> getItens() {
        return itens;
    }

    public void setItens(Set<ItemEstoque> itens) {
        this.itens = itens;
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

    public Estoque(long idestoque, Date datadeentrada, Date datadesaida, Cliente cliente) {
        this.idestoque = idestoque;
        this.datadeentrada = datadeentrada;
        this.datadesaida = datadesaida;
        this.cliente = cliente;
    }

    public Estoque() {
    }
}
