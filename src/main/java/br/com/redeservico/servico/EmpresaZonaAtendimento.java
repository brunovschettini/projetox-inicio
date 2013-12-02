package br.com.redeservico.servico;

import br.com.redeservico.endereco.Cidade;
import br.com.redeservico.endereco.Zona;
import br.com.redeservico.financeiro.Servicos;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Especifica a zona de atendimento da empresa
  */
@Entity
@Table(name = "SER_EMPRESA_ZONA_ATENDIMENTO")
@NamedQuery(name = "EmpresaZonaAtendimento.findById", query = "SELECT EZA FROM EmpresaZonaAtendimento AS EZA WHERE EZA.id = :pid")
public class EmpresaZonaAtendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_SERVICO", nullable = false)
    @ManyToOne
    private Servicos servicos;
    @JoinColumn(name = "ID_CIDADE", nullable = false)
    @ManyToOne
    private Cidade cidade;
    @JoinColumn(name = "ID_ZONA", nullable = false)
    @ManyToOne
    private Zona zona;

    public EmpresaZonaAtendimento() {
        this.id = -1;
        this.servicos = new Servicos();
        this.cidade = new Cidade();
        this.zona = new Zona();
    }

    public EmpresaZonaAtendimento(int id, Servicos servicos, Cidade cidade, Zona zona) {
        this.id = id;
        this.servicos = servicos;
        this.cidade = cidade;
        this.zona = zona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return servicos
     * @see
     */
    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    /**
     * @return zona
     * <i>Ex.</i> <b>Zona sul</b>, <b>região da lapa</b>
     */
    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

}
