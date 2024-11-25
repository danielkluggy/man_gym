package br.udesc.man_gym.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Horario {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    public String atividade;
    public String localAtividade;
    public String professor;
    public String segundaInicio = "08:00";
    public String segundaFim = "09:00";
    public String tercaInicio = "08:00";
    public String tercaFim = "09:00";
    public String quartaInicio = "08:00";
    public String quartaFim = "09:00";
    public String quintaInicio = "08:00";
    public String quintaFim = "09:00";
    public String sextaInicio = "08:00";
    public String sextaFim = "09:00";
    public String sabadoInicio;
    public String sabadoFim;
    public String domingoInicio;
    public String domingoFim;

    @OneToOne
    @JoinColumn
    private Cliente cliente;

    // Construtor vazio
    public Horario() {
    }

    // Construtor completo
    public Horario(Long id, String atividade, String localAtividade, String professor, String segundaInicio,
            String segundaFim, String tercaInicio, String tercaFim, String quartaInicio, String quartaFim,
            String quintaInicio, String quintaFim, String sextaInicio, String sextaFim, String sabadoInicio,
            String sabadoFim, String domingoInicio, String domingoFim, Cliente cliente) {
        this.id = id;
        this.atividade = atividade;
        this.localAtividade = localAtividade;
        this.professor = professor;
        this.segundaInicio = segundaInicio;
        this.segundaFim = segundaFim;
        this.tercaInicio = tercaInicio;
        this.tercaFim = tercaFim;
        this.quartaInicio = quartaInicio;
        this.quartaFim = quartaFim;
        this.quintaInicio = quintaInicio;
        this.quintaFim = quintaFim;
        this.sextaInicio = sextaInicio;
        this.sextaFim = sextaFim;
        this.sabadoInicio = sabadoInicio;
        this.sabadoFim = sabadoFim;
        this.domingoInicio = domingoInicio;
        this.domingoFim = domingoFim;
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

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getLocalAtividade() {
        return localAtividade;
    }

    public void setLocalAtividade(String localAtividade) {
        this.localAtividade = localAtividade;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSegundaInicio() {
        return segundaInicio;
    }

    public void setSegundaInicio(String segundaInicio) {
        this.segundaInicio = segundaInicio;
    }

    public String getSegundaFim() {
        return segundaFim;
    }

    public void setSegundaFim(String segundaFim) {
        this.segundaFim = segundaFim;
    }

    public String getTercaInicio() {
        return tercaInicio;
    }

    public void setTercaInicio(String tercaInicio) {
        this.tercaInicio = tercaInicio;
    }

    public String getTercaFim() {
        return tercaFim;
    }

    public void setTercaFim(String tercaFim) {
        this.tercaFim = tercaFim;
    }

    public String getQuartaInicio() {
        return quartaInicio;
    }

    public void setQuartaInicio(String quartaInicio) {
        this.quartaInicio = quartaInicio;
    }

    public String getQuartaFim() {
        return quartaFim;
    }

    public void setQuartaFim(String quartaFim) {
        this.quartaFim = quartaFim;
    }

    public String getQuintaInicio() {
        return quintaInicio;
    }

    public void setQuintaInicio(String quintaInicio) {
        this.quintaInicio = quintaInicio;
    }

    public String getQuintaFim() {
        return quintaFim;
    }

    public void setQuintaFim(String quintaFim) {
        this.quintaFim = quintaFim;
    }

    public String getSextaInicio() {
        return sextaInicio;
    }

    public void setSextaInicio(String sextaInicio) {
        this.sextaInicio = sextaInicio;
    }

    public String getSextaFim() {
        return sextaFim;
    }

    public void setSextaFim(String sextaFim) {
        this.sextaFim = sextaFim;
    }

    public String getSabadoInicio() {
        return sabadoInicio;
    }

    public void setSabadoInicio(String sabadoInicio) {
        this.sabadoInicio = sabadoInicio;
    }

    public String getSabadoFim() {
        return sabadoFim;
    }

    public void setSabadoFim(String sabadoFim) {
        this.sabadoFim = sabadoFim;
    }

    public String getDomingoInicio() {
        return domingoInicio;
    }

    public void setDomingoInicio(String domingoInicio) {
        this.domingoInicio = domingoInicio;
    }

    public String getDomingoFim() {
        return domingoFim;
    }

    public void setDomingoFim(String domingoFim) {
        this.domingoFim = domingoFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
