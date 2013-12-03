package br.com.ilines.pessoa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PES_EMISSORA")
@NamedQuery(name = "Emissora.findById", query = "SELECT emi FROM Emissora emi WHERE emi.id=:pid")
public class Emissora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_JURIDICA", referencedColumnName = "ID")
    @OneToOne
    private Juridica juridica;

    public Emissora() {
        this.id = -1;
        this.juridica = new Juridica();
    }

    public Emissora(int id, Juridica juridica) {
        this.id = id;
        this.juridica = juridica;
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

    public void setJuridica(Juridica juridica) {
        this.juridica = juridica;
    }
}
