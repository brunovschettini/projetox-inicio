//package br.com.redeservico.auxiliar;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "AUX_GRUPO_CATEGORIA")
//@NamedQuery(name = "GrupoCategoria.findById", query = "select GC from GrupoCategoria GC where GC.id=:pid")
//public class GrupoCategoria implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
//    private String descricao;
//
//    public GrupoCategoria() {
//        this.id = -1;
//        this.descricao = "";
//    }
//
//    public GrupoCategoria(int id, String descricao) {
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
