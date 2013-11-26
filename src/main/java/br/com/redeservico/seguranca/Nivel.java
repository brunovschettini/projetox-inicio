package br.com.redeservico.seguranca;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_NIVEL")
@NamedQuery(name = "Nivel.findById", query = "select niv from Nivel niv where niv.id=:pid")
public class Nivel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;

    public Nivel() {
        this.id = -1;
        this.descricao = "";
    }

    public Nivel(int id, String descricao) {
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
