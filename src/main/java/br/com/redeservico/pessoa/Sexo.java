package br.com.redeservico.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PES_SEXO")
@NamedQuery(name = "Sexo.findById", query = "select sex from Sexo sex where sex.id=:pid")
public class Sexo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
    private String descricao;

    public Sexo() {
        this.id = -1;
        this.descricao = "";
    }

    public Sexo(int id, String descricao) {
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
