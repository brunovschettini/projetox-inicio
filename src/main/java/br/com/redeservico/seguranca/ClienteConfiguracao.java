//package br.com.redeservico.seguranca;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "SEG_CLIENTE_CONFIGURACAO")
//@NamedQuery(name = "ClienteConfiguracao.findById", query = "SELECT CC FROM ClienteConfiguracao CC WHERE CC.id = :pid")
//public class ClienteConfiguracao implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID", nullable = false)
//    @OneToMany
//    private Cliente cliente;
//
//    public ClienteConfiguracao() {
//        this.id = -1;
//        this.cliente = new Cliente();
//    }
//
//    public ClienteConfiguracao(int id, Cliente cliente) {
//        this.id = id;
//        this.cliente = cliente;
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
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//}
