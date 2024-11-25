package br.udesc.man_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import br.udesc.man_gym.messages.JSFMensageiro;
import br.udesc.man_gym.model.Cliente;
import br.udesc.man_gym.model.Questionario;
import br.udesc.man_gym.repository.ClienteRepository;
import br.udesc.man_gym.repository.QuestionarioRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

@Named
@SessionScope
public class QuestionarioController {
    public Questionario questionario = new Questionario();
    public Cliente cliente = new Cliente();

    public List<Questionario> questionarios;
    public boolean modoEdicao = false;
    public String mensagem = null;

    private List<Cliente> clientes;

    @Autowired
    public QuestionarioRepository questionarioDao;

    @Autowired
    ClienteRepository clienteDao;

    @PostConstruct
    public void init() {
        setMensagem(null);
        setQuestionarios(questionarioDao.findAll());
        setClientes(clienteDao.findAll());
    }

    public void salvarQuestionario() {
        try {
            questionarioDao.save(questionario);
            setQuestionarios(questionarioDao.findAll());
            setMensagem("Sucesso ao salvar");
            this.modoEdicao = false;
            questionario = new Questionario();

        } catch (Exception ex) {
            setMensagem("Erro ao cadastrar questionario");
            JSFMensageiro.error("Erro ao cadastrar questionario");
        }
    }

    public void alterarQuestionario(Questionario questionarioAlterar) {
        setMensagem(null);
        setQuestionario(questionarioAlterar);
        setQuestionarios(questionarioDao.findAll());
        this.modoEdicao = true;
    }

    public void excluir(Questionario questionarioExcluir) {
        try {
            setMensagem("Sucesso ao excluir");
            questionarioDao.delete(questionarioExcluir);
            setQuestionarios(questionarioDao.findAll());
            questionario = new Questionario();
        } catch (Exception ex) {
            System.out.println("Erro ao excluir");
        }
    }

    public String abrirQuestionario() {
        return "questionario";
    }

    public void cancelar() {
        this.modoEdicao = false;
        this.questionario = new Questionario();
    }

    public boolean isModoEdicao() {
        return modoEdicao;
    }

    public void setModoEdicao(boolean modoEdicao) {
        this.modoEdicao = modoEdicao;
    }

    public Questionario getQuestionario() {
        return this.questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
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

    public List<Questionario> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<Questionario> questionarios) {
        this.questionarios = questionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
