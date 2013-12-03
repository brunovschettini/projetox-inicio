package br.com.ilines.pessoa.dao;

import br.com.ilines.dao.DB;
import br.com.ilines.pessoa.Fisica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;


public class PessoaDAO extends DB {
    
    public List<Fisica> listaFisica() {
        Query query = getEntityManager().createQuery("SELECT F FROM Fisica AS F ORDER BY F.pessoa.nome ASC LIMIT 1000");
        List list = query.getResultList();
        if (!list.isEmpty()) {
            return list;
        }   
        return new ArrayList();        
    }
    
    public List<Fisica> pesquisaFisicaPorNome(Fisica fisica) {
        Query query = getEntityManager().createQuery("SELECT F FROM Fisica AS F ORDER BY F.pessoa.nome ASC LIMIT 1000");
        List list = query.getResultList();
        if (!list.isEmpty()) {
            return list;
        }   
        return new ArrayList();        
    }
    
    public List<Fisica> pesquisaFisicaPorDocumento(Fisica fisica) {
        Query query = getEntityManager().createQuery("SELECT F FROM Fisica AS F ORDER BY F.pessoa.nome ASC LIMIT 1000");
        List list = query.getResultList();
        if (!list.isEmpty()) {
            return list;
        }   
        return new ArrayList();        
    }
    
}
