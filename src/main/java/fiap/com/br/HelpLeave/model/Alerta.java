package fiap.com.br.HelpLeave.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ALERTAS")
public class Alerta {

    @Id
    @Column(name = "ID_ALERTAS")
    private Long idAlerta;

    @NotBlank(message = "O tipo do alerta é obrigatório")
    @Size(max = 50, message = "O tipo deve ter no máximo 50 caracteres")
    @Column(name = "TIPO", nullable = false, length = 50)
    private String tipo;

    @NotBlank(message = "A localização é obrigatória")
    @Size(max = 100, message = "A localização deve ter no máximo 100 caracteres")
    @Column(name = "LOCALIZACAO", nullable = false, length = 100)
    private String localizacao;

    @NotNull(message = "A data do alerta é obrigatória")
    @Column(name = "DATA_ALERTA", nullable = false)
    private LocalDate dataAlerta;

    // Getters e Setters
    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public LocalDate getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDate dataAlerta) {
        this.dataAlerta = dataAlerta;
    }
}
