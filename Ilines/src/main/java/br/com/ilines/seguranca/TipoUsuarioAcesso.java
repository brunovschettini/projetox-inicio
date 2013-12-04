package br.com.ilines.seguranca;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_TIPO_USUARIO_ACESSO")
@NamedQuery(name = "TipoUsuarioAcesso.findById", query = "SELECT TUA FROM TipoUsuarioAcesso AS TUA WHERE TUA.id = :pid")
public class TipoUsuarioAcesso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false, unique = true)
    private String descricao;

    public TipoUsuarioAcesso() {
        this.id = -1;
        this.descricao = "";
    }

    public TipoUsuarioAcesso(int id, String descricao) {
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
