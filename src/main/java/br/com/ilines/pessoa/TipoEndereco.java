package br.com.ilines.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PES_TIPO_ENDERECO")
@NamedQuery(name = "TipoEndereco.findById", query = "select tend from TipoEndereco tend where tend.id = :pid")
public class TipoEndereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false, unique = true)
    private String descricao;

    public TipoEndereco() {
        this.id = -1;
        this.descricao = "";
    }

    public TipoEndereco(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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
}
