package br.com.redeservico.endereco;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "END_PAIS")
@NamedQuery(name = "Pais.findById", query = "select pa from Pais pa where pa.id=:pid")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_CONTINENTE", referencedColumnName = "ID")
    @ManyToOne
    private Continente continente;
    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
    private String descricao;

    public Pais() {
        this.id = -1;
        this.continente = new Continente();
        this.descricao = "";
    }

    public Pais(int id, Continente continente, String descricao) {
        this.id = id;
        this.continente = continente;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public String geDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
