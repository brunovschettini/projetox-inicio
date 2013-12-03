package br.com.ilines.financeiro;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "FIN_SERVICOS_EMPRESA")
@NamedQuery(name = "ServicosEmpresa.pesquisaID", query = "SELECT SE FROM ServicosEmpresa AS SE WHERE SE.id = :pid")
public class ServicosEmpresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_SERVICO", nullable = false)
    @ManyToOne
    private Servicos servicos;

}
