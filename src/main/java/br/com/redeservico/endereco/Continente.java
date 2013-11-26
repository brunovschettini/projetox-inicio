package br.com.redeservico.endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "END_CONTINENTE")
@NamedQuery(name = "Continente.findById", query = "select c from Continente c where c.id=:pid")
public class Continente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;

    public Continente() {
        this.id = -1;
        this.descricao = "";
    }

    public Continente(int id, String descricao, String uf) {
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
