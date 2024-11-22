package br.udesc.man_gym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Questionario {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String isPlanoSaude;
    public String planoSaude;
    public String isOutroEsporte;
    public String outroEsporte;
    public String motivoAcademia;
    public String comoSoube;

    @OneToOne
    @JoinColumn
    private Cliente cliente;

    // Construtor vazio
    public Questionario() {
    }

    // Construtor completo
    public Questionario(Long id, String isPlanoSaude, String planoSaude, String isOutroEsporte, String outroEsporte,
            String motivoAcademia, String comoSoube, Cliente cliente) {
        this.id = id;
        this.isPlanoSaude = isPlanoSaude;
        this.planoSaude = planoSaude;
        this.isOutroEsporte = isOutroEsporte;
        this.outroEsporte = outroEsporte;
        this.motivoAcademia = motivoAcademia;
        this.comoSoube = comoSoube;
        this.cliente = cliente;
    }

    // Getters e setters
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsPlanoSaude() {
        return isPlanoSaude;
    }

    public void setIsPlanoSaude(String isPlanoSaude) {
        this.isPlanoSaude = isPlanoSaude;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public String getIsOutroEsporte() {
        return isOutroEsporte;
    }

    public void setIsOutroEsporte(String isOutroEsporte) {
        this.isOutroEsporte = isOutroEsporte;
    }

    public String getOutroEsporte() {
        return outroEsporte;
    }

    public void setOutroEsporte(String outroEsporte) {
        this.outroEsporte = outroEsporte;
    }

    public String getMotivoAcademia() {
        return motivoAcademia;
    }

    public void setMotivoAcademia(String motivoAcademia) {
        this.motivoAcademia = motivoAcademia;
    }

    public String getComoSoube() {
        return comoSoube;
    }

    public void setComoSoube(String comoSoube) {
        this.comoSoube = comoSoube;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
