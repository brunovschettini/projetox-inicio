package br.com.redeservico.servico;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SER_MOTIVO_CANCELAMENTO")
@NamedQuery(name = "ServicoMotivoCancelamento.findById", query = "SELECT SMC FROM ServicoMotivoCancelamento AS SMC WHERE SMC.id = :pid")
public class ServicoMotivoCancelamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;

    public ServicoMotivoCancelamento() {
        this.id = -1;
        this.descricao = "";
    }

    public ServicoMotivoCancelamento(int id, String descricao) {
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
