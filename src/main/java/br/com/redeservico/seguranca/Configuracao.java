package br.com.redeservico.seguranca;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_CONFIGURACAO")
@NamedQuery(name = "Configuracao.findById", query = "SELECT C FROM Configuracao C WHERE C.id = :pid")
public class Configuracao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_PROJETO", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Projeto projeto;

    public Configuracao() {
        this.id = -1;
        this.projeto = new Projeto();
    }

    public Configuracao(int id, Projeto projeto) {
        this.id = id;
        this.projeto = projeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
