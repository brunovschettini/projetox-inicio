package br.com.redeservico.edicao;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "EDI_SORRIA")
@NamedQuery(name = "EdicaoSorria.findById", query = "SELECT esor FROM EdicaoSorria esor WHERE esor.id=:pid")
public class EdicaoSorria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;

    public EdicaoSorria() {
        this.id = -1;
        this.edicao = new Edicao();
    }

    public EdicaoSorria(int id, Edicao edicao) {
        this.id = id;
        this.edicao = edicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
}
