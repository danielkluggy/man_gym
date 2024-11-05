package br.udesc.man_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import br.udesc.man_gym.model.Cliente;
import br.udesc.man_gym.model.DobraCutanea;
import br.udesc.man_gym.model.Medida;
import br.udesc.man_gym.repository.ClienteRepository;
import br.udesc.man_gym.repository.DobraCutaneaRepository;
import br.udesc.man_gym.repository.MedidaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

@Named
@SessionScope
public class DobraCutaneaController {
	private DobraCutanea dobracutanea = new DobraCutanea(); // Para ser persistida no Banco
	private DobraCutanea dobracutaneaEscolhida = new DobraCutanea();
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	private List<DobraCutanea> dobrascutaneas;
	private boolean modoEdicao = false;
	private String mensagem = null;

	private Medida medidaEscolhida = new Medida();

	@Autowired
	DobraCutaneaRepository dobraDao;

	@Autowired
	ClienteRepository clienteDao;

	@Autowired
	MedidaRepository medidaDao;

	@PostConstruct
	public void init() {
		setDobrascutaneas(dobraDao.findAll());
		setClientes(clienteDao.findAll());
	}

	public void salvarDobra() {
		try {
			dobraDao.save(dobracutanea);
			if (!modoEdicao) {
				this.dobrascutaneas.add(dobracutanea);
			}
			setMensagem("Sucesso no salvamento");
			this.modoEdicao = false;
			dobracutanea = new DobraCutanea();
		} catch (Exception ex) {
			System.out.println("Erro ao salvar");
		}

	}

	public void alterarDobra(DobraCutanea dobra) {
		setMensagem(null);
		setDobracutanea(dobra);
		this.modoEdicao = true;
	}

	public void excluir(DobraCutanea dobra) {
		try {
			dobraDao.delete(dobra);
			dobrascutaneas.remove(dobra);
			setMensagem("Sucesso na exclusão");
		} catch (Exception ex) {
			System.out.println("Erro ao Excluir");
		}

	}

	public void cancelar() {
		setMensagem(null);
		this.dobracutanea = new DobraCutanea();
		this.modoEdicao = false;
	}

	public String relatorioDobracut() {
		try {
			setMensagem(null);
			setDobracutaneaEscolhida(dobraDao.buscaPorAluno(cliente.getMatricula()));
			dobracutaneaEscolhida.calcularGordura(cliente.getIdade());
			this.medidaEscolhida = medidaDao.buscarMedida(cliente.getMatricula());
			medidaEscolhida.calcularImc();
			medidaEscolhida.calcularMassa();
			return "avaliacaodobrascutaneas";
		} catch (Exception ex) {
			setMensagem(
					"ERROR !! Não encontrado medidas das dobras cutaneas.");
			return "dobracutanea";
		}
	}

	// GETTERS E SETTERS
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<DobraCutanea> getDobrascutaneas() {
		return dobrascutaneas;
	}

	public void setDobrascutaneas(List<DobraCutanea> dobrascutaneas) {
		this.dobrascutaneas = dobrascutaneas;
	}

	public DobraCutanea getDobracutanea() {
		return dobracutanea;
	}

	public void setDobracutanea(DobraCutanea dobracutanea) {
		this.dobracutanea = dobracutanea;
	}

	public DobraCutanea getDobracutaneaEscolhida() {
		return dobracutaneaEscolhida;
	}

	public void setDobracutaneaEscolhida(DobraCutanea dobracutaneaEscolhida) {
		this.dobracutaneaEscolhida = dobracutaneaEscolhida;
	}

	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

    public Medida getMedidaEscolhida() {
        return medidaEscolhida;
    }

    public void setMedidaEscolhida(Medida medidaEscolhida) {
        this.medidaEscolhida = medidaEscolhida;
    }

}
