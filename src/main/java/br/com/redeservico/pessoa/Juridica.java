package br.com.redeservico.pessoa;

import br.com.redeservico.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "PES_JURIDICA")
@NamedQuery(name = "Juridica.findById", query = "select jur from Juridica jur where jur.id=:pid")
public class Juridica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @OneToOne
    private Pessoa pessoa;
    @Column(name = "DS_FANTASIA", length = 200)
    private String fantasia;
    @Column(name = "DS_INSCRICAO_ESTADUAL", length = 30)
    private String inscricaoEstadual;
    @Column(name = "DS_INSCRICAO_MUNICIPAL", length = 30)
    private String inscricaoMunicipal;
    @Column(name = "DS_CONTATO", length = 50)
    private String contato;
    @Column(name = "DS_RESPONSAVEL", length = 50)
    private String responsavel;
    @JoinColumn(name = "ID_PORTE", referencedColumnName = "ID")
    @OneToOne
    private Porte porte;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ABERTURA")
    private Date dtAbertura;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_FECHAMENTO")
    private Date dtFechamento;

    public Juridica() {
        this.id = -1;
        this.pessoa = new Pessoa();
        this.fantasia = "";
        this.inscricaoEstadual = "";
        this.inscricaoMunicipal = "";
        this.contato = "";
        this.responsavel = "";
        this.porte = new Porte();
        setAbertura("");
        setFechamento("");
    }

    public Juridica(int id, Pessoa pessoa, String fantasia, String inscricaoEstadual, String inscricaoMunicipal, String contato, String responsavel, Porte porte, String abertura, String fechamento) {
        this.id = id;
        this.pessoa = pessoa;
        this.fantasia = fantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.contato = contato;
        this.responsavel = responsavel;
        this.porte = porte;
        setAbertura(abertura);
        setFechamento(fechamento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Date getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public Date getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(Date dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public String getAbertura() {
        if (dtAbertura != null) {
            return Data.converteData(dtAbertura);
        } else {
            return "";
        }
    }

    public void setAbertura(String abertura) {
        if (!(abertura.isEmpty())) {
            this.dtAbertura = Data.converte(abertura);
        }
    }

    public String getFechamento() {
        if (dtAbertura != null) {
            return Data.converteData(dtFechamento);
        } else {
            return "";
        }
    }

    public void setFechamento(String fechamento) {
        if (!(fechamento.isEmpty())) {
            this.dtFechamento = Data.converte(fechamento);
        }
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }
}
