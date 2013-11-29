//package br.com.redeservico.edicao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "EDI_PAGINA")
//@NamedQuery(name = "EdicaoPagina.findById", query = "select pag from EdicaoPagina pag where pag.id=:pid")
//public class EdicaoPagina implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
//    @ManyToMany
//    private Edicao edicao;
//    @Column(name = "DS_PAGINA", length = 100, unique = true)
//    private String pagina;
//
//    public EdicaoPagina() {
//        this.id = -1;
//        this.edicao = new Edicao();
//        this.pagina = "";
//    }
//
//    public EdicaoPagina(int id, Edicao edicao, String pagina) {
//        this.id = id;
//        this.edicao = edicao;
//        this.pagina = pagina;
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
//    public String getPagina() {
//        return pagina;
//    }
//
//    public void setPagina(String pagina) {
//        this.pagina = pagina;
//    }
//}
