package fiap.com.br.HelpLeave.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "REFUGIOS") 
public class Refugio {

    @Id
    @Column(name = "ID_REFUGIOS")
    private Long idRefugio;

    @NotBlank(message = "O nome do refúgio é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(max = 150, message = "O endereço deve ter no máximo 150 caracteres")
    @Column(name = "ENDERECO", nullable = false, length = 150)
    private String endereco;

    @NotNull(message = "A capacidade é obrigatória")
    @Min(value = 1, message = "A capacidade deve ser maior que zero")
    @Column(name = "CAPACIDADE", nullable = false)
    private Integer capacidade;

    // Getters e Setters
    public Long getIdRefugio() {
        return idRefugio;
    }

    public void setIdRefugio(Long idRefugio) {
        this.idRefugio = idRefugio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
