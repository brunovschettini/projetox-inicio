package br.com.redeservico.pessoa;

import br.com.redeservico.endereco.Endereco;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PES_PESSOA_ENDERECO")
@NamedQuery(name = "PessoaEndereco.findById", query = "select pese from PessoaEndereco pese where pese.id=:pid")
public class PessoaEndereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Endereco endereco;
    @JoinColumn(name = "ID_TIPO_ENDERECO", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private TipoEndereco tipoEndereco;
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Pessoa pessoa;
    @Column(name = "DS_NUMERO", length = 30, nullable = false)
    private String numero;
    @Column(name = "DS_COMPLEMENTO", length = 50)
    private String complemento;
    @Column(name = "IS_PRINCIPAL", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean principal;

    public PessoaEndereco() {
        this.id = -1;
        this.endereco = new Endereco();
        this.tipoEndereco = new TipoEndereco();
        this.pessoa = new Pessoa();
        this.numero = "";
        this.complemento = "";
        this.principal = principal;
    }

    public PessoaEndereco(int id, Endereco endereco, TipoEndereco tipoEndereco, Pessoa pessoa, String numero, String complemento, boolean principal) {
        this.id = id;
        this.endereco = endereco;
        this.tipoEndereco = tipoEndereco;
        this.pessoa = pessoa;
        this.numero = numero;
        this.complemento = complemento;
        this.principal = principal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
}
