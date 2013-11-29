package br.com.redeservico.pessoa.beans;

import br.com.redeservico.db.InterageDAO;
import br.com.redeservico.pessoa.Fisica;
import br.com.redeservico.pessoa.PessoaEndereco;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class FisicaMB implements Serializable {
    
    private Fisica fisica = new Fisica();
    private PessoaEndereco pessoaEndereco = new PessoaEndereco();
    private List<Fisica> listaFisicas = new ArrayList<Fisica>();
    private List<SelectItem> listaEstados = new ArrayList<SelectItem>();
    private List<SelectItem> listaCidades = new ArrayList<SelectItem>();
    private String mensagem = "";
    private int idCidade = 0;
    private int idEstado = 0;
    
    public void salvar() {
        InterageDAO interageDAO = new InterageDAO();
        if (fisica.getPessoa().getNome().equals("")) {
            mensagem = "";
            return;
        }
        if (fisica.getPessoa().getEmail().equals("")) {
            mensagem = "";
            return;
        }
        if (fisica.getNascimento().equals("")) {
            mensagem = "";
            return;
        }
        if (fisica.getPessoa().getDocumento().equals("")) {
            mensagem = "";
            return;
        }
        if (fisica.getId() == -1) {
            interageDAO.openTransaction();
            if (interageDAO.insert(fisica)) {
                interageDAO.commit();
                mensagem = "";
            } else {
                interageDAO.rollback();
                mensagem = "";
            }
        } else {
            if (interageDAO.alter(fisica)) {
                interageDAO.commit();
                mensagem = "";
            } else {
                interageDAO.rollback();
                mensagem = "";
            }            
        }
    }
    
    public void excluir() {
        if (fisica.getId() == -1) {
            InterageDAO interageDAO = new InterageDAO();
            interageDAO.openTransaction();
            if (interageDAO.delete((Fisica) interageDAO.findObjectByID(fisica.getId(), "Fisicai"))) {
                interageDAO.commit();
                mensagem = "";
            } else {
                interageDAO.rollback();
                mensagem = "";
            }
        } else {
            mensagem = "";
        }
    }
    
    public void novo() {
        fisica = new Fisica();
        mensagem = "";
    }
    
    public String editar() {
        return "pessoaFisica";
    }

    public Fisica getFisica() {
        return fisica;
    }

    public void setFisica(Fisica fisica) {
        this.fisica = fisica;
    }

    public List<Fisica> getListaFisicas() {
        return listaFisicas;
    }

    public void setListaFisicas(List<Fisica> listaFisicas) {
        this.listaFisicas = listaFisicas;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public PessoaEndereco getPessoaEndereco() {
        return pessoaEndereco;
    }

    public void setPessoaEndereco(PessoaEndereco pessoaEndereco) {
        this.pessoaEndereco = pessoaEndereco;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public List<SelectItem> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<SelectItem> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<SelectItem> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<SelectItem> listaCidades) {
        this.listaCidades = listaCidades;
    }
}
