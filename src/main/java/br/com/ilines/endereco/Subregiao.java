package br.com.ilines.endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "END_SUBREGIAO")
@NamedQuery(name = "Subregiao.findById", query = "select sre from Subregiao sre where sre.id=:pid")
public class Subregiao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
    private String descricao;

    public Subregiao() {
        this.id = -1;
        this.descricao = "";
    }

    public Subregiao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String geDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
