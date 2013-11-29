package br.com.redeservico.midia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * <b>TipoImagem</b> Define os tipos de imagem
 *
 * @author ilines
 */
@Entity
@Table(name = "MID_TIPO_IMAGEM")
@NamedQuery(name = "TipoImagem.findById", query = "SELECT mti FROM TipoImagem mti WHERE mti.id=:pid")
public class TipoImagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DS_DESCRICAO", length = 50, unique = true)
    private String descricao;
    @Column(name = "NR_LARGURA", length = 3)
    private String largura;
    @Column(name = "NR_ALTURA", length = 3)
    private String altura;
    @Column(name = "NR_QUALIDADE", length = 3)
    private String qualidade;
    @Column(name = "NR_PERMISSAO", length = 50)
    private String permissao;

    public TipoImagem() {
        this.id = -1;
        this.descricao = "";
        this.largura = "";
        this.altura = "";
        this.qualidade = "";
        this.permissao = "";
    }

    public TipoImagem(int id, String descricao, String largura, String altura, String qualidade, String permissao) {
        this.id = id;
        this.descricao = descricao;
        this.largura = largura;
        this.altura = altura;
        this.qualidade = qualidade;
        this.permissao = permissao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Nome da imagem
     *
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Largura da imagem em pixels, centimetros ou percentua, conforme
     * tratamento dado no projeto;
     *
     * @return largura
     */
    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    /**
     * Altura da imagem em pixels, centimetros ou percentua, conforme tratamento
     * dado no projeto;
     *
     * @return altura
     */
    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    /**
     * Qualidade da imagem em percentual de 0 a 100
     *
     * @return altura
     */
    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    /**
     * Permissão da imagem, visibilidade
     *
     * @return altura
     */
    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
