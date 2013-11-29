//package br.com.redeservico.edicao;
//
//import br.com.redeservico.pessoa.Pessoa;
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "EDI_LUGAR")
//@NamedQuery(name = "EdicaoLugar.findById", query = "SELECT edil FROM EdicaoLugar edil WHERE edil.id=:pid")
//public class EdicaoLugar implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
//    @ManyToMany
//    private Edicao edicao;
//    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
//    @ManyToMany
//    private Pessoa pessoa;
//
//    public EdicaoLugar() {
//        this.id = -1;
//        this.edicao = new Edicao();
//        this.pessoa = new Pessoa();
//    }
//
//    public EdicaoLugar(int id, Edicao edicao, Pessoa pessoa) {
//        this.id = id;
//        this.edicao = edicao;
//        this.pessoa = pessoa;
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
//    public Edicao getEdicao() {
//        return edicao;
//    }
//
//    public void setEdicao(Edicao edicao) {
//        this.edicao = edicao;
//    }
//
//    public Pessoa getPessoa() {
//        return pessoa;
//    }
//
//    public void setPessoa(Pessoa pessoa) {
//        this.pessoa = pessoa;
//    }
//}
