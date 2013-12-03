package br.com.ilines.sistema;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "HOM_HORARIO")
@NamedQueries({
    @NamedQuery(name = "Horario.pesquisaID", query = "SELECT H FROM Horario AS H WHERE H.id = :pid"),
    @NamedQuery(name = "Horario.findAll", query = "SELECT H FROM Horario AS H ORDER BY H.semana.id ASC, H.hora ASC ")
})
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_HORA", length = 5, nullable = false)
    private String hora;
    @Column(name = "NR_QUANTIDADE", nullable = false)
    private int quantidade;
    @JoinColumn(name = "ID_SEMANA", referencedColumnName = "ID")
    @ManyToOne
    private Semana semana;
    @Column(name = "ATIVO", nullable = true)
    private boolean ativo;

    public Horario() {
        id = -1;
        hora = "";
        quantidade = 0;
        semana = new Semana();
        ativo = true;
    }

    public Horario(int id, String hora, int quantidade, Semana semana, boolean ativo) {
        this.id = id;
        this.hora = hora;
        this.quantidade = quantidade;
        this.semana = semana;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
    }    

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }    
}
