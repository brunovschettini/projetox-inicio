package br.com.redeservico.servico;

import br.com.redeservico.seguranca.Usuario;
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

}
