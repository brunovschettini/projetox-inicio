
package br.com.ilines.seguranca.acesso;

import br.com.ilines.seguranca.Usuario;
import br.com.ilines.utilitarios.GenericaSessao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ControleUsuarioMB {
    
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
