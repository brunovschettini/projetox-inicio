package br.com.redeservico.pessoa.beans;

import br.com.redeservico.db.InterageDAO;
import br.com.redeservico.endereco.Cidade;
import br.com.redeservico.endereco.Estado;
import br.com.redeservico.endereco.Logradouro;
import br.com.redeservico.endereco.db.EnderecoDAO;
import br.com.redeservico.pessoa.Fisica;
import br.com.redeservico.pessoa.PessoaEndereco;
import br.com.redeservico.pessoa.TipoEndereco;
import br.com.redeservico.pessoa.db.PessoaEnderecoDAO;
import br.com.redeservico.utilitarios.CEPServico;
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
    private List<PessoaEndereco> listaPessoaEnderecos = new ArrayList<PessoaEndereco>();
    private List<SelectItem> listaEstados = new ArrayList<SelectItem>();
    private List<SelectItem> listaCidades = new ArrayList<SelectItem>();
    private List<SelectItem> listaLogradouros = new ArrayList<SelectItem>();
    private List<SelectItem> listaTipoEndereco = new ArrayList<SelectItem>();
    private String mensagem = "";
    private int idCidade = 0;
    private int idTipoEndereco = 0;
    private int idLogradouro = 0;
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
        if (listaEstados.isEmpty()) {
            InterageDAO interageDAO = new InterageDAO();
            List<Estado> list = (List<Estado>) interageDAO.findAll("Estado");
            for (int i = 0; i < list.size(); i++) {
                listaEstados.add(new SelectItem(new Integer(i), list.get(i).getDescricao(), Integer.toString(list.get(i).getId())));
            }
        }        
        return listaEstados;
    }

    public void setListaEstados(List<SelectItem> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<SelectItem> getListaCidades() {
        if (listaCidades.isEmpty()) {
            listaCidades.add(new SelectItem(new Integer(0), "", ""));
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            List<Cidade> list = (List<Cidade>) enderecoDAO.pesquisaCidadesPorEstado(Integer.parseInt(listaEstados.get(idEstado).getDescription()));
            for (int i = 0; i < list.size(); i++) {
                listaCidades.add(new SelectItem(new Integer(i), list.get(i).getDescricao(), Integer.toString(list.get(i).getId())));
            }
        }
        return listaCidades;
    }

    public void setListaCidades(List<SelectItem> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public List<PessoaEndereco> getListaPessoaEnderecos() {
        return listaPessoaEnderecos;
    }

    public void setListaPessoaEnderecos(List<PessoaEndereco> listaPessoaEnderecos) {
        this.listaPessoaEnderecos = listaPessoaEnderecos;
    }

    public List<SelectItem> getListaLogradouros() {
        if (listaLogradouros.isEmpty()) {
            InterageDAO interageDAO = new InterageDAO();
            List<Logradouro> list = (List<Logradouro>) interageDAO.findAll("Logradouro");
            for (int i = 0; i < list.size(); i++) {
                listaLogradouros.add(new SelectItem(new Integer(i), list.get(i).getDescricao(), Integer.toString(list.get(i).getId())));
            }
        }            
        return listaLogradouros;
    }

    public void setListaLogradouros(List<SelectItem> listaLogradouros) {
        this.listaLogradouros = listaLogradouros;
    }

    public List<SelectItem> getListaTipoEndereco() {
        if (listaTipoEndereco.isEmpty()) {
            PessoaEnderecoDAO pessoaEnderecoDAO = new PessoaEnderecoDAO();
            List<TipoEndereco> list = (List<TipoEndereco>) pessoaEnderecoDAO.listaTipoEnderecoDisponivelPessoa(fisica.getPessoa().getId(), 1);
            for (int i = 0; i < list.size(); i++) {
                listaTipoEndereco.add(new SelectItem(new Integer(i), list.get(i).getDescricao(), Integer.toString(list.get(i).getId())));
            }
        }          
        return listaTipoEndereco;
    }

    public void setListaTipoEndereco(List<SelectItem> listaTipoEndereco) {
        this.listaTipoEndereco = listaTipoEndereco;
    }

    public int getIdTipoEndereco() {          
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(int idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public int getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }
    
    public void pesquisaCEP() {
        CEPServico cEPServico = new CEPServico();
        cEPServico.setCep(pessoaEndereco.getEndereco().getCep()); 
        cEPServico.procurar();
    }
}
