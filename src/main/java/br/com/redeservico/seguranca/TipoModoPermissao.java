package br.com.redeservico.seguranca;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_TIPO_MODO_PERMISSAO")
@NamedQuery(name = "TipoModoPermissao.findById", query = "SELECT TMP FROM TipoModoPermissao AS TMP WHERE TMP.id = :pid")
public class TipoModoPermissao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;

    public TipoModoPermissao() {
        this.id = -1;
        this.descricao = "";
    }

    public TipoModoPermissao(int id, String descricao) {
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
