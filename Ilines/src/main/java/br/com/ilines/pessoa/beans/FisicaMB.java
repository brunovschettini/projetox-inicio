package br.com.ilines.pessoa.beans;

import br.com.ilines.dao.InterageDAO;
import br.com.ilines.endereco.Cidade;
import br.com.ilines.endereco.Endereco;
import br.com.ilines.endereco.Estado;
import br.com.ilines.endereco.Logradouro;
import br.com.ilines.endereco.dao.EnderecoDAO;
import br.com.ilines.pessoa.EstadoCivil;
import br.com.ilines.pessoa.Fisica;
import br.com.ilines.pessoa.PessoaEndereco;
import br.com.ilines.pessoa.Sexo;
import br.com.ilines.pessoa.TipoDocumento;
import br.com.ilines.pessoa.TipoEndereco;
import br.com.ilines.pessoa.dao.PessoaEnderecoDAO;
import br.com.ilines.utilitarios.CEPServico;
import br.com.ilines.utilitarios.GenericaMensagem;
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
    private Endereco endereco = new Endereco();
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
            mensagem = "informar o nome!";
            return;
        }
        if (fisica.getPessoa().getEmail().equals("")) {
            mensagem = "Informar e-mail!";
            return;
        }
        if (fisica.getNascimento().equals("")) {
            mensagem = "Informar data de nascimento!";
            return;
        }
        if (fisica.getPessoa().getDocumento().equals("")) {
            mensagem = "Informar o número de documento!";
            return;
        }
        if (fisica.getId() == -1) {
            fisica.getPessoa().setTipoDocumento((TipoDocumento) interageDAO.findObjectByID(1, "TipoDocumento"));
            fisica.setEstadoCivil((EstadoCivil) interageDAO.findObjectByID(1, "EstadoCivil"));
            fisica.setSexo((Sexo) interageDAO.findObjectByID(1, "Sexo"));
            interageDAO.openTransaction();
            if (!interageDAO.insert(fisica.getPessoa())) {
                mensagem = "Falha ao adicionar registro!";
                interageDAO.rollback();
                return;
            }
            if (interageDAO.insert(fisica)) {
                interageDAO.commit();
                mensagem = "Registro inserido com sucesso";
            } else {
                interageDAO.rollback();
                mensagem = "Falha ao adicionar registro!";
            }
        } else {
            if (interageDAO.alter(fisica)) {
                interageDAO.commit();
                mensagem = "Registro atualizado com sucesso";
            } else {
                interageDAO.rollback();                
                mensagem = "Falha ao adicionar registro!";
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
        pessoaEndereco = new PessoaEndereco();
        endereco = new Endereco();        
        listaTipoEndereco.clear();
        listaPessoaEnderecos.clear();
        mensagem = "";
    }

    public String editar(Fisica f) {
        fisica = f;
        carregaSelectItems();
        return "pessoaFisica";
    }

    public Fisica getFisica() {
        return fisica;
    }

    public void setFisica(Fisica fisica) {
        this.fisica = fisica;
    }

    public List<Fisica> getListaFisicas() {
        if(listaFisicas.isEmpty()) {
            InterageDAO interageDAO = new InterageDAO();
            listaFisicas = (List<Fisica>) interageDAO.findAll("Fisica");
        }
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
                listaEstados.add(new SelectItem(new Integer(i), list.get(i).getSigla(), Integer.toString(list.get(i).getId())));
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
        if (listaPessoaEnderecos.isEmpty()) {
            PessoaEnderecoDAO pessoaEnderecoDAO = new PessoaEnderecoDAO();
            listaPessoaEnderecos = pessoaEnderecoDAO.listaEnderecosPorPessoa(fisica.getPessoa().getId());            
        }
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
        listaCidades.clear();
        listaLogradouros.clear();
        endereco = cEPServico.getEndereco();
        pessoaEndereco.setEndereco(endereco);
        for (int i = 0; i < listaCidades.size(); i++) {
            if (Integer.parseInt(listaCidades.get(i).getDescription()) == pessoaEndereco.getEndereco().getCidade().getId()) {
                idCidade = i;
                break;
            }            
        }
        for (int i = 0; i < listaLogradouros.size(); i++) {
            if (Integer.parseInt(listaLogradouros.get(i).getDescription()) == pessoaEndereco.getEndereco().getLogradouro().getId()) {
                idLogradouro = i;
                break;
            }            
        }
        for (int i = 0; i < listaEstados.size(); i++) {
            if (Integer.parseInt(listaEstados.get(i).getDescription()) == pessoaEndereco.getEndereco().getCidade().getEstado().getId()) {
                idEstado = i;
                break;
            }            
        }
        for (int i = 0; i < listaTipoEndereco.size(); i++) {
            if (Integer.parseInt(listaTipoEndereco.get(i).getDescription()) == pessoaEndereco.getTipoEndereco().getId()) {
                idTipoEndereco = i;
                break;
            }            
        }
    }
    
    public void carregaSelectItems() {
        getListaCidades();
        getListaLogradouros();
        getListaTipoEndereco();
    }

    public void adicionarPessoaEndereco() {
        if (pessoaEndereco.getEndereco().getCep().equals("")) {
            GenericaMensagem.error("Sistema", "Informar o cep!");
            return;            
        }
        if (pessoaEndereco.getId() == -1) {
            InterageDAO interageDAO = new InterageDAO();
            interageDAO.openTransaction();
            if (!pessoaEndereco.getEndereco().getDescricaoEndereco().equals(endereco.getDescricaoEndereco())) {
                if (endereco == null) {
                    GenericaMensagem.error("Sistema", "Endereço inválido!");
                    return;
                }
                endereco.setId(-1);
                endereco.setDescricaoEndereco(pessoaEndereco.getEndereco().getDescricaoEndereco());
                if (!interageDAO.insert(endereco)) {
                    GenericaMensagem.error("Sistema", "Falha ao adicionar registro!");
                    interageDAO.rollback();
                    return;
                }
            }
            pessoaEndereco.setPessoa(fisica.getPessoa());
            pessoaEndereco.setTipoEndereco((TipoEndereco) interageDAO.findObjectByID(Integer.parseInt(listaTipoEndereco.get(idTipoEndereco).getDescription()), "TipoEndereco"));
            if (!interageDAO.insert(pessoaEndereco)) {
                GenericaMensagem.error("Sistema", "Falha ao adicionar registro!");
                interageDAO.rollback();
                return;
            }
            carregaSelectItems();
            interageDAO.commit();
            listaTipoEndereco.clear();
            listaPessoaEnderecos.clear();
            GenericaMensagem.info("Sucesso", "Registro adicionado");
            pessoaEndereco = new PessoaEndereco();            
            endereco = new Endereco();
        }
    }

    public void removerPessoaEndereco(PessoaEndereco pe) {
        InterageDAO interageDAO = new InterageDAO();
        interageDAO.openTransaction();
        if (interageDAO.delete((PessoaEndereco) interageDAO.findObjectByID(pe.getId(), "PessoaEndereco"))) {
            interageDAO.commit();
            GenericaMensagem.info("Sucesso", "Registro removido");
            listaTipoEndereco.clear();
            listaPessoaEnderecos.clear();
        } else {
            interageDAO.rollback();
            GenericaMensagem.error("Sistema", "Falha ao remover registro!");
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
