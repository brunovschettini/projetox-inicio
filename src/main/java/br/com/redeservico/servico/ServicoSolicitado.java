package br.com.redeservico.servico;

import br.com.redeservico.financeiro.Servicos;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "SER_SOLICITADO")
@NamedQuery(name = "ServicoSolicitado.pesquisaID", query = "SELECT SS FROM ServicoSolicitado AS SS WHERE SS.id = :pid")
public class ServicoSolicitado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_SERVICOS", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Servicos servicos;
    @JoinColumn(name = "ID_SERVICO_AGENDAMENTO", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ServicoAgendamento servicoAgendamento;
    @Column(name = "DS_OBSERVACAO", length = 5000)
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    public ServicoAgendamento getServicoAgendamento() {
        return servicoAgendamento;
    }

    public void setServicoAgendamento(ServicoAgendamento servicoAgendamento) {
        this.servicoAgendamento = servicoAgendamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
