package br.com.redeservico.seguranca;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SEG_USUARIO_ULTIMO_ACESSO")
@NamedQuery(name = "UsuarioUltimoAcesso.findById", query = "select uua from UsuarioUltimoAcesso uua where uua.id=:pid")
public class UsuarioUltimoAcesso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "ID_PERMISSAO", referencedColumnName = "ID")
    @ManyToOne
    private Permissao permissao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ACESSO")
    private Date acesso;

    public UsuarioUltimoAcesso() {
        this.id = -1;
        this.usuario = new Usuario();
        this.permissao = new Permissao();
        this.acesso = new Date();
    }

    public UsuarioUltimoAcesso(int id, Usuario usuario, Permissao permissao, boolean permite, Date acesso) {
        this.id = id;
        this.usuario = usuario;
        this.permissao = permissao;
        this.acesso = acesso;
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

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public Date getAcesso() {
        return acesso;
    }

    public void setAcesso(Date acesso) {
        this.acesso = acesso;
    }
}
