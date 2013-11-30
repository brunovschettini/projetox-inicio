package br.com.redeservico.auxiliar;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "AUX_CATEGORIA_3")
@NamedQuery(name = "Categoria3.findById", query = "SELECT C FROM Categoria3 AS C WHERE C.id = :pid")
public class Categoria3 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_CATEGORIA_2", referencedColumnName = "ID")
    @ManyToOne
    private Categoria2 categoria2;
    @Column(name = "DS_DESCRICAO", length = 50)
    private String descricao;

    public Categoria3() {
        this.id = -1;
        this.categoria2 = new Categoria2();
        this.descricao = "";
    }

    public Categoria3(int id, Categoria2 categoria2, String descricao) {
        this.id = id;
        this.categoria2 = categoria2;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria2 getCategoria2() {
        return categoria2;
    }

    public void setCategoria2(Categoria2 categoria2) {
        this.categoria2 = categoria2;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
