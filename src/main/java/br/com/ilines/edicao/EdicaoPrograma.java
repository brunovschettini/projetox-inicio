package br.com.ilines.edicao;

import br.com.ilines.pessoa.Emissora;
import br.com.ilines.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "EDI_PROGRAMA")
@NamedQuery(name = "EdicaoPrograma.findById", query = "SELECT edip FROM EdicaoPrograma edip WHERE edip.id=:pid")
public class EdicaoPrograma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;
    @JoinColumn(name = "ID_EMISSORA", referencedColumnName = "ID")
    @ManyToOne
    private Emissora emissora;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_INICIO")
    private Date dtInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_TERMINO")
    private Date dtTermino;
    @Column(name = "DS_HORARIO", length = 5)
    private String horario;
    @Column(name = "IS_NO_AR", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean ativo;

    public EdicaoPrograma() {
        this.id = -1;
        this.edicao = new Edicao();
        this.emissora = new Emissora();
        this.dtInicio = Data.dataHoje();
        this.dtTermino = Data.dataHoje();
        this.horario = "";
        this.ativo = false;
    }

    public EdicaoPrograma(int id, Edicao edicao, Emissora emissora, String inicio, String termino, String horario, boolean ativo) {
        this.id = id;
        this.edicao = edicao;
        this.emissora = emissora;
        this.dtInicio = Data.converte(inicio);
        this.dtTermino = Data.converte(termino);
        this.horario = horario;
        this.ativo = ativo;
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

    public Emissora getEmissora() {
        return emissora;
    }

    public void setEmissora(Emissora emissora) {
        this.emissora = emissora;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getInicio() {
        return Data.converteData(dtInicio);
    }

    public void setInicio(String inicio) {
        this.dtInicio = Data.converte(inicio);
    }

    public Date getDtTermino() {
        return dtTermino;
    }

    public void setDtTermino(Date dtTermino) {
        this.dtTermino = dtTermino;
    }

    public String getTermino() {
        return Data.converteData(dtTermino);
    }

    public void setTermino(String termino) {
        this.dtTermino = Data.converte(termino);
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
