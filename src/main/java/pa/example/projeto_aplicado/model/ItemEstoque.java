package pa.example.projeto_aplicado.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemEstoque implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemEstoquePK id = new ItemEstoquePK();

    private Integer quantidade;
    private Double volumeTotal;
    private Double pesoTotal;

    public ItemEstoque() {
    }

    public ItemEstoque(Estoque estoque, Produto produto, Integer quantidade) {
        id.setEstoque(estoque);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.volumeTotal = (double) (produto.getVolume() * quantidade);
        this.pesoTotal = (double) (produto.getPeso() * quantidade);
    }

    @JsonIgnore
    public Estoque getEstoque() {
        return id.getEstoque();
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public ItemEstoquePK getId() {
        return id;
    }

    public void setId(ItemEstoquePK id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(Double volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        ItemEstoque other = (ItemEstoque) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



    
}
