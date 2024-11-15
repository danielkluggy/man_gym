package br.udesc.man_gym.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VendaModel {
    
	@Id
    public UUID id;    
    public String tipoVenda;
    public String fimVenda;
    public String tipoPagamento;
    public double totalPagamento;
    public int quantidade;
    public double precoUnitario;
    public Date data;
    public String produto;
    public Cliente cliente;

    // Construtor vazio
    public VendaModel() {}

    // Construtor completo
    public VendaModel(UUID id, String tipoVenda, String fimVenda, String tipoPagamento, 
                      double totalPagamento, int quantidade, double precoUnitario, 
                      Date data, String produto, Cliente cliente) {
        this.id = id;
        this.tipoVenda = tipoVenda;
        this.fimVenda = fimVenda;
        this.tipoPagamento = tipoPagamento;
        this.totalPagamento = totalPagamento;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.data = data;
        this.produto = produto;
        this.cliente = cliente;
    }

    // Getters e setters
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getTipoVenda() {
        return tipoVenda;
    }
    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }
    public String getFimVenda() {
        return fimVenda;
    }
    public void setFimVenda(String fimVenda) {
        this.fimVenda = fimVenda;
    }
    public String getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    public double getTotalPagamento() {
        return totalPagamento;
    }
    public void setTotalPagamento(double totalPagamento) {
        this.totalPagamento = totalPagamento;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
}
