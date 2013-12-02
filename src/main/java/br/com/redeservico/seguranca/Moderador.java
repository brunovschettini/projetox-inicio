package br.com.redeservico.seguranca;

import br.com.redeservico.utilitarios.Data;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SEG_MODERADOR")
public class Moderador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID", nullable = false)
    @OneToOne
    private Usuario usuario;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CADASTRO")
    private Date cadastro;
    @Column(name = "IS_ATIVO")
    private boolean ativo;

    public Moderador() {
        this.id = -1;
        this.usuario = new Usuario();
        this.cadastro = Data.dataHoje();
        this.ativo = true;
    }

    public Moderador(int id, Usuario usuario, Date cadastro, boolean ativo) {
        this.id = id;
        this.usuario = usuario;
        this.cadastro = cadastro;
        this.ativo = ativo;
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

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
