package pa.example.projeto_aplicado.model;

public class Produto {
    private int id;
    private String modelo;
    private String cor;
    private String descricao;
    private float volume;
    private int quantidade_estoque;


    public int getCodigo(){
        return id;
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


    public void setCodigo(int codigo){
        this.id = codigo;
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
}
