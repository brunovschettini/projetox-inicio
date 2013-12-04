package br.com.ilines.midia;

import br.com.ilines.utilitarios.Data;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * <b>DiretorioArquivo</b> Salva o arquivo dentro do diretório (br.com.redeservico.Diretorio.java)
 * @author ilines
 */
@Entity
@Table(name = "MID_DIRETORIO_ARQUIVO")
@NamedQuery(name = "DiretorioArquivo.findById", query = "SELECT darq FROM DiretorioArquivo darq WHERE darq.id=:pid")
public class DiretorioArquivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_TITULO", length = 255)
    private String titulo;
    @Column(name = "DS_LEGENDA", length = 255)
    private String legenda;
    @JoinColumn(name = "ID_DIRETORIO", referencedColumnName = "ID")
    @ManyToOne
    private Diretorio diretorio;
    @Column(name = "DS_ARQUIVO_NOME", length = 100)
    private String arquivoNome;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_DATA")
    private Date data;
    @Column(name = "IS_ATIVO")
    private boolean ativo;

    public DiretorioArquivo() {
        this.id = -1;
        this.titulo = "";
        this.legenda = "";
        this.diretorio = new Diretorio();
        this.arquivoNome = "";
        this.data = Data.dataHoje();
        this.ativo = true;
    }

    public DiretorioArquivo(int id, String titulo, String legenda, Diretorio diretorio, String arquivoNome, String data, boolean ativo) {
        this.id = id;
        this.titulo = titulo;
        this.legenda = legenda;
        this.diretorio = diretorio;
        this.arquivoNome = arquivoNome;
        this.data = Data.converte(data);
        this.ativo = ativo;
    }

    public String getDataString() {
        return Data.converteData(getData());
    }

    public void setDataString(String data) {
        this.data = Data.converte(data);
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

    public Diretorio getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(Diretorio diretorio) {
        this.diretorio = diretorio;
    }

    public String getArquivoNome() {
        return arquivoNome;
    }

    public void setArquivoNome(String arquivoNome) {
        this.arquivoNome = arquivoNome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
