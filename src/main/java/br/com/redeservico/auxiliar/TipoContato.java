//package br.com.redeservico.auxiliar;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "AUX_TIPO_CONTATO")
//@NamedQuery(name = "Tag.findById", query = "select tco from TipoContato tco where tco.id=:pid")
//public class TipoContato implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
//    private String descricao;
//
//    public TipoContato() {
//        this.id = -1;
//        this.descricao = "";
//    }
//
//    public TipoContato(int id, String descricao) {
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
