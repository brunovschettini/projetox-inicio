package br.com.redeservico.endereco.db;

import br.com.redeservico.db.DB;
import br.com.redeservico.endereco.Cidade;
import br.com.redeservico.endereco.Endereco;
import br.com.redeservico.endereco.Estado;
import br.com.redeservico.endereco.Regiao;
import br.com.redeservico.endereco.Subregiao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

public class EnderecoDAO extends DB {

    private String cidadeOrder;
    private String estadoOrder;
    private String regiaoOrder;
    private String subregiaoOrder;

    public EnderecoDAO() {
        this.cidadeOrder = "ASC";
        this.estadoOrder = "ASC";
        this.regiaoOrder = "ASC";
        this.subregiaoOrder = "ASC";
    }

    public EnderecoDAO(String cidadeOrder, String estadoOrder, String regiaoOrder, String subregiaoOrder) {
        this.cidadeOrder = cidadeOrder;
        this.estadoOrder = estadoOrder;
        this.regiaoOrder = regiaoOrder;
        this.subregiaoOrder = subregiaoOrder;
    }

    public Cidade pesquisaCidadeEstado(Cidade cidade) {
        try {
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE C.cidade = :cidade AND C.estado.id = :estado ");
            query.setParameter("cidade", cidade);
            query.setParameter("estado", cidade.getEstado().getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return (Cidade) query.getSingleResult();
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Cidade> pesquisaCidadesPorEstado(Cidade cidade) {
        try {
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE C.estado.id = :estado ORDER BY C.estado.descricao ASC, C.descricao "+cidadeOrder);
            query.setParameter("estado", cidade.getEstado().getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {

        }
        return new ArrayList();
    }

    public List<Cidade> pesquisaEstadoPorDescricao(Cidade cidade) {
        try {
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE C.descricao LIKE :cidadeInicial AND C.descricao LIKE :cidadeParcial ORDER BY C.estado.descricao ASC, C.descricao ASC ");
            query.setParameter("cidadeInicial", "" + cidade.getDescricao() + "%");
            query.setParameter("cidadeParcial", "%" + cidade.getDescricao() + "%");
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {

        }
        return new ArrayList();
    }

    public Estado pesquisaEstadoPorCidade(Cidade cidade) {
        try {
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE C.id = :cidade");
            query.setParameter("cidade", cidade.getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return (Estado) query.getSingleResult();
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Cidade> pesquisaCidadesPorSubregiao(Subregiao subregiao) {
        try {
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE C.subregiao.id = :regiao ORDER BY C.estado.descricao ASC, C.descricao ASC ");
            query.setParameter("regiao", subregiao.getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Cidade> pesquisaCidadesPorRegiao(Regiao regiao) {
        try {
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE C.estado.regiao.id = :regiao ORDER BY C.estado.descricao ASC, C.descricao ASC ");
            query.setParameter("regiao", regiao.getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Endereco> pesquisaEnderecosPorCEP(Endereco endereco) {
        try {
            Query query = getEntityManager().createQuery("SELECT E FROM Endereco AS E WHERE E.cep = :cep ORDER BY C.estado.descricao ASC, C.descricao ASC ");
            query.setParameter("cep", endereco.getCep());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {

        }
        return new ArrayList();
    }

    public List<Endereco> pesquisaEnderecosPorFaixaCEP(Endereco enderecoInicial, Endereco enderecoFinal) {
        try {
            Query query = getEntityManager().createQuery("SELECT E FROM Endereco AS E WHERE BETWEEN E.cep = :cepInicial AND E.cep = :cepFinal ORDER BY C.estado.descricao ASC, C.descricao ASC ");
            query.setParameter("cepInicial", enderecoInicial.getCep());
            query.setParameter("cepFinal", enderecoFinal.getCep());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {

        }
        return new ArrayList();
    }

    public String getCidadeOrder() {
        return cidadeOrder;
    }

    public void setCidadeOrder(String cidadeOrder) {
        this.cidadeOrder = cidadeOrder;
    }

    public String getEstadoOrder() {
        return estadoOrder;
    }

    public void setEstadoOrder(String estadoOrder) {
        this.estadoOrder = estadoOrder;
    }

    public String getRegiaoOrder() {
        return regiaoOrder;
    }

    public void setRegiaoOrder(String regiaoOrder) {
        this.regiaoOrder = regiaoOrder;
    }

    public String getSubregiaoOrder() {
        return subregiaoOrder;
    }

    public void setSubregiaoOrder(String subregiaoOrder) {
        this.subregiaoOrder = subregiaoOrder;
    }

}
