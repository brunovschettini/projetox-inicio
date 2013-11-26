package br.com.redeservico.endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "END_REGIAO")
@NamedQuery(name = "Regiao.findById", query = "select re from Regiao re where re.id=:pid")
public class Regiao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
    private String descricao;

    public Regiao() {
        this.id = -1;
        this.descricao = "";
    }

    public Regiao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String geDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
