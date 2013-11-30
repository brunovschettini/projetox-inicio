package br.com.redeservico.edicao;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "EDI_COLUNA")
@NamedQuery(name = "EdicaoColuna.findById", query = "SELECT edic FROM EdicaoColuna edic WHERE edic.id=:pid")
public class EdicaoColuna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;

    public EdicaoColuna() {
        this.id = -1;
        this.edicao = new Edicao();
    }

    public EdicaoColuna(int id, Edicao edicao) {
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
