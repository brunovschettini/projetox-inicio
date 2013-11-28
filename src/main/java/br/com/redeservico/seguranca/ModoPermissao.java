package br.com.redeservico.seguranca;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_MODO_PERMISSAO")
@NamedQuery(name = "ModoPermissao.findById", query = "SELECT MP FROM ModoPermissao AS MP WHERE MP.id = :pid")
public class ModoPermissao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
    private String descricao;
    @JoinColumn(name = "ID_TIPO_MODO_PERMISSAO", referencedColumnName = "ID", nullable = true)
    @ManyToOne
    private TipoModoPermissao tipoModoPermissao;

    public ModoPermissao() {
        this.id = -1;
        this.descricao = "";
        this.tipoModoPermissao = new TipoModoPermissao();
    }

    public ModoPermissao(int id, String descricao, TipoModoPermissao tipoModoPermissao) {
        this.id = id;
        this.descricao = descricao;
        this.tipoModoPermissao = tipoModoPermissao;
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

    public TipoModoPermissao getTipoModoPermissao() {
        return tipoModoPermissao;
    }

    public void setTipoModoPermissao(TipoModoPermissao tipoModoPermissao) {
        this.tipoModoPermissao = tipoModoPermissao;
    }
}
