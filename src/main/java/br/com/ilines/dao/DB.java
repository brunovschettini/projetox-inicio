package br.com.ilines.dao;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SessionScoped
public class DB {

    private EntityManager em;

    public EntityManager getEntityManager() {
        if (em == null) {
            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("RedeServico");
//                Map properties = new HashMap();
//                properties.put(TopLinkProperties.CACHE_TYPE_DEFAULT, CacheType.Full);
//                properties.put(TopLinkProperties.JDBC_USER, "postgres");
//                properties.put(TopLinkProperties.TRANSACTION_TYPE, "RESOURCE_LOCAL");
//                properties.put(TopLinkProperties.JDBC_DRIVER, "org.postgresql.Driver");
//                properties.put(TopLinkProperties.JDBC_PASSWORD, "989899");
//                properties.put(TopLinkProperties.JDBC_URL, "jdbc:postgresql://localhost:5432/RedeServico");
                //properties.put(EntityManagerFactoryProvider.DDL_GENERATION, EntityManagerFactoryProvider.CREATE_ONLY);
                em = emf.createEntityManager();
            } catch (Exception e) {
                return null;
            }
        }
        return em;
    }
}
