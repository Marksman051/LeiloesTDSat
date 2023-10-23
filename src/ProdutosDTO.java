


public class ProdutosDTO {
    private Integer id;
    private String nome;
    private double valor;
    private String status;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

  

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public void setStatus(String status) {
        this.status = status;
    }
    
}
