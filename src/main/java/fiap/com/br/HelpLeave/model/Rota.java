package fiap.com.br.HelpLeave.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRota;

    @NotBlank(message = "A origem é obrigatória")
    @Size(max = 100, message = "A origem deve ter no máximo 100 caracteres")
    private String origem;

    @NotBlank(message = "O destino é obrigatório")
    @Size(max = 100, message = "O destino deve ter no máximo 100 caracteres")
    private String destino;

    @ManyToOne
    @JoinColumn(name = "refugio_id")
    private Refugio refugio;

    // Getters e Setters
    public Long getIdRota() {
        return idRota;
    }

    public void setIdRota(Long idRota) {
        this.idRota = idRota;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }
}
