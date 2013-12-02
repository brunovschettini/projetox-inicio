package br.com.redeservico.servico;

import br.com.redeservico.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SER_AVALIACAO")
@NamedQuery(name = "ServicoAvaliacao.findById", query = "SELECT SA FROM ServicoAvaliacao AS SA WHERE SA.id = :pid")
public class ServicoAvaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_SERVICO_AGENDAMENTO", nullable = false)
    @ManyToOne
    private ServicoAgendamento servicoAgendamento;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_DATA")
    private Date dtAvaliacao;
    @Column(name = "DS_OBSERVACAO", length = 500)
    private String observacao;
    @Column(name = "NR_NOTA")
    private int nota;
    @Column(name = "IS_ATIVO", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean ativo;

    public ServicoAvaliacao() {
        this.id = -1;
        this.servicoAgendamento = new ServicoAgendamento();
        this.dtAvaliacao = Data.dataHoje();
        this.observacao = "";
        this.nota = 0;
        this.ativo = true;
    }

    public ServicoAvaliacao(int id, ServicoAgendamento servicoAgendamento, Date dtAvaliacao, String observacao, int nota, boolean ativo) {
        this.id = id;
        this.servicoAgendamento = servicoAgendamento;
        this.dtAvaliacao = dtAvaliacao;
        this.observacao = observacao;
        this.nota = nota;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServicoAgendamento getServicoAgendamento() {
        return servicoAgendamento;
    }

    public void setServicoAgendamento(ServicoAgendamento servicoAgendamento) {
        this.servicoAgendamento = servicoAgendamento;
    }

    public Date getDtAvaliacao() {
        return dtAvaliacao;
    }

    public void setDtAvaliacao(Date dtAvaliacao) {
        this.dtAvaliacao = dtAvaliacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
