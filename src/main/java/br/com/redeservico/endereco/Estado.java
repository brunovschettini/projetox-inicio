package br.com.redeservico.endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "END_ESTADO")
@NamedQuery(name = "Estado.findById", query = "select est from Estado est where est.id=:pid")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_REGIAO", referencedColumnName = "ID")
    @ManyToOne
    private Regiao regiao;
    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
    private String descricao;
    @Column(name = "DS_SIGLA", length = 50, unique = true)
    private String sigla;

    public Estado() {
        this.id = -1;
        this.regiao = new Regiao();
        this.descricao = "";
        this.sigla = "";
    }

    public Estado(int id, Regiao regiao, String descricao, String sigla) {
        this.id = id;
        this.regiao = regiao;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
