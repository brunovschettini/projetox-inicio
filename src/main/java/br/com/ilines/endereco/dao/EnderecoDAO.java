package br.com.ilines.endereco.dao;

import br.com.ilines.dao.DB;
import br.com.ilines.endereco.Cidade;
import br.com.ilines.endereco.Endereco;
import br.com.ilines.endereco.Estado;
import br.com.ilines.endereco.Logradouro;
import br.com.ilines.endereco.Regiao;
import br.com.ilines.endereco.Subregiao;
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
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE C.id = :cidade AND C.estado.id = :estado ");
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

    public Cidade pesquisaCidadeEstadoPorDescricao(String descricaoCidade, int idEstado) {
        try {
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE UPPER(C.descricao) = :descricaoCidade AND C.estado.id = :estado ");
            query.setParameter("descricaoCidade", descricaoCidade.toUpperCase());
            query.setParameter("estado", idEstado);
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return (Cidade) query.getSingleResult();
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Logradouro pesquisaLogradouroPorDescricao(String descricaoLogradouro) {
        try {
            Query query = getEntityManager().createQuery("SELECT L FROM Logradouro AS L WHERE UPPER(L.descricao) = :descricaoLogradouro ");
            query.setParameter("descricaoLogradouro", descricaoLogradouro.toUpperCase());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return (Logradouro) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Cidade> pesquisaCidadesPorEstado(int idEstado) {
        try {
            Query query = getEntityManager().createQuery("SELECT C FROM Cidade AS C WHERE C.estado.id = :estado ORDER BY C.estado.descricao ASC, C.descricao " + cidadeOrder);
            query.setParameter("estado", idEstado);
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

    public Estado pesquisaEstadoPorDescricao(String descricaoEstado) {
        try {
            Query query = getEntityManager().createQuery("SELECT E FROM Estado AS E WHERE UPPER(E.descricao) = :descricaoEstado OR UPPER(E.sigla) = :descricaoUF");
            query.setParameter("descricaoEstado", descricaoEstado.toUpperCase());
            query.setParameter("descricaoUF", descricaoEstado.toUpperCase());
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

    public List<Endereco> pesquisaEnderecosPorCEP(String cep) {
        try {
            Query query = getEntityManager().createQuery("SELECT E FROM Endereco AS E WHERE E.cep = :cep ");
            query.setParameter("cep", cep);
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

    public Endereco enderecoExiste(Endereco endereco) {
        try {
            Query query = getEntityManager().createQuery("SELECT E FROM Endereco AS E WHERE E.cep = :cep AND E.cidade.id = :cidade AND E.logradouro.id = :logradouro AND UPPER(E.descricaoEndereco) = :descricaoEndereco AND UPPER(E.bairro) = :bairro ");
            query.setParameter("cep", endereco.getCep());
            query.setParameter("cidade", endereco.getCidade().getId());
            query.setParameter("logradouro", endereco.getLogradouro().getId());
            query.setParameter("descricaoEndereco", endereco.getDescricaoEndereco().toUpperCase());
            query.setParameter("bairro", endereco.getBairro().toUpperCase());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return (Endereco) query.getSingleResult();
            }
        } catch (Exception e) {}
        return null;
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
