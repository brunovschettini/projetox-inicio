package br.com.redeservico.edicao;

import br.com.redeservico.auxiliar.Categoria1;
import br.com.redeservico.auxiliar.Categoria2;
import br.com.redeservico.auxiliar.Categoria3;
import br.com.redeservico.seguranca.Usuario;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "EDI_EDICAO")
@NamedQuery(name = "Edicao.findById", query = "select edi from Edicao edi where edi.id=:pid")
public class Edicao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "ID_CATEGORIA_1", referencedColumnName = "ID")
    @ManyToOne
    private Categoria1 categoria1;
    @JoinColumn(name = "ID_CATEGORIA_2", referencedColumnName = "ID")
    @ManyToOne
    private Categoria2 categoria2;
    @JoinColumn(name = "ID_CATEGORIA_3", referencedColumnName = "ID")
    @ManyToOne
    private Categoria3 categoria3;
    @Column(name = "DS_TITULO", length = 255)
    private String titulo;
    @Column(name = "DS_TEXTO", length = 5000)
    private String texto;
    @Column(name = "DS_AUTOR", length = 5000)
    private String autor;
    @Column(name = "IS_CAPA", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean capa;
    @Column(name = "IS_ATIVO", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean ativo;

    public Edicao() {
        this.id = -1;
        this.usuario = new Usuario();
        this.categoria1 = new Categoria1();
        this.categoria2 = new Categoria2();
        this.categoria3 = new Categoria3();
        this.titulo = "";
        this.texto = "";
        this.autor = "";
        this.capa = false;
        this.ativo = false;
    }

    public Edicao(int id, Usuario usuario, Categoria1 categoria1, Categoria2 categoria2, Categoria3 categoria3, String titulo, String texto, String autor, boolean capa, boolean ativo) {
        this.id = id;
        this.usuario = usuario;
        this.categoria1 = categoria1;
        this.categoria2 = categoria2;
        this.categoria3 = categoria3;
        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
        this.capa = capa;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isCapa() {
        return capa;
    }

    public void setCapa(boolean capa) {
        this.capa = capa;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
