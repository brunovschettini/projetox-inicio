package br.com.ilines.pessoa;

import br.com.ilines.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "PES_PESSOA")
@NamedQuery(name = "Pessoa.findById", query = "SELECT PES FROM Pessoa AS PES WHERE PES.id = :pid")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_NOME", length = 150)
    private String nome;
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", referencedColumnName = "ID", nullable = false)
    @OneToOne
    private TipoDocumento tipoDocumento;
    @Column(name = "DS_OBS", length = 500)
    private String obs;
    @Column(name = "DS_SITE", length = 50)
    private String site;
    @Column(name = "DS_EMAIL", length = 50)
    private String email;
    @Column(name = "DS_DOCUMENTO", length = 30)
    private String documento;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CRIACAO")
    private Date dtCriacao;

    public Pessoa() {
        this.id = -1;
        this.nome = "";
        this.tipoDocumento = new TipoDocumento();
        this.obs = "";
        this.site = "";
        this.email = "";
        this.documento = "";
    }

    public Pessoa(int id, String nome, TipoDocumento tipoDocumento, String obs, String site, String criacao, String email, String documento) {
        this.id = id;
        this.nome = nome;
        this.tipoDocumento = tipoDocumento;
        this.obs = obs;
        this.site = site;
        setCriacao(criacao);
        this.email = email;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public String getCriacao() {
        return Data.converteData(dtCriacao);
    }

    public void setCriacao(String criacao) {
        this.dtCriacao = Data.converte(criacao);
    }
}
