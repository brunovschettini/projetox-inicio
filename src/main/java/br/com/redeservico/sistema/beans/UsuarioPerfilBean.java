package br.com.redeservico.sistema.beans;

import br.com.redeservico.seguranca.UsuarioPerfil;
import br.com.redeservico.sistema.Temas;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "usuarioPerfilBean")
@SessionScoped
public class UsuarioPerfilBean {
    
    private List<SelectItem> listaTemas = new ArrayList<SelectItem>();
    private Temas temas = new Temas();
    private UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
    private String tema = "flick";

    public List<SelectItem> getListaTemas() {
        return listaTemas;
    }

    public void setListaTemas(List<SelectItem> listaTemas) {
        this.listaTemas = listaTemas;
    }

    public Temas getTemas() {
        return temas;
    }

    public void setTemas(Temas temas) {
        this.temas = temas;
    }

    public UsuarioPerfil getUsuarioPerfil() {
        return usuarioPerfil;
    }

    public void setUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    

}