package br.com.redeservico.seguranca;

import br.com.redeservico.sistema.Temas;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_USUARIO_PERFIL")
@NamedQuery(name = "UsuarioPerfil.findById", query = "SELECT UP FROM UsuarioPerfil AS UP WHERE UP.id=:pid")
public class UsuarioPerfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "ID_TEMAS", referencedColumnName = "ID")
    @ManyToOne
    private Temas temas;

    public UsuarioPerfil() {
        this.id = -1;
        this.usuario = new Usuario();
        this.temas = new Temas();
    }
    
    public UsuarioPerfil(int id, Usuario usuario, Temas temas) {
        this.id = id;
        this.usuario = usuario;
        this.temas = temas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Temas getTemas() {
        return temas;
    }

    public void setTemas(Temas temas) {
        this.temas = temas;
    }


}
