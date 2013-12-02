package br.com.redeservico.pessoa.db;

import br.com.redeservico.db.DB;
import br.com.redeservico.pessoa.TipoEndereco;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

public class PessoaEnderecoDAO extends DB {

    /**
     * <b>PessoaEnderecoDAO</b>
     * <p>Retorna a lista de tipos de endereço disponíveis para a pessoa e tipo informado</p>
     * @param idPessoa
     * @param idTipoPessoa
     * @return List<TipoEndereco>;
     */
    public List<TipoEndereco> listaTipoEnderecoDisponivelPessoa(int idPessoa, int idTipoPessoa) {
        String tiposString = "";
        if (idTipoPessoa == 1) {
            tiposString = " AND TE.id IN (1,2,3,4)";
        } else if(idTipoPessoa == 2) {
            tiposString = " AND TE.id IN (2,3,4)";
        }
        try {
            Query query = getEntityManager().createQuery("SELECT TE FROM TipoEndereco AS TE WHERE TE.id NOT IN ( SELECT PE.tipoEndereco.id FROM PessoaEndereco AS PE WHERE PE.pessoa.id = :pessoa )" + tiposString +" ORDER BY TE.id");
            query.setParameter("pessoa", idPessoa);
        } catch (Exception e) {
            
        }
        return new ArrayList();
    }
    
}