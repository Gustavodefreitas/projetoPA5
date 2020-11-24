package pa.example.projeto_aplicado.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idproduto;

    private String descricao;
    private String tipo;
    private String marca;
    private String cor;
    private float peso;
    private float volume;

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemEstoque> itens = new HashSet<>();


    @JsonIgnore
    public List<Estoque> getEstoques(){
        List<Estoque> estoques = new ArrayList<>();

        for(ItemEstoque x : itens)
            estoques.add(x.getEstoque());
        
        return estoques;
    }

    public Set<ItemEstoque> getItens() {
        return itens;
    }

    public void setItens(Set<ItemEstoque> itens) {
        this.itens = itens;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idproduto ^ (idproduto >>> 32));
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
        Produto other = (Produto) obj;
        if (idproduto != other.idproduto)
            return false;
        return true;
    }

    public Produto(long idproduto, String descricao, String tipo, String marca, String cor, float peso, float volume) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.tipo = tipo;
        this.marca = marca;
        this.cor = cor;
        this.peso = peso;
        this.volume = volume;
    }

    public Produto() {
    }

    

    


}
