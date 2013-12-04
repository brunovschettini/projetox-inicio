package br.com.ilines.seguranca;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_DEPARTAMENTO")
@NamedQuery(name = "Departamento.findById", query = "select dep from Departamento dep where dep.id=:pid")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;

    public Departamento() {
        this.id = -1;
        this.descricao = "";
    }

    public Departamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
