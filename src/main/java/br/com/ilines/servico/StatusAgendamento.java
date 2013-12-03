package br.com.ilines.servico;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Situação do serviço agendado no processo, cada operação gera uma mudança de status
 */
@Entity
@Table(name = "SER_STATUS_AGENDAMENTO")
@NamedQuery(name = "StatusAgendamento.findById", query = "SELECT SA FROM StatusAgendamento AS SA WHERE SA.id = :pid")
public class StatusAgendamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;

    public StatusAgendamento() {
        this.id = -1;
        this.descricao = "";
    }

    public StatusAgendamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
