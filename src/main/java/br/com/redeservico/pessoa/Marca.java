package br.com.redeservico.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PES_MARCA")
@NamedQueries({
    @NamedQuery(name = "Marca.findById", query = "SELECT MAR FROM Marca AS MAR WHERE MAR.id = :pid"),
    @NamedQuery(name = "Marca.findAll", query = "SELECT MAR FROM Marca AS MAR ORDER BY MAR.fabricante.juridica.pessoa.nome ASC, MAR.descricao ASC"),
    @NamedQuery(name = "Marca.findByName", query = "SELECT MAR FROM Marca AS MAR WHERE MAR.descricao LIKE :description ORDER BY MAR.fabricante.juridica.pessoa.nome ASC, MAR.descricao ASC")
})
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_FABRICANTE", referencedColumnName = "ID")
    @ManyToOne
    private Fabricante fabricante;
    @Column(name = "DS_DESCRICAO", length = 100)
    private String descricao;

    public Marca() {
        this.id = -1;
        this.fabricante = new Fabricante();
        this.descricao = "";
    }

    public Marca(int id, Fabricante fabricante1, String descricao) {
        this.id = id;
        this.fabricante = fabricante1;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante1) {
        this.fabricante = fabricante1;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
