package br.com.redeservico.seguranca;

import br.com.redeservico.pessoa.Pessoa;
import br.com.redeservico.utilitarios.Data;
import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_USUARIO")
@NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario AS U WHERE U.id = :pid")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID", nullable = false)
    @OneToOne(fetch = FetchType.EAGER)
    private Pessoa pessoa;
    @Column(name = "DS_LOGIN", length = 15, nullable = false, unique = true)
    private String login;
    @Column(name = "DS_SENHA", length = 6, nullable = false)
    private String senha;
    @JoinColumn(name = "ID_TIPO_USUARIO_ACESSO", referencedColumnName = "ID", nullable = false)
    @OneToOne(fetch = FetchType.EAGER)
    private TipoUsuarioAcesso tipoUsuarioAcesso;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CADASTRO")
    private Date dtCadastro;
    @Column(name = "IS_ATIVO")
    private boolean ativo;

    public Usuario() {
        this.id = -1;
        this.pessoa = new Pessoa();
        this.login = "";
        this.senha = "";
        this.tipoUsuarioAcesso = new TipoUsuarioAcesso();
        this.ativo = true;
    }

    public Usuario(int id, Pessoa pessoa, String login, String senha, TipoUsuarioAcesso tipoUsuarioAcesso, boolean ativo) {
        this.id = id;
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
        this.tipoUsuarioAcesso = tipoUsuarioAcesso;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuarioAcesso getTipoUsuarioAcesso() {
        return tipoUsuarioAcesso;
    }

    public void setTipoUsuarioAcesso(TipoUsuarioAcesso tipoUsuarioAcesso) {
        this.tipoUsuarioAcesso = tipoUsuarioAcesso;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getCadastro() {
        return Data.converteData(dtCadastro);
    }

    public void setCadastro(String cadastro) {
        this.dtCadastro = Data.converte(cadastro);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
