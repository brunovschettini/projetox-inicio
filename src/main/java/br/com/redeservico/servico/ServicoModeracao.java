package br.com.redeservico.servico;

import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Modera os serviços agendandos para empresa
 */
@Entity
@Table(name = "SER_MODERACAO")
@NamedQuery(name = "ServicoModeracao.pesquisaID", query = "SELECT SM FROM ServicoModeracao AS SM WHERE SM.id = :pid")
public class ServicoModeracao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_USUARIO_MODERADOR", nullable = false)
    @ManyToOne
    private Usuario moderador;
    @JoinColumn(name = "ID_SERVICO_AGENDAMENTO", nullable = false)
    @ManyToOne
    private ServicoAgendamento servicoAgendamento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_MODERADACAO")
    private Date dtModeracao;
    @Column(name = "IS_MODERADO", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean moderado;
    @Column(name = "DS_OBSERVACAO", length = 255)
    private String observacao;

    public ServicoModeracao() {
        this.id = -1;
        this.moderador = new Usuario();
        this.servicoAgendamento = new ServicoAgendamento();
        this.dtModeracao = Data.dataHoje();
        this.moderado = false;
        this.observacao = "";
    }

    public ServicoModeracao(int id, Usuario moderador, ServicoAgendamento servicoAgendamento, Date dtModeracao, boolean moderado, String observacao) {
        this.id = id;
        this.moderador = moderador;
        this.servicoAgendamento = servicoAgendamento;
        this.dtModeracao = dtModeracao;
        this.moderado = moderado;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getModerador() {
        return moderador;
    }

    public void setModerador(Usuario moderador) {
        this.moderador = moderador;
    }

    public ServicoAgendamento getServicoAgendamento() {
        return servicoAgendamento;
    }

    public void setServicoAgendamento(ServicoAgendamento servicoAgendamento) {
        this.servicoAgendamento = servicoAgendamento;
    }

    public Date getDtModeracao() {
        return dtModeracao;
    }

    public void setDtModeracao(Date dtModeracao) {
        this.dtModeracao = dtModeracao;
    }

    /**
     * @see se for true, o processo é continuado, se for false o serviço agendando entra no status não aprovado
     * @return moderado
     */
    public boolean isModerado() {
        return moderado;
    }

    public void setModerado(boolean moderado) {
        this.moderado = moderado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
