package br.com.redeservico.auxiliar;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "AUX_CATEGORIA_1")
@NamedQuery(name = "Categoria1.findById", query = "SELECT C FROM Categoria1 AS C WHERE C.id = :pid")
public class Categoria1 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "ID_GRUPO_CATEGORIA", referencedColumnName = "ID")
    @ManyToOne
    private GrupoCategoria grupoCategoria;

    @Column(name = "DS_DESCRICAO", length = 50)
    private String descricao;

    public Categoria1() {
        this.id = -1;
        this.grupoCategoria = new GrupoCategoria();
        this.descricao = "";
    }

    public Categoria1(int id, GrupoCategoria grupoCategoria, String descricao) {
        this.id = id;
        this.grupoCategoria = grupoCategoria;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GrupoCategoria getGrupoCategoria() {
        return grupoCategoria;
    }

    public void setGrupoCategoria(GrupoCategoria grupoCategoria) {
        this.grupoCategoria = grupoCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
