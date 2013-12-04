package br.com.ilines.edicao;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "EDI_NOTICIA")
@NamedQuery(name = "EdicaoNoticia.findById", query = "select enot from EdicaoNoticia enot where enot.id=:pid")
public class EdicaoNoticia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;
    @Column(name = "DS_URL_FONTE", length = 100)
    private String urlFonte;
    @Column(name = "IS_CAPA")
    private boolean capa;

    public EdicaoNoticia() {
        this.id = -1;
        this.edicao = new Edicao();
        this.urlFonte = "";
        this.capa = false;
    }

    public EdicaoNoticia(int id, Edicao edicao, String urlFonte, boolean capa) {
        this.id = id;
        this.edicao = edicao;
        this.urlFonte = urlFonte;
        this.capa = capa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public String getPagina() {
        return urlFonte;
    }

    public void setPagina(String pagina) {
        this.urlFonte = pagina;
    }

    public boolean isCapa() {
        return capa;
    }

    public void setCapa(boolean capa) {
        this.capa = capa;
    }
}
