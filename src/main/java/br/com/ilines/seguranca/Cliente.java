package br.com.ilines.seguranca;

//package br.com.redeservico.seguranca;
//
//import br.com.redeservico.pessoa.Pessoa;
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@Entity
//@Table(name = "SEG_CLIENTE")
//@NamedQuery(name = "Cliente.findById", query = "SELECT C FROM Cliente AS C WHERE C.id = :pid")
//public class Cliente implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "DS_CODIGO", length = 100)
//    private String codigo;
//    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID", nullable = false)
//    @OneToOne
//    private Pessoa pessoa;
//    @Column(name = "DT_CADASTRO")
//    @Temporal(TemporalType.DATE)
//    private Date dtCadastro;
//    @Column(name = "IS_ATIVO", columnDefinition = "true")
//    private boolean ativo;
//
//    public Cliente() {
//        this.id = -1;
//        this.codigo = "";
//        this.pessoa = new Pessoa();
//        this.dtCadastro = new Date();
//        this.ativo = true;
//    }
//
//    public Cliente(int id, String codigo, Pessoa pessoa, Date dtCadastro, boolean ativo) {
//        this.id = id;
//        this.codigo = codigo;
//        this.pessoa = pessoa;
//        this.dtCadastro = dtCadastro;
//        this.ativo = ativo;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(String codigo) {
//        this.codigo = codigo;
//    }
//
//    public Pessoa getPessoa() {
//        return pessoa;
//    }
//
//    public void setPessoa(Pessoa pessoa) {
//        this.pessoa = pessoa;
//    }
//
//    public Date getDtCadastro() {
//        return dtCadastro;
//    }
//
//    public void setDtCadastro(Date dtCadastro) {
//        this.dtCadastro = dtCadastro;
//    }
//
//    public boolean isAtivo() {
//        return ativo;
//    }
//
//    public void setAtivo(boolean ativo) {
//        this.ativo = ativo;
//    }
//
//}
