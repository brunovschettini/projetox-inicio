package br.com.redeservico.auxiliar;

import br.com.redeservico.seguranca.Usuario;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "AUX_GRUPO_USUARIO")
@NamedQuery(name = "GrupoUsuario.findById", query = "select gc from GrupoUsuario gc where gc.id=:pid")
public class GrupoUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToMany
    private Usuario usuario;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;
    @JoinColumn(name = "ID_CATEGORIA_1", referencedColumnName = "ID")
    @ManyToMany
    private Categoria1 categoria1;
    @JoinColumn(name = "ID_CATEGORIA_2", referencedColumnName = "ID")
    @ManyToMany
    private Categoria2 categoria2;
    @JoinColumn(name = "ID_CATEGORIA_3", referencedColumnName = "ID")
    @ManyToMany
    private Categoria3 categoria3;
    @Column(name = "IS_ATIVO")
    private boolean ativo;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria1 getCategoria1() {
        return categoria1;
    }

    public void setCategoria1(Categoria1 categoria1) {
        this.categoria1 = categoria1;
    }

    public Categoria2 getCategoria2() {
        return categoria2;
    }

    public void setCategoria2(Categoria2 categoria2) {
        this.categoria2 = categoria2;
    }

    public Categoria3 getCategoria3() {
        return categoria3;
    }

    public void setCategoria3(Categoria3 categoria3) {
        this.categoria3 = categoria3;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
