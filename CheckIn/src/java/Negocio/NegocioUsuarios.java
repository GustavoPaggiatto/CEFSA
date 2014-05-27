/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Beans.Cliente;
import Beans.Usuario;
import DAO.DAOUsuarios;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Gustavo
 */
public class NegocioUsuarios {

    private DAOUsuarios _daoUsuarios;

    public NegocioUsuarios() {
        _daoUsuarios = new DAOUsuarios();
    }

    public Boolean AutenticaUsuario(String login, String senha) throws NoSuchAlgorithmException {
        return _daoUsuarios.AutenticaUsuario(login, senha);
    }

    public Cliente obterClienteLogado(String senha, String login) throws NoSuchAlgorithmException {
        Cliente c  = new Cliente();
        c = _daoUsuarios.obterClienteLogado(senha,login);
        return c;
    }
    
    public void InsereUsuario(Usuario u)
    {
        _daoUsuarios.save(u);
    }
}
