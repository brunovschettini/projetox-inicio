package br.com.ilines.edicao;

import br.com.ilines.pessoa.Pessoa;
import br.com.ilines.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "EDI_AGENDA")
@NamedQuery(name = "EdicaoAgenda.findById", query = "SELECT EDIA FROM EdicaoAgenda AS EDIA WHERE EDIA.id = :pid")
public class EdicaoAgenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
    @ManyToOne
    private Edicao edicao;
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @ManyToOne
    private Pessoa pessoa;
    @Column(name = "DS_CONTATO")
    private String contato;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_INICIO")
    private Date dtInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_TERMINO")
    private Date dtTermino;
    @Column(name = "DS_HORA_INICIO", length = 5)
    private String horaInicio;
    @Column(name = "DS_HORA_TERMINO", length = 5)
    private String horaTermino;
    @Column(name = "IS_COBERTURA", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean cobertura;
    @Column(name = "IS_PREBALADA", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean prebalada;

    public EdicaoAgenda() {
        this.id = -1;
        this.edicao = new Edicao();
        this.pessoa = new Pessoa();
        this.contato = "";
        this.dtInicio = Data.dataHoje();
        this.dtTermino = Data.dataHoje();
        this.horaInicio = "";
        this.horaTermino = "";
        this.cobertura = false;
        this.prebalada = false;
    }

    public EdicaoAgenda(int id, Edicao edicao, Pessoa pessoa, String contato, String dataInicio, String dataTermino, String horaInicio, String horaTermino, boolean cobertura, boolean prebalada) {
        this.id = id;
        this.edicao = edicao;
        this.pessoa = pessoa;
        this.contato = contato;
        this.dtInicio = Data.converte(dataInicio);
        this.dtTermino = Data.converte(dataTermino);
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.cobertura = cobertura;
        this.prebalada = prebalada;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getDataInicio() {
        return Data.converteData(dtInicio);
    }

    public void setDataInicio(String dataInicio) {
        this.dtTermino = Data.converte(dataInicio);
    }

    public Date getDtTermino() {
        return dtTermino;
    }

    public void setDtTermino(Date dtTermino) {
        this.dtTermino = dtTermino;
    }

    public String getDataTermino() {
        return Data.converteData(dtTermino);
    }

    public void setDataTermino(String dataTermino) {
        this.dtTermino = Data.converte(dataTermino);
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public boolean isCobertura() {
        return cobertura;
    }

    public void setCobertura(boolean cobertura) {
        this.cobertura = cobertura;
    }

    public boolean isPrebalada() {
        return prebalada;
    }

    public void setPrebalada(boolean prebalada) {
        this.prebalada = prebalada;
    }
}
