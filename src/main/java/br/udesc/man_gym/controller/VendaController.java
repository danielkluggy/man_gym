package br.udesc.man_gym.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;
import br.udesc.man_gym.model.Cliente;
import br.udesc.man_gym.model.VendaModel;
import br.udesc.man_gym.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

@Named
@SessionScope
public class VendaController {
    public List<Cliente> clientes;
    public List<String> produtos;
    public VendaModel venda;
    public List<VendaModel> vendas;
    private int produtoEscolhido = 0;

    @Autowired
    ClienteRepository clienteDao;

    @PostConstruct
    public void init() {
        clientes = clienteDao.findAll();
        produtos = List.of("Creatina", "Whey", "Camiseta");
        vendas = new ArrayList<>();
        venda = new VendaModel();
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public VendaModel getVenda() {
        return venda;
    }

    public List<VendaModel> getVendas() {
        return vendas;
    }

    public void salvarVenda() {
    	venda.setProduto(produtos.get(produtoEscolhido));
        vendas.add(venda);
        venda = new VendaModel();
        produtoEscolhido = produtoEscolhido + 1;
    }

    public String cancelar() {
        venda = new VendaModel();
        return "cancelado";
    }
    
    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }
}
