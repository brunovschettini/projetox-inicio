//package br.com.redeservico.edicao;
//
//import br.com.redeservico.auxiliar.Categoria1;
//import br.com.redeservico.auxiliar.Categoria2;
//import br.com.redeservico.auxiliar.Categoria3;
//import br.com.redeservico.seguranca.Usuario;
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "EDI_EDICAO")
//@NamedQuery(name = "Edicao.findById", query = "select edi from Edicao edi where edi.id=:pid")
//public class Edicao implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
//    @ManyToMany
//    private Usuario usuario;
//    @JoinColumn(name = "ID_CATEGORIA_1", referencedColumnName = "ID")
//    @ManyToMany
//    private Categoria1 categoria1;
//    @JoinColumn(name = "ID_CATEGORIA_2", referencedColumnName = "ID")
//    @ManyToMany
//    private Categoria2 categoria2;
//    @JoinColumn(name = "ID_CATEGORIA_3", referencedColumnName = "ID")
//    @ManyToMany
//    private Categoria3 categoria3;
//    @Column(name = "DS_TITULO", length = 255)
//    private String titulo;
//    @Column(name = "DS_TEXTO", length = 5000)
//    private String texto;
//    @Column(name = "DS_AUTOR", length = 5000)
//    private String autor;
//    @Column(name = "IS_CAPA")
//    private boolean capa;
//    @Column(name = "IS_ATIVO")
//    private boolean ativo;
//}
