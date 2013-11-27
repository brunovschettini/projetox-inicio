package br.com.redeservico.servico;

import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.sistema.Horario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SER_AGENDAMENTO")
@NamedQuery(name = "ServicoAgendamento.findById", query = "SELECT ASE FROM ServicoAgendamento AS ASE WHERE ASE.id = :pid")
public class ServicoAgendamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_HORARIO", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Horario horario;
    @JoinColumn(name = "ID_USUARIO_CLIENTE", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario cliente;
    @JoinColumn(name = "ID_USUARIO_EMPRESA", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario empresa;
    @JoinColumn(name = "ID_STATUS_AGENDAMENTO", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private StatusAgendamento statusAgendamento;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_AGENDAMENTO")
    private Date dtAgendamento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_VISITA")
    private Date dtVisita;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ATENDIMENTO")
    private Date dtAtendimento;
    @Column(name = "DS_OBSERVACAO_CLIENTE", length = 5000)
    private String observacaoCliente;
    @Column(name = "DS_OBSERVACAO_SERVICO", length = 5000)
    private String observacaoServico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Usuario empresa) {
        this.empresa = empresa;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public Date getDtAgendamento() {
        return dtAgendamento;
    }

    public void setDtAgendamento(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public Date getDtVisita() {
        return dtVisita;
    }

    public void setDtVisita(Date dtVisita) {
        this.dtVisita = dtVisita;
    }

    public Date getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(Date dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

    public String getObservacaoCliente() {
        return observacaoCliente;
    }

    public void setObservacaoCliente(String observacaoCliente) {
        this.observacaoCliente = observacaoCliente;
    }

    public String getObservacaoServico() {
        return observacaoServico;
    }

    public void setObservacaoServico(String observacaoServico) {
        this.observacaoServico = observacaoServico;
    }

}
