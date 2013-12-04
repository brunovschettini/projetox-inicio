package br.com.ilines.endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "END_ENDERECO")
@NamedQuery(name = "Endereco.findById", query = "select e from Endereco e where e.id=:pid")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Cidade cidade;
    @Column(name = "DS_BAIRRO", length = 100)
    private String bairro;
    @JoinColumn(name = "ID_LOGRADOURO", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Logradouro logradouro;
    @Column(name = "DS_DESCRICAO_ENDERECO", length = 150)
    private String descricaoEndereco;
    @Column(name = "DS_CEP", length = 9)
    private String cep;
    @Column(name = "DS_FAIXA", length = 100)
    private String faixa;
    @Column(name = "DS_COMPLEMENTO", length = 100)
    private String complemento;

    public Endereco() {
        this.id = -1;
        this.cidade = new Cidade();
        this.bairro = "";
        this.logradouro = new Logradouro();
        this.descricaoEndereco = "";
        this.cep = "";
        this.faixa = "";
        this.complemento = "";
    }

    public Endereco(int id, Cidade cidade, String bairro, Logradouro logradouro, String descricaoEndereco, String cep, String faixa, String complemento) {
        this.id = id;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.descricaoEndereco = descricaoEndereco;
        this.cep = cep;
        this.faixa = faixa;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public String getDescricaoEndereco() {
        return descricaoEndereco;
    }

    public void setDescricaoEndereco(String descricaoEndereco) {
        this.descricaoEndereco = descricaoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
