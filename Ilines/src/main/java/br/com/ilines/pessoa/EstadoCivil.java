package br.com.ilines.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PES_ESTADO_CIVIL")
@NamedQuery(name = "EstadoCivil.findById", query = "select ecs from EstadoCivil ecs where ecs.id=:pid")
public class EstadoCivil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
    private String descricao;

    public EstadoCivil() {
        this.id = -1;
        this.descricao = "";
    }

    public EstadoCivil(int id, String descricao) {
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
