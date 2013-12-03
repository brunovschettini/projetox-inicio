package br.com.ilines.auxiliar;

//package br.com.redeservico.auxiliar;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "AUX_EXCLUSIVO")
//@NamedQuery(name = "Exclusivo.findById", query = "SELECT exc FROM Exclusivo exc WHERE exc.id=:pid")
//public class Exclusivo implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
//    private String descricao;
//
//    public Exclusivo() {
//        this.id = -1;
//        this.descricao = "";
//    }
//
//    public Exclusivo(int id, String descricao) {
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
