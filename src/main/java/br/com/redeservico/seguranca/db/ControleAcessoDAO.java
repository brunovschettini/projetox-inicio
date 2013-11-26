//
//package br.com.redeservico.seguranca.db;
//
//import br.com.redeservico.db.DB;
//import br.com.redeservico.seguranca.Usuario;
//import br.com.redeservico.seguranca.UsuarioAdministrador;
//import br.com.redeservico.seguranca.UsuarioCliente;
//import br.com.redeservico.seguranca.UsuarioEmpresa;
//import java.util.List;
//import javax.persistence.Query;
//
//public class ControleAcessoDAO extends DB implements ControleAcessoDB {
//    
//    @Override
//    public Usuario validacaoUsuario(Usuario usuario){
//        try {
//            Query query = getEntityManager().createQuery("SELECT U FROM Usuario AS U WHERE U.login = :login AND U.senha = :senha AND U.ativo = true");
//            query.setParameter("login", usuario.getId());
//            query.setParameter("senha", usuario.getSenha());
//            List list = query.getResultList();
//            if(!list.isEmpty()){
//                return (Usuario) query.getSingleResult();
//            }
//        } catch (Exception e) {
//            
//        }        
//        return null;
//        
//    }
//
//    @Override
//    public UsuarioAdministrador usuarioAdministrador(Usuario usuario) {
//        try {
//            Query query = getEntityManager().createQuery("SELECT UA FROM UsuarioAdministrador AS UA WHERE UA.usuario.id = :id");
//            query.setParameter("id", usuario.getId());
//            List list = query.getResultList();
//            if(!list.isEmpty()){
//                return (UsuarioAdministrador) query.getSingleResult();
//            }
//        } catch (Exception e) {
//            
//        }
//        return null;
//        
//    }
//
//    @Override
//    public UsuarioEmpresa usuarioEmpresa(Usuario usuario) {
//        try {
//            Query query = getEntityManager().createQuery("SELECT UE FROM UsuarioEmpresa AS UE WHERE UE.usuario.id = :id");
//            query.setParameter("id", usuario.getId());
//            List list = query.getResultList();
//            if(!list.isEmpty()){
//                return (UsuarioEmpresa) query.getSingleResult();
//            }
//        } catch (Exception e) {
//            
//        }
//        return null;
//        
//    }
//
//    @Override
//    public UsuarioCliente usuarioCliente(Usuario usuario){
//        try {
//            Query query = getEntityManager().createQuery("SELECT UC FROM UsuarioCliente AS UC WHERE UC.usuario.id = :id");
//            query.setParameter("id", usuario.getId());
//            List list = query.getResultList();
//            if(!list.isEmpty()){
//                return (UsuarioCliente) query.getSingleResult();
//            }
//        } catch (Exception e) {
//            
//        }
//        return null;
//        
//    }
//    
//}
