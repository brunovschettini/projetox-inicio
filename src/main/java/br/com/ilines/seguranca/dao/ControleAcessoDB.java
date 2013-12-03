package br.com.ilines.seguranca.dao;

import br.com.ilines.seguranca.Usuario;
import br.com.ilines.seguranca.UsuarioAdministrador;
import br.com.ilines.seguranca.UsuarioCliente;
import br.com.ilines.seguranca.UsuarioEmpresa;

public interface ControleAcessoDB {

    public Usuario validacaoUsuario(Usuario usuario);

    public UsuarioAdministrador usuarioAdministrador(Usuario usuario);

    public UsuarioEmpresa usuarioEmpresa(Usuario usuario);

    public UsuarioCliente usuarioCliente(Usuario usuario);

}
