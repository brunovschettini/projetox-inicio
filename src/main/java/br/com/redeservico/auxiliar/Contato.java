package br.com.redeservico.auxiliar;

import br.com.redeservico.edicao.Edicao;
import br.com.redeservico.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "AUX_CONTATO")
@NamedQuery(name = "Contato.findById", query = "SELECT C FROM Contato AS C WHERE C.id = :pid")
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @ManyToOne
    private Pessoa pessoa;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;
    @JoinColumn(name = "ID_TIPO_CONTATO", referencedColumnName = "ID")
    @ManyToOne
    private TipoContato tipoContato;
    @Column(name = "DS_DESCRICAO", length = 255, nullable = false)
    private String descricao;

    public Contato() {
        this.id = -1;
        this.pessoa = new Pessoa();
        this.edicao = new Edicao();
        this.tipoContato = new TipoContato();
        this.descricao = "";
    }

    public Contato(int id, Pessoa pessoa, Edicao edicao, TipoContato tipoContato, String descricao) {
        this.id = id;
        this.pessoa = pessoa;
        this.edicao = edicao;
        this.tipoContato = tipoContato;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
