/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.redeservico.seguranca.dao;

import br.com.redeservico.db.DB;
import br.com.redeservico.seguranca.Rotina;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author rtools
 */
public class RotinaDAO extends DB {
    
    public Rotina pesquisaRotinaPorPagina(String pagina) {
        Rotina rotina = new Rotina();
        try {
            Query query = getEntityManager().createQuery("SELECT ROT FROM Rotina AS ROT WHERE ROT.pagina LIKE '" + pagina + ".jsf'");
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return (Rotina) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return rotina;
    }
}
