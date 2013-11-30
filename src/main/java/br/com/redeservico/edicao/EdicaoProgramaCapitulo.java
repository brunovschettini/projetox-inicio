package br.com.redeservico.edicao;

import br.com.redeservico.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "EDI_PROGRAMA_CAPITULO")
@NamedQuery(name = "EdicaoProgramaCapitulo.findById", query = "SELECT edipc FROM EdicaoProgramaCapitulo edipc WHERE edipc.id=:pid")
public class EdicaoProgramaCapitulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;
    @JoinColumn(name = "ID_PROGRAMA", referencedColumnName = "ID")
    @ManyToOne
    private EdicaoPrograma edicaoPrograma;
    @Column(name = "DS_CHAMADO")
    private String chamado;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CAPITULO")
    private Date dtCapitulo;

    public EdicaoProgramaCapitulo() {
        this.id = -1;
        this.edicao = new Edicao();
        this.edicaoPrograma = new EdicaoPrograma();
        this.chamado = "";
        this.dtCapitulo = Data.dataHoje();
    }
    
    public EdicaoProgramaCapitulo(int id, Edicao edicao, EdicaoPrograma edicaoPrograma, String chamado, String dataCapitulo) {
        this.id = id;
        this.edicao = edicao;
        this.edicaoPrograma = edicaoPrograma;
        this.chamado = chamado;
        this.dtCapitulo = Data.converte(dataCapitulo);
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

    public EdicaoPrograma getEdicaoPrograma() {
        return edicaoPrograma;
    }

    public void setEdicaoPrograma(EdicaoPrograma edicaoPrograma) {
        this.edicaoPrograma = edicaoPrograma;
    }

    public String getChamado() {
        return chamado;
    }

    public void setChamado(String chamado) {
        this.chamado = chamado;
    }

    public Date getDtCapitulo() {
        return dtCapitulo;
    }

    public void setDtCapitulo(Date dtCapitulo) {
        this.dtCapitulo = dtCapitulo;
    }

    public String getDataCapitulo() {
        return Data.converteData(dtCapitulo);
    }

    public void setDataCapitulo(String dataCapitulo) {
        this.dtCapitulo = Data.converte(dataCapitulo);
    }

}
