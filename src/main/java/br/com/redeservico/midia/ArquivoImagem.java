package br.com.redeservico.midia;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MID_ARQUIVO_IMAGEM")
@NamedQuery(name = "ArquivoImagem.findById", query = "SELECT arqi FROM ArquivoImagem arqi WHERE arqi.id=:pid")
public class ArquivoImagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID", referencedColumnName = "ID_DIRETORIO_ARQUIVO")
    @ManyToOne
    private DiretorioArquivo diretorioArquivo;
    @JoinColumn(name = "ID", referencedColumnName = "ID_TIPO_IMAGEM")
    @ManyToOne
    private TipoImagem tipoImagem;
    @Column(name = "NR_LARGURA", length = 3)
    private String largura;
    @Column(name = "NR_ALTURA", length = 3)
    private String altura;

    public ArquivoImagem() {
        this.id = -1;
        this.diretorioArquivo = new DiretorioArquivo();
        this.tipoImagem = new TipoImagem();
        this.largura = "";
        this.altura = "";
    }

    public ArquivoImagem(int id, DiretorioArquivo diretorioArquivo, TipoImagem tipoImagem, String largura, String altura) {
        this.id = id;
        this.diretorioArquivo = diretorioArquivo;
        this.tipoImagem = tipoImagem;
        this.largura = largura;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiretorioArquivo getDiretorioArquivo() {
        return diretorioArquivo;
    }

    public void setDiretorioArquivo(DiretorioArquivo diretorioArquivo) {
        this.diretorioArquivo = diretorioArquivo;
    }

    public TipoImagem getTipoImagem() {
        return tipoImagem;
    }

    public void setTipoImagem(TipoImagem tipoImagem) {
        this.tipoImagem = tipoImagem;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }
}
