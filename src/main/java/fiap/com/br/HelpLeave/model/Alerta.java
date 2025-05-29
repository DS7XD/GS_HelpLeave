package fiap.com.br.HelpLeave.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlertas;

    private String tipo;
    private String localizacao;
    private LocalDate dataAlerta;

    // Getters e Setters
    public Long getIdAlertas() {
        return idAlertas;
    }

    public void setIdAlertas(Long idAlertas) {
        this.idAlertas = idAlertas;
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
