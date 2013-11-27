package br.com.redeservico.servico;

import br.com.redeservico.financeiro.Servicos;
import br.com.redeservico.seguranca.Moderador;
import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SER_COMENTARIOS")
@NamedQuery(name = "ServicoComentario.findById", query = "SELECT SC FROM ServicoComentario AS SC WHERE SC.id = :pid")
public class ServicoComentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_SERVICOS", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Servicos servicos;
    @JoinColumn(name = "ID_USUARIO_CLIENTE", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario cliente;
    @JoinColumn(name = "ID_MODERADOR", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Moderador moderador;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_DATA")
    private Date dtComentario;
    @Column(name = "DS_OBSERVACAO", length = 500)
    private String observacao;
    @Column(name = "IS_ATIVO")
    private boolean ativo;

    public ServicoComentario() {
        this.id = -1;
        this.servicos = new Servicos();
        this.cliente = new Usuario();
        this.moderador = new Moderador();
        this.dtComentario = Data.dataHoje();
        this.observacao = "";
        this.ativo = false;
    }

    public ServicoComentario(int id, Servicos servicos, Usuario cliente, Moderador moderador, Date dtComentario, String observacao, boolean ativo) {
        this.id = id;
        this.servicos = servicos;
        this.cliente = cliente;
        this.moderador = moderador;
        this.dtComentario = dtComentario;
        this.observacao = observacao;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Moderador getModerador() {
        return moderador;
    }

    public void setModerador(Moderador moderador) {
        this.moderador = moderador;
    }

    public Date getDtComentario() {
        return dtComentario;
    }

    public void setDtComentario(Date dtComentario) {
        this.dtComentario = dtComentario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
