package br.com.redeservico.sistema;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "SIS_TEMAS")
@NamedQuery(name = "Temas.pesquisaID", query = "SELECT TE FROM Temas AS TE WHERE TE.id = :pid")
public class Temas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 15, unique = true)
    private String descricao;
    @Column(name = "DS_IDENTIFICADOR", length = 15, unique = true)
    private String identificador;

    public Temas() {
        this.id = -1;
        this.descricao = "";
        this.identificador = "";
    }

    public Temas(int id, String descricao, String identificador) {
        this.id = id;
        this.descricao = descricao;
        this.identificador = identificador;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
