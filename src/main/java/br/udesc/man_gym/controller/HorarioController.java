package br.udesc.man_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import br.udesc.man_gym.messages.JSFMensageiro;
import br.udesc.man_gym.model.Cliente;
import br.udesc.man_gym.model.Horario;
import br.udesc.man_gym.repository.ClienteRepository;
import br.udesc.man_gym.repository.HorarioRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

@Named
@SessionScope
public class HorarioController {
    public Horario horario = new Horario();
    public Cliente cliente = new Cliente();

    public List<Horario> horarios;
    public boolean modoEdicao = false;
    public String mensagem = null;

    private List<Cliente> clientes;

    @Autowired
    public HorarioRepository horarioDao;

    @Autowired
    ClienteRepository clienteDao;

    @PostConstruct
    public void init() {
        setMensagem(null);
        setHorarios(horarioDao.findAll());
        setClientes(clienteDao.findAll());
    }

    public void salvarHorario() {
        try {
            horarioDao.save(horario);
            setHorarios(horarioDao.findAll());
            setMensagem("Sucesso ao salvar");
            this.modoEdicao = false;
            horario = new Horario();

        } catch (Exception ex) {
            setMensagem("Erro ao cadastrar Horario");
            JSFMensageiro.error("Erro ao cadastrar Horario");
        }
    }

    public void alterarHorario(Horario HorarioAlterar) {
        setMensagem(null);
        setHorario(HorarioAlterar);
        setHorarios(horarioDao.findAll());
        this.modoEdicao = true;
    }

    public void excluir(Horario horarioExcluir) {
        try {
            setMensagem("Sucesso ao excluir");
            horarioDao.delete(horarioExcluir);
            setHorarios(horarioDao.findAll());
            horario = new Horario();
        } catch (Exception ex) {
            System.out.println("Erro ao excluir");
        }
    }

    public String abrirHorario() {
        return "Horario";
    }

    public void cancelar() {
        this.modoEdicao = false;
        this.horario = new Horario();
    }

    public boolean isModoEdicao() {
        return modoEdicao;
    }

    public void setModoEdicao(boolean modoEdicao) {
        this.modoEdicao = modoEdicao;
    }

    public Horario getHorario() {
        return this.horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}