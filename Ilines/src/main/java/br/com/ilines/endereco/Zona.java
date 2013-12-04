package br.com.ilines.endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "END_ZONA")
@NamedQueries({
    @NamedQuery(name = "Zona.findById", query = "SELECT Z FROM Zona AS Z WHERE Z.id = :pid"),
    @NamedQuery(name = "Zona.findAll", query = "SELECT Z FROM Zona AS Z ORDER BY Z.descricao ASC "),
    @NamedQuery(name = "Zona.findByName", query = "SELECT Z FROM Zona AS Z WHERE UPPER(Z.descricao) LIKE :pdescricao ORDER BY Z.descricao ASC ")
})
public class Zona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 70, nullable = false, unique = true)
    private String descricao;

    public Zona() {
        this.id = -1;
        this.descricao = "";
    }

    public Zona(int id, String descricao) {
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
