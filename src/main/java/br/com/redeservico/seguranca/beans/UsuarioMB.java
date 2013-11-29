package br.com.redeservico.seguranca.beans;

import br.com.redeservico.db.InterageDAO;
import br.com.redeservico.pessoa.Pessoa;
import br.com.redeservico.seguranca.TipoUsuarioAcesso;
import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.seguranca.UsuarioAdministrador;
import br.com.redeservico.seguranca.UsuarioCliente;
import br.com.redeservico.seguranca.UsuarioEmpresa;
import br.com.redeservico.seguranca.dao.UsuarioDAO;
import br.com.redeservico.utilitarios.Data;
import br.com.redeservico.utilitarios.GenericaMensagem;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class UsuarioMB {

    private Usuario usuario = new Usuario();
    private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private boolean adminstrador = false;
    private boolean cliente = false;
    private boolean empresa = false;
    private boolean tipoUsuarioVeridicado = false;
    private boolean modificarSenha = true;
    private String mensagem = "";
    private String senha = "";
    private String confirmaSenha = "";
    private List<SelectItem> listaTipoAcesso = new ArrayList<SelectItem>();
    private int idTipoUsuario = 0;

    public void init() {
        System.err.println("UsuarioBean");
    }

    public void salvarAdministrador() {
        if (usuario.getLogin().equals("")) {
            mensagem = "Informar nome de usuário!";
            return;
        }
        if (!modificarSenha) {
            if (senha.equals("")) {
                mensagem = "Informar a senha de confirmação!";
                return;
            }
            if (confirmaSenha.equals("")) {
                mensagem = "Informar a senha de confirmação!";
                return;
            }
            if (senha.length() < 5) {
                mensagem = "A senha deve ter no mínno 5 caracteres";
                return;
            }
            if (confirmaSenha.length() < 5) {
                mensagem = "A senha deve ter no mínno 5 caracteres";
                return;
            }
            if (!confirmaSenha.equals(senha)) {
                modificarSenha = true;
                senha = "";
                confirmaSenha = "";
                mensagem = "Senhas não conferem!";
                return;
            }
            modificarSenha = true;
            usuario.setSenha(senha);
            senha = "";
            confirmaSenha = "";
        }
        InterageDAO interageDAO = new InterageDAO();
        usuario.setTipoUsuarioAcesso((TipoUsuarioAcesso) interageDAO.findId(Integer.parseInt(listaTipoAcesso.get(idTipoUsuario).getDescription()), "TipoUsuarioAcesso"));
        usuario.setPessoa((Pessoa) interageDAO.findObjectByID(1, "Pessoa"));
        if (usuario.getPessoa().getId() == -1) {
            mensagem = "Pesquisar uma pessoa!";
            return;
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario u = (Usuario) usuarioDAO.usuarioExiste(this.usuario);
        if (usuario.getId() == -1) {
            if (u != null) {
                mensagem = "Usuário já cadastrado no sistema!";
                return;
            }
            this.usuario.setDtCadastro(Data.dataHoje());
            usuario.setTipoUsuarioAcesso((TipoUsuarioAcesso) interageDAO.findObjectByID(1, "TipoUsuarioAcesso"));
            interageDAO.openTransaction();
            if (!interageDAO.insert(this.getUsuario())) {
                interageDAO.rollback();
                mensagem = "Erro ao inserir registro!";
            }
            UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
            usuarioAdministrador.setUsuario(this.usuario);
            if (!interageDAO.insert(usuarioAdministrador)) {
                interageDAO.rollback();
                mensagem = "Erro ao inserir registro!";
            }
            interageDAO.commit();
            mensagem = "Registro inserido com sucesso";
            listaUsuarios.clear();
        } else {
            interageDAO.openTransaction();
            if (interageDAO.alter(this.getUsuario())) {
                interageDAO.commit();
                listaUsuarios.clear();
                mensagem = "Registro atualizado com sucesso";
            } else {
                interageDAO.rollback();
                mensagem = "Erro ao atualizar registro!";
            }
        }
    }

    public void excluir() {
        if (this.getUsuario().getId() != -1) {
            InterageDAO interageDAO = new InterageDAO();
            interageDAO.openTransaction();
            if (interageDAO.delete((Usuario) interageDAO.findObjectByID(this.getUsuario().getId(), "Usuario"))) {
                interageDAO.commit();
                novo();
                mensagem = "Registro excluído com sucesso";
            } else {
                interageDAO.rollback();
                mensagem = "Erro ao excluir registro!";
            }
        }
    }

    public String editarAdministrador(Usuario u) {
        usuario = u;
        for (int i = 0; i < listaTipoAcesso.size(); i++) {
            if (Integer.parseInt(listaTipoAcesso.get(i).getDescription()) == usuario.getTipoUsuarioAcesso().getId()) {
                idTipoUsuario = i;
                break;
            }
        }
        return "usuarioAdministrador";
    }

    public void novo() {
        usuario = new Usuario();
        mensagem = "";
        cliente = false;
        empresa = false;
        senha = "";
        confirmaSenha = "";
        modificarSenha = true;
        adminstrador = false;
        tipoUsuarioVeridicado = false;
    }

    public Usuario getUsuario() {
        if (usuario.getId() != -1) {
            modificarSenha = true;
            if (!tipoUsuarioVeridicado) {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if (((UsuarioAdministrador) usuarioDAO.usuarioAdministradorExiste(usuario)) != null) {
                    adminstrador = true;
                }
                if (((UsuarioCliente) usuarioDAO.usuarioClienteExiste(usuario)) != null) {
                    cliente = true;
                }
                if (((UsuarioEmpresa) usuarioDAO.usuarioEmpresaExiste(usuario)) != null) {
                    empresa = true;
                }
                tipoUsuarioVeridicado = true;
            }
        } else {
            modificarSenha = false;
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<Usuario> getListaUsuarios() {
        if (listaUsuarios.isEmpty()) {
            InterageDAO interageDAO = new InterageDAO();
            listaUsuarios = (List<Usuario>) interageDAO.findAll("Usuario");
        }
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public boolean isAdministrador() {
        return adminstrador;
    }

    public boolean isCliente() {
        return cliente;
    }

    public boolean isEmpresa() {
        return empresa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public boolean isModificarSenha() {
        return modificarSenha;
    }

    public void setModificarSenha(boolean modificarSenha) {
        this.modificarSenha = modificarSenha;
    }

    public void alterarSenha() {
        modificarSenha = false;
    }

    public void validaSenha() {
        if (!confirmaSenha.equals("") && !senha.equals("")) {
            if (senha.length() < 5) {
                GenericaMensagem.warn("Validação", "A senha deve ter no mínno 5 caracteres");
                return;
            }
            if (confirmaSenha.length() < 5) {
                GenericaMensagem.warn("Validação", "A senha deve ter no mínno 5 caracteres");
                return;
            }
            if (!confirmaSenha.equals(senha)) {
                GenericaMensagem.warn("Validação", "Senhas não conferem!");
                return;
            }
            GenericaMensagem.info("Sistema", "Senha veríficada com sucesso");
        }
    }

    public List<SelectItem> getListaTipoAcesso() {
        if (listaTipoAcesso.isEmpty()) {
            InterageDAO interageDAO = new InterageDAO();
            List<TipoUsuarioAcesso> list = interageDAO.findAll("TipoUsuarioAcesso");
            for (int i = 0; i < list.size(); i++) {
                listaTipoAcesso.add(new SelectItem(new Integer(i), list.get(i).getDescricao(), Integer.toString(list.get(i).getId())));
            }
        }
        return listaTipoAcesso;
    }

    public void setListaTipoAcesso(List<SelectItem> listaTipoAcesso) {
        this.listaTipoAcesso = listaTipoAcesso;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
}
