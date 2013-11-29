package br.com.redeservico.seguranca.acesso;

import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.seguranca.dao.UsuarioDAO;
import br.com.redeservico.utilitarios.GenericaMensagem;
import br.com.redeservico.utilitarios.GenericaSessao;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class ControleAcessoMB implements Serializable {

    private Usuario usuario = new Usuario();
    HttpServletRequest paginaRequerida;
    String urlDestino;

    @PostConstruct
    public void init() {
        System.out.println(" Execultado usuário bean!");
    }

    public String login() throws IOException {
        if (usuario.getLogin().equals("")) {
            GenericaMensagem.info("Validação", "Informar login!");
            return null;
        }
        if (usuario.getSenha().equals("")) {
            GenericaMensagem.info("Validação", "Informar senha!");
            return null;
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.validaUsuario(usuario);
        if (usuario == null) {
            usuario = new Usuario();
            GenericaMensagem.warn("Validação", "Usuário / senha inválidos!");
            return null;
        }
        GenericaSessao.put("sessaoUsuario", this.usuario);
        GenericaSessao.put("userName", this.usuario.getLogin());
        GenericaSessao.put("indicaAcesso", "local");
        GenericaSessao.put("linkClicado", true);
        
        if (GenericaSessao.exists("paginaSessaoExpirada")) {
            String urlDestinoString = GenericaSessao.getString("paginaSessaoExpirada", true);
            FacesContext conext = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getExternalContext().redirect(urlDestinoString);
            return null;
        }
        if (usuario.getTipoUsuarioAcesso().getId() == 1) {
            if (usuarioDAO.usuarioAdministradorExiste(usuario) != null) {
                return "adminRedeServico";
            }
        } else if (usuario.getTipoUsuarioAcesso().getId() == 2) {
            if (usuarioDAO.usuarioEmpresaExiste(usuario) != null) {
                return "adminRedeServico";
            }
        } else if (usuario.getTipoUsuarioAcesso().getId() == 3) {
            if (usuarioDAO.usuarioClienteExiste(usuario) != null) {
                return "adminRedeServico";
            }
        }
        return "login";
    }
    
    public String getValidacao() throws IOException {
        if (!GenericaSessao.exists("sessaoUsuario")) {
            paginaRequerida = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String urlDestinoString = "";
            if (paginaRequerida != null) {
                urlDestinoString = paginaRequerida.getRequestURI().replace(paginaRequerida.getContextPath(), "").replace("/", "");
                GenericaSessao.put("paginaSessaoExpirada", urlDestinoString);
            }
            FacesContext conext = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getExternalContext().redirect("?redir="+urlDestinoString);
            return "login";
        }
        paginaRequerida = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        urlDestino = paginaRequerida.getRequestURI();
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("indicaAcesso") == null) {
            return "login";
        }
        return null;
    }    

    public void logout() throws IOException {
        String retorno = "";
        if (GenericaSessao.exists("sessaoCliente")) {
            retorno += GenericaSessao.getString("sessaoCliente") + "/";
        }
        FacesContext conext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) conext.getExternalContext().getSession(false);
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect(retorno);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
