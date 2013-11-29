//package br.com.redeservico.auxiliar;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "AUX_TIPO_INTEGRANTE")
//@NamedQuery(name = "TipoIntegrante.findById", query = "select eti from TipoIntegrante eti where eti.id=:pid")
//public class TipoIntegrante implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
//    private String descricao;
//
//    public TipoIntegrante() {
//        this.id = -1;
//        this.descricao = "";
//    }
//
//    public TipoIntegrante(int id, String descricao) {
//        this.id = id;
//        this.descricao = descricao;
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
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//}
