
package br.com.redeservico.seguranca;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SEG_CONFIGURACAO")
@NamedQuery(name = "SegConfiguracao.findById", query = "SELECT SG FROM SegConfiguracao AS SG WHERE SG.id = :pid")
public class SegConfiguracao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_MODO_PERMISSAO")
    @OneToOne    
    private ModoPermissao modoPermissao;
    
    public SegConfiguracao() {
        this.id = -1;
        this.modoPermissao = new ModoPermissao();
    }
    
    public SegConfiguracao(int id, ModoPermissao modoPermissao) {
        this.id = id;
        this.modoPermissao = modoPermissao;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModoPermissao getModoPermissao() {
        return modoPermissao;
    }

    public void setModoPermissao(ModoPermissao modoPermissao) {
        this.modoPermissao = modoPermissao;
    }
    
}
