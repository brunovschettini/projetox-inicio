package br.com.redeservico.seguranca.db;

import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.seguranca.UsuarioAdministrador;
import br.com.redeservico.seguranca.UsuarioCliente;
import br.com.redeservico.seguranca.UsuarioEmpresa;

public interface ControleAcessoDB {

    public Usuario validacaoUsuario(Usuario usuario);

    public UsuarioAdministrador usuarioAdministrador(Usuario usuario);

    public UsuarioEmpresa usuarioEmpresa(Usuario usuario);

    public UsuarioCliente usuarioCliente(Usuario usuario);

}
