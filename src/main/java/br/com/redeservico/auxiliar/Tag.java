//package br.com.redeservico.auxiliar;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "AUX_TAG")
//@NamedQuery(name = "Tag.findById", query = "SELECT T FROM Tag  AS T WHERE T.id = :pid")
//public class Tag implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
//    private String descricao;
//
//    public Tag() {
//        this.id = -1;
//        this.descricao = "";
//    }
//
//    public Tag(int id, String descricao) {
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
