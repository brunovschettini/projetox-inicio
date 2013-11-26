
package br.com.redeservico.seguranca.acesso;

import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.seguranca.dao.UsuarioDAO;
import br.com.redeservico.utilitarios.GenericaMensagem;
import br.com.redeservico.utilitarios.GenericaSessao;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ControleAcessoBean implements Serializable {
    
    private Usuario usuario = new Usuario();

    @PostConstruct
    public void init(){ 
        System.out.println(" Execultado usuário bean!"); 
    }
    
    public String login () {
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
        
        if (usuario.getId() != -1) {
            return "adminRedeServico";
        } else {
            return "adminRedeServico";            
        }
        
    }
    
    public void logout () {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
