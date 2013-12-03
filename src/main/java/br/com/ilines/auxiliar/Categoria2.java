package br.com.ilines.auxiliar;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "AUX_CATEGORIA_2")
@NamedQuery(name = "Categoria2.findById", query = "SELECT C FROM Categoria2 AS C WHERE C.id = :pid")
public class Categoria2 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_CATEGORIA_1", referencedColumnName = "ID")
    @ManyToOne
    private Categoria1 categoria1;
    @Column(name = "DS_DESCRICAO", length = 50)
    private String descricao;

    public Categoria2() {
        this.id = -1;
        this.categoria1 = new Categoria1();
        this.descricao = "";
    }

    public Categoria2(int id, Categoria1 categoria1, String descricao) {
        this.id = id;
        this.categoria1 = categoria1;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria1 getCategoria1() {
        return categoria1;
    }

    public void setCategoria1(Categoria1 categoria1) {
        this.categoria1 = categoria1;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
