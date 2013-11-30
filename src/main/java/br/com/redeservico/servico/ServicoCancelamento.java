package br.com.redeservico.servico;

import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SER_CANCELAMENTO")
@NamedQuery(name = "ServicoCancelamento.pesquisaID", query = "SELECT SC FROM ServicoCancelamento AS SC WHERE SC.id = :pid")
public class ServicoCancelamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    @JoinColumn(name = "ID_SERVICO_MOTIVO_CANCELAMENTO", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ServicoMotivoCancelamento motivoCancelamento;
    @JoinColumn(name = "ID_SERVICO_AGENDAMENTO", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ServicoAgendamento servicoAgendamento;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CANCELAMENTO")
    private Date dtCancelamento;

    public ServicoCancelamento() {
        this.id = -1;
        this.usuario = new Usuario();
        this.servicoAgendamento = new ServicoAgendamento();
        this.dtCancelamento = Data.dataHoje();
    }

    public ServicoCancelamento(int id, Usuario usuario, ServicoAgendamento servicoAgendamento, Date dtCancelamento) {
        this.id = id;
        this.usuario = usuario;
        this.servicoAgendamento = servicoAgendamento;
        this.dtCancelamento = dtCancelamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ServicoMotivoCancelamento getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(ServicoMotivoCancelamento motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public ServicoAgendamento getServicoAgendamento() {
        return servicoAgendamento;
    }

    public void setServicoAgendamento(ServicoAgendamento servicoAgendamento) {
        this.servicoAgendamento = servicoAgendamento;
    }

    public Date getDtCancelamento() {
        return dtCancelamento;
    }

    public void setDtCancelamento(Date dtCancelamento) {
        this.dtCancelamento = dtCancelamento;
    }

}
