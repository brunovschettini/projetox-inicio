//package br.com.redeservico.auxiliar;
//
//import br.com.redeservico.seguranca.Usuario;
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "AUX_GRUPO_USUARIO")
//@NamedQuery(name = "GrupoUsuario.findById", query = "select gc from GrupoUsuario gc where gc.id=:pid")
//public class GrupoUsuario implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
//    @ManyToMany
//    private Usuario usuario;
//    @Column(name = "DS_DESCRICAO", length = 50, nullable = false)
//    private String descricao;
//    @JoinColumn(name = "ID_CATEGORIA_1", referencedColumnName = "ID")
//    @ManyToMany
//    private Categoria1 categoria1;
//    @JoinColumn(name = "ID_CATEGORIA_2", referencedColumnName = "ID")
//    @ManyToMany
//    private Categoria2 categoria2;
//    @JoinColumn(name = "ID_CATEGORIA_3", referencedColumnName = "ID")
//    @ManyToMany
//    private Categoria3 categoria3;
//    @Column(name = "IS_ATIVO")
//    private boolean ativo;
//
//}
