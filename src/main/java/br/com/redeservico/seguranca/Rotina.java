package br.com.redeservico.seguranca;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEG_ROTINA")
@NamedQuery(name = "Rotina.findById", query = "select rot from Rotina rot where rot.id=:pid")
public class Rotina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;     
    @Column(name = "DS_ROTINA", length = 50, nullable = false)
    private String rotina;
    @Column(name = "DS_NOME_PAGINA", length = 100, nullable = false)
    private String pagina;
    @Column(name = "DS_CLASSE", length = 100)
    private String classe;
    @Column(name = "NR_ACESSO")
    private int acessos;
    @Column(name = "IS_ATIVO")
    private boolean ativo;

    public Rotina() {
        this.id = -1;
        this.rotina = "";
        this.pagina = "";
        this.classe = "";
        this.acessos = 0;
        this.ativo = true;
    }

    public Rotina(int id, String rotina, String pagina, String classe, int acessos, boolean ativo) {
        this.id = id;
        this.rotina = rotina;
        this.pagina = pagina;
        this.classe = classe;
        this.acessos = acessos;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRotina() {
        return rotina;
    }

    public void setRotina(String rotina) {
        this.rotina = rotina;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public int getAcessos() {
        return acessos;
    }

    public void setAcessos(int acessos) {
        this.acessos = acessos;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
