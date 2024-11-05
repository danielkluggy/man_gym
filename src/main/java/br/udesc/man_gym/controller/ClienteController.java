package br.udesc.man_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.udesc.man_gym.messages.JSFMensageiro;
import br.udesc.man_gym.model.Cliente;
import br.udesc.man_gym.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ClienteController {

	private Cliente cli = new Cliente();
	private List<Cliente> clientes;
	private boolean modoAlterar = false;

	@Autowired
	private ClienteRepository clienteDao;

	@PostConstruct
	public void init() {
		setClientes(clienteDao.findAll());
	}

	public void salvar() {
		try {
			clienteDao.save(cli);
			if (!this.modoAlterar)
				clientes.add(cli);// Se for um novo cliente no banco, já inclui logo na lista
			
			System.out.println("Salvo com sucesso");
			cli= new Cliente();
			this.modoAlterar=false;
			
		} catch (Exception ex) {
			System.out.println("ERRO!!! na hora da cadastrar");

		}
		cli = new Cliente();
	}

	public void excluir(Cliente cliente) {
		try {
			clienteDao.delete(cliente);
			clientes.remove(cliente);
			JSFMensageiro.info("Excluído com Sucesso");
		} catch (Exception ex) {
			JSFMensageiro.error("ERRO!!! na hora da Exclusão");
		}
		
	}

	public void alterar(Cliente clienteAlterar) {
		setCli(clienteAlterar);
		this.modoAlterar = true;

	}

	public void cancelar() {
		cli = new Cliente();
		this.modoAlterar = false;
	}

	// GETTERS E SETTERS
	public ClienteRepository getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteRepository clienteDao) {
		this.clienteDao = clienteDao;
	}

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isModoAlterar() {
		return modoAlterar;
	}

}
