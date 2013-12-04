package br.com.ilines.endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "END_BAIRRO")
@NamedQueries({
    @NamedQuery(name = "Bairro.findById", query = "SELECT BAI FROM Bairro AS BAI WHERE BAI.id = :pid"),
    @NamedQuery(name = "Bairro.findAll", query = "SELECT BAI FROM Bairro AS BAI ORDER BY BAI.descricao ASC "),
    @NamedQuery(name = "Bairro.findByName", query = "SELECT BAI FROM Bairro AS BAI WHERE UPPER(BAI.descricao) LIKE :pdescricao ORDER BY BAI.descricao ASC ")
})
public class Bairro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 70, nullable = false, unique = true)
    private String descricao;

    public Bairro() {
        this.id = -1;
        this.descricao = "";
    }

    public Bairro(int id, String descricao) {
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
