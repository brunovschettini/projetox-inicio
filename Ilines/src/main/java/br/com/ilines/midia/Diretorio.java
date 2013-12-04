package br.com.ilines.midia;

import br.com.ilines.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * <b>Diretorio</b> Salva os diretórios criados pelo sistema
 * @author ilines
 */
@Entity
@Table(name = "MID_DIRETORIO")
@NamedQuery(name = "Diretorio.findById", query = "SELECT DIRE FROM Diretorio AS DIRE WHERE DIRE.id =:pid")
public class Diretorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_TITULO", length = 255)
    private String titulo;
    @Column(name = "DS_LEGENDA", length = 255)
    private String legenda;
    @Column(name = "DS_CAMINHO", length = 100)
    private String caminho;
    @Column(name = "DS_DIRETORIO", length = 100)
    private String dsDiretorio;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_DATA")
    private Date data;
    @Column(name = "IS_ATIVO")
    private boolean ativo;

    public Diretorio() {
        this.id = -1;
        this.titulo = "";
        this.legenda = "";
        this.caminho = "";
        this.dsDiretorio = "";
        this.data = Data.dataHoje();
        this.ativo = false;
    }

    public Diretorio(int id, String titulo, String legenda, String caminho, String dsDiretorio, String data, boolean ativo) {
        this.id = id;
        this.titulo = titulo;
        this.legenda = legenda;
        this.caminho = caminho;
        this.dsDiretorio = dsDiretorio;
        this.data = Data.converte(data);
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDsDiretorio() {
        return dsDiretorio;
    }

    public void setDsDiretorio(String dsDiretorio) {
        this.dsDiretorio = dsDiretorio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDataString() {
        return Data.converteData(data);
    }

    public void setDataString(String data) {
        this.data = Data.converte(data);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
