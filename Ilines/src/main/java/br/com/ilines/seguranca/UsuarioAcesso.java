package br.com.ilines.seguranca;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_USUARIO_ACESSO")
@NamedQuery(name = "UsuarioAcesso.findById", query = "select ua from UsuarioAcesso ua where ua.id=:pid")
public class UsuarioAcesso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "ID_PERMISSAO", referencedColumnName = "ID")
    @ManyToOne
    private Permissao permissao;
    @Column(name = "IS_PERMITE", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean permite;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EXPIRA")
    private Date expira;

    public UsuarioAcesso() {
        this.id = -1;
        this.usuario = new Usuario();
        this.permissao = new Permissao();
        this.permite = true;
        this.expira = new Date();
    }

    public UsuarioAcesso(int id, Usuario usuario, Permissao permissao, boolean permite, Date expira) {
        this.id = id;
        this.usuario = usuario;
        this.permissao = permissao;
        this.permite = permite;
        this.expira = expira;
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

    public boolean isPermite() {
        return permite;
    }

    public void setPermite(boolean permite) {
        this.permite = permite;
    }

    public Date getExpira() {
        return expira;
    }

    public void setExpira(Date expira) {
        this.expira = expira;
    }
}
