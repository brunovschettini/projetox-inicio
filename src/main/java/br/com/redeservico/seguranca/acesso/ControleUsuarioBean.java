
package br.com.redeservico.seguranca.acesso;

import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.utilitarios.GenericaSessao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ControleUsuarioBean {
    
    private Usuario usuario;
    private Usuario usuarioSessao = (Usuario) GenericaSessao.getObject("sessaoUsuario");
    
    public String verificaPermissao() {
        if (usuarioSessao != null) {
            if (usuarioSessao.getId() != -1) {
                
            }
        }
        return "index";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
