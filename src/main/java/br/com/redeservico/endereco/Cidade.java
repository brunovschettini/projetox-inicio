package br.com.redeservico.endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "END_CIDADE")
@NamedQuery(name = "Cidade.findById", query = "select cid from Cidade cid where cid.id=:pid")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50)
    private String descricao;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    @ManyToOne
    private Estado estado;
    @JoinColumn(name = "ID_SUBREGIAO", referencedColumnName = "ID")
    @ManyToOne
    private Subregiao subregiao;

    public Cidade() {
        this.id = -1;
        this.descricao = "";
        this.estado = new Estado();
        this.subregiao = new Subregiao();
    }

    public Cidade(int id, String descricao, Estado estado, Subregiao subregiao) {
        this.id = id;
        this.descricao = descricao;
        this.estado = estado;
        this.subregiao = subregiao;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Subregiao getSubregiao() {
        return subregiao;
    }

    public void setSubregiao(Subregiao subregiao) {
        this.subregiao = subregiao;
    }
}
