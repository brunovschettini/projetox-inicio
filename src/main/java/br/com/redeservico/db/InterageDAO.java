package br.com.redeservico.db;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

public class InterageDAO extends DB {

    public void openTransaction() {
        try {
            getEntityManager().getTransaction().begin();
        } catch (Exception ex) {
            Logger.getLogger(InterageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void commit() {
        try {
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(InterageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            getEntityManager().getTransaction().rollback();
        } catch (Exception ex) {
            Logger.getLogger(InterageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insert(Object object) {
        try {
            getEntityManager().persist(object);
            getEntityManager().flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean alter(Object object) {
        Class classe = object.getClass();
        int id;
        try {
            Method metodo = classe.getMethod("getId", new Class[]{});
            id = (Integer) metodo.invoke(object, (Object[]) null);
            if (id == -1) {
                return false;
            }
            getEntityManager().merge(object);
            getEntityManager().flush();
            return true;
        } catch (IllegalAccessException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        } catch (SecurityException e) {
            return false;
        } catch (InvocationTargetException e) {
            return false;
        } catch (Exception ex) {
            Logger.getLogger(InterageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(Object object) {
        try {
            getEntityManager().remove(object);
            getEntityManager().flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Deprecated 
    public Object findId(int id, String ob) {
        Object result = null;
        try {
            Query query = getEntityManager().createNamedQuery(ob + ".findById");
            query.setParameter("pid", id);
            if (!query.getResultList().isEmpty()) {
                result = query.getSingleResult();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }

    public List findId(int id[], String ob) {
        List<Object> list = new ArrayList<Object>();
        Object object;
        for (int i = 0; i < id.length; i++) {
            object = findId(id[i], ob);
            if (object != null) {
                list.add(object);
            }
        }
        return list;
    }

    public Object findObjectByID(int id, String object) {
        Object result = null;
        try {
            Query qry = getEntityManager().createQuery("SELECT OB FROM " + object + " OB WHERE OB.id = " + id);
            if (!qry.getResultList().isEmpty()) {
                result = qry.getSingleResult();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }

    public List findObjectByID(int id[], String object) {
        return findObjectByID(id, object, "");
    }

    public List findObjectByID(int id[], String object, String field) {
        String stringCampo = "id";
        if (field.isEmpty()) {
            stringCampo = field;
        }
        String queryPesquisaString = "";
        for (int i = 0; i < id.length; i++) {
            if (i == 0) {
                queryPesquisaString = Integer.toString(id[i]);
            } else {
                queryPesquisaString += ", " + Integer.toString(id[i]);
            }
            Query query = null;
            try {
                query = getEntityManager().createQuery("SELECT OB FROM " + object + " OB WHERE OB." + stringCampo + " IN (" + queryPesquisaString + ")");
            } catch (Exception ex) {
                Logger.getLogger(InterageDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        }
        return new ArrayList();
    }

    public List findAll(String object) {
        List result = new ArrayList();
        try {
            Query qry = getEntityManager().createQuery("SELECT OB FROM " + object + " AS OB");
            if (!qry.getResultList().isEmpty()) {
                result = qry.getResultList();
            }
        } catch (Exception e) {
        }
        return result;
    }

    public List findAll(String object, boolean order) {
        try {
            Query query = getEntityManager().createNamedQuery(object + ".findAll");
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {
            return new ArrayList();
        }
        return new ArrayList();
    }

    public List findByName(String tabela, String description) {
        return findByName(tabela, description, "");
    }

    public List findByName(String object, String description, String typeResult) {
        try {
            Query query = getEntityManager().createNamedQuery(object + ".findByName");
            if (typeResult.equals("i")) {
                query.setParameter("description", "" + description.toUpperCase() + "%");
            } else if (typeResult.equals("p")) {
                query.setParameter("description", "%" + description.toUpperCase() + "%");
            } else if (typeResult.equals("all")) {
                query.setParameter("description", "%" + description.toUpperCase() + "%");
                query.setParameter("description", "" + description.toUpperCase() + "%");
            } else {
                query.setParameter("description", description.toUpperCase());
            }
            if (description.length() <= 1) {
                query.setMaxResults(1000);
            }
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {
            return new ArrayList();
        }
        return new ArrayList();
    }

    public boolean executeQuery(String textQuery) {
        try {
            int valor = getEntityManager().createNativeQuery(textQuery).executeUpdate();
            return valor > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public List nativeQuery(String textQuery) {
        return nativeQuery(textQuery, false);
    }

    public List nativeQuery(String textQuery, boolean singleResult) {
        try {
            Query query = getEntityManager().createNativeQuery(textQuery);
            if (singleResult) {
                return (List) query.getSingleResult();
            } else {
                return query.getResultList();
            }
        } catch (Exception e) {
        }
        return new ArrayList();
    }

    public List objectQuery(String textQuery) {
        return objectQuery(textQuery, false);
    }

    public List objectQuery(String textQuery, boolean singleResult) {
        try {
            Query query = getEntityManager().createQuery(textQuery);
            if (singleResult) {
                return (List) query.getSingleResult();
            } else {
                return query.getResultList();
            }
        } catch (Exception e) {
        }
        return new ArrayList();
    }

    public boolean descriptionExists(String description, String field, String object) {
        try {
            Query qry = getEntityManager().createQuery("select ob from " + object + " ob where upper(ob." + field + ") = :descricao");
            qry.setParameter("descricao", description.toUpperCase());
            if (!qry.getResultList().isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
