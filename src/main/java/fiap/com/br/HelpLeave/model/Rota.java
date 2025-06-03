package fiap.com.br.HelpLeave.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ROTAS")
public class Rota {

    @Id
    @Column(name = "ID_ROTAS")
    private Long idRota;

    @NotBlank(message = "O nome da rota é obrigatório")
    @Size(max = 100, message = "O nome da rota deve ter no máximo 100 caracteres")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O ponto de início é obrigatório")
    @Size(max = 100, message = "O ponto de início deve ter no máximo 100 caracteres")
    @Column(name = "PONTO_INICIO", nullable = false, length = 100)
    private String pontoInicio;

    @NotBlank(message = "O ponto de fim é obrigatório")
    @Size(max = 100, message = "O ponto de fim deve ter no máximo 100 caracteres")
    @Column(name = "PONTO_FIM", nullable = false, length = 100)
    private String pontoFim;

    @NotNull(message = "O tempo estimado é obrigatório")
    @Column(name = "TEMPO_ESTIMADO", nullable = false)
    private Integer tempoEstimado;

    // Getters e Setters
    public Long getIdRota() {
        return idRota;
    }

    public void setIdRota(Long idRota) {
        this.idRota = idRota;
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
