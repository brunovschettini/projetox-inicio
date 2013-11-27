package br.com.redeservico.financeiro;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "FIN_SERVICOS")
@NamedQuery(name = "Servicos.findById", query = "SELECT S FROM Servicos AS S WHERE S.id = :pid")
public class Servicos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_SERVICO", nullable = false)
    private String descricao;
    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "true")
    private boolean ativo;
    
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
