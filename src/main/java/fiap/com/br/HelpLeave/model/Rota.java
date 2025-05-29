package fiap.com.br.HelpLeave.model;

import jakarta.persistence.*;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRotas;

    private String nome;
    private String pontoInicio;
    private String pontoFim;
    private Integer tempoEstimado;

    // Getters e Setters
    public Long getIdRotas() {
        return idRotas;
    }

    public void setIdRotas(Long idRotas) {
        this.idRotas = idRotas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontoInicio() {
        return pontoInicio;
    }

    public void setPontoInicio(String pontoInicio) {
        this.pontoInicio = pontoInicio;
    }

    public String getPontoFim() {
        return pontoFim;
    }

    public void setPontoFim(String pontoFim) {
        this.pontoFim = pontoFim;
    }

    public Integer getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Integer tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
}
