package br.com.ilines.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PES_FABRICANTE")
@NamedQuery(name = "Fabricante.findById", query = "select fab from Fabricante fab where fab.id=:pid")
public class Fabricante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_JURIDICA", referencedColumnName = "ID")
    @ManyToOne
    private Juridica juridica;

    public Fabricante() {
        this.id = -1;
        this.juridica = new Juridica();
    }

    public Fabricante(int id, Juridica juridica1) {
        this.id = id;
        this.juridica = juridica1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Juridica getJuridica() {
        return juridica;
    }

    public void setJuridica(Juridica juridica1) {
        this.juridica = juridica1;
    }
}
