package br.udesc.man_gym.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import br.udesc.man_gym.model.Cliente;
import br.udesc.man_gym.model.VendaModel;
import br.udesc.man_gym.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;

@Named
@SessionScope
public class VendaController {
    public List<Cliente> clientes;
    public List<String> produtos;
    public VendaModel venda;
    public List<VendaModel> vendas;
    private int produtoEscolhido = 0;
    public List<VendaModel> vendasFiltradas;
    public List<VendaModel> vendasPagamento;
    public Cliente cliente;
    public Double valorVenda;

    @Autowired
    ClienteRepository clienteDao;
    

    @PostConstruct
    public void init() {
        this.valorVenda = 0.0;
        produtos = List.of("Creatina", "Whey", "Camiseta");
        vendas = new ArrayList<>();
        vendasFiltradas = new ArrayList<>();
        vendasPagamento = new ArrayList<>();
        Cliente cliente1 = new Cliente("João Silva", "joao@gmail.com", 19, "Masculino", "112323124214", "66843104");
        Cliente cliente2 = new Cliente("Maria Oliveira","maria@gmail.com", 19, "Feminino", "112323124231", "66843132");
        VendaModel venda1 = new VendaModel(UUID.randomUUID(), "Venda Online", "Finalizada", "Cartão de Crédito", 200.0, 2, 100.0, new Date(), "Creatina", cliente1);
        VendaModel venda2 = new VendaModel(UUID.randomUUID(), "Venda Presencial", "Pendente", "Dinheiro", 150.0, 1, 150.0, new Date(), "Whey", cliente2);
        VendaModel venda3 = new VendaModel(UUID.randomUUID(), "Venda Online", "Finalizada", "Cartão de Crédito", 200.0, 2, 100.0, new Date(), "Creatina", cliente2);
        vendas.add(venda2);
        vendas.add(venda1);
        vendas.add(venda3);
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public List<VendaModel> filtroVendasCliente(AjaxBehaviorEvent event) {
        UIComponent component = event.getComponent().findComponent("searchInput");
        this.vendasFiltradas.clear(); 
        if (component instanceof UIInput) {
            String nome = (String) ((UIInput) component).getValue();
            if (nome == null || nome.isEmpty()) {
                return this.vendasFiltradas;
            }
            for(VendaModel venda : vendas){
                if(venda.cliente.getNome().equalsIgnoreCase(nome)){
                    this.vendasFiltradas.add(venda);
                }
            }         
        }
        return this.vendasFiltradas;
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

    public List<VendaModel> getVendasFiltradas(){
        return this.vendasFiltradas;
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

    public void realizarVendaSelecionadas(VendaModel venda){
        this.valorVenda += venda.getTotalPagamento();
        this.vendasPagamento.add(venda);
    }

    public void concluirVenda(){
        for(VendaModel venda : vendas){
            for (VendaModel vendaPagamento : vendasPagamento){
                if(venda.getProduto().equalsIgnoreCase(vendaPagamento.getProduto())){
                    this.vendasFiltradas.remove(venda);
                }
            }
        }
        this.valorVenda = 0.0;
        this.vendasPagamento.clear();
    }
    
    public List<VendaModel> listarVendas() {

        return vendas;
    }
}
