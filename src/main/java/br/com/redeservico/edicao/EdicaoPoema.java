package br.com.redeservico.edicao;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "EDI_POEMA")
@NamedQuery(name = "EdicaoPoema.findById", query = "SELECT epoe FROM EdicaoPoema epoe WHERE epoe.id=:pid")
public class EdicaoPoema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;

    public EdicaoPoema() {
        this.id = -1;
        this.edicao = new Edicao();
    }

    public EdicaoPoema(int id, Edicao edicao) {
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
