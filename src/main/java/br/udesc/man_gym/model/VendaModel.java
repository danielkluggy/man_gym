package br.udesc.man_gym.model;

import java.util.Date;
import java.util.UUID;

public class VendaModel {
	
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
