package br.com.redeservico.seguranca.dao;

import br.com.redeservico.db.DB;
import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.seguranca.UsuarioAdministrador;
import br.com.redeservico.seguranca.UsuarioCliente;
import br.com.redeservico.seguranca.UsuarioEmpresa;
import java.util.List;
import javax.persistence.Query;

public class UsuarioDAO extends DB {

    public Usuario validaUsuario(Usuario usuario) {
        try {
            Query query = getEntityManager().createQuery("SELECT USU FROM Usuario AS USU WHERE USU.login = :login AND USU.senha = :senha ");
            query.setParameter("login", usuario.getLogin());
            query.setParameter("senha", usuario.getSenha());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                return new Usuario();
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public Usuario usuarioExiste(Usuario usuario) {
        try {
            Query query = getEntityManager().createQuery("SELECT USU FROM Usuario AS USU WHERE USU.login = :login AND USU.pessoa.id = :pessoa ");
            query.setParameter("login", usuario.getLogin());
            query.setParameter("pessoa", usuario.getPessoa().getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                usuario = (Usuario) query.getSingleResult();
                return usuario;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public UsuarioAdministrador usuarioAdministradorExiste(Usuario usuario) {
        try {
            Query query = getEntityManager().createQuery("SELECT USU FROM UsuarioAdministrador AS USU WHERE USU.usuario.id = :usuario");
            query.setParameter("usuario", usuario.getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                UsuarioAdministrador usuarioAdministrador = (UsuarioAdministrador) query.getSingleResult();
                return usuarioAdministrador;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public UsuarioCliente usuarioClienteExiste(Usuario usuario) {
        try {
            Query query = getEntityManager().createQuery("SELECT USU FROM UsuarioCliente AS USU WHERE USU.usuario.id = :usuario");
            query.setParameter("usuario", usuario.getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                UsuarioCliente usuarioCliente = (UsuarioCliente) query.getSingleResult();
                return usuarioCliente;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public UsuarioEmpresa usuarioEmpresaExiste(Usuario usuario) {
        try {
            Query query = getEntityManager().createQuery("SELECT USU FROM UsuarioEmpresa AS USU WHERE USU.usuario.id = :usuario");
            query.setParameter("usuario", usuario.getId());
            List list = query.getResultList();
            if (!list.isEmpty()) {
                UsuarioEmpresa usuarioEmpresa = (UsuarioEmpresa) query.getSingleResult();
                return usuarioEmpresa;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
