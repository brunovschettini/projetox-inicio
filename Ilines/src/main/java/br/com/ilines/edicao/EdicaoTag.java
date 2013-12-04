package br.com.ilines.edicao;

import br.com.ilines.auxiliar.Tag;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "EDI_TAG")
@NamedQuery(name = "EdicaoTag.findById", query = "SELECT edit FROM EdicaoTag edit WHERE edit.id=:pid")
public class EdicaoTag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;
    @JoinColumn(name = "ID_TAG", referencedColumnName = "ID")
    @ManyToOne
    private Tag tag;

    public EdicaoTag() {
        this.id = -1;
        this.edicao = new Edicao();
        this.tag = new Tag();
    }

    public EdicaoTag(int id, Edicao edicao, Tag tag) {
        this.id = id;
        this.edicao = edicao;
        this.tag = tag;
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
