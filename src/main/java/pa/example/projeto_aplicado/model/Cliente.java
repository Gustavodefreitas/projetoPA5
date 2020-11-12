package pa.example.projeto_aplicado.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idcliente;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String contato;


    public void atualizarCliente(Cliente atual){

        if(atual.getNome() != null)
            this.nome = atual.getNome();
        
        if(atual.getCnpj() != null)
            this.cnpj = atual.getCnpj();

        if(atual.getCep() != null)
            this.cep = atual.getCep();

        if(atual.getEndereco() != null)
            this.endereco = atual.getEndereco();  
         
        if(atual.getContato() != null)
            this.contato = atual.getContato();     

        if(atual.getPais() != null)
            this.pais= atual.getPais();      
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
