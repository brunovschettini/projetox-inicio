package br.com.redeservico.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PES_TIPO_DOCUMENTO")
@NamedQuery(name = "TipoDocumento.findById", query = "select tdoc from TipoDocumento tdoc where tdoc.id=:pid")

public class TipoDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;

    public TipoDocumento() {
        this.id = -1;
        this.descricao = "";
    }

    public TipoDocumento(int id, String descricao) {
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
