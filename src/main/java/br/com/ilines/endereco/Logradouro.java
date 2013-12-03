package br.com.ilines.endereco;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "END_LOGRADOURO")
@NamedQuery(name = "Logradouro.findById", query = "select logra from Logradouro logra where logra.id=:pid")
public class Logradouro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
    private String descricao;

    public Logradouro() {
        this.id = -1;
        this.descricao = "";
    }

    public Logradouro(int id, String descricao) {
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
