/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Cliente;
import Beans.ClienteFisico;
import Beans.Usuario;
import antlr.collections.List;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import util.Criptografia;

/**
 *
 * @author Gustavo
 */
public class DAOUsuarios extends Base {

    public Boolean AutenticaUsuario(String login, String senha) throws NoSuchAlgorithmException {
        Criptografia cripto = new Criptografia();

        String hashed = cripto.CriptografiaSenha(senha);

        Iterable<Usuario> retorno = super.Where("Senha = '" + hashed + "' AND Login = '" + login + "'", Usuario.class);
        if (retorno != null && retorno.iterator().hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    public Cliente obterClienteLogado(String senha, String login) throws NoSuchAlgorithmException {
        Criptografia cripto = new Criptografia();

        String hashed = cripto.CriptografiaSenha(senha);
        Iterable<Cliente> retorno = super.Where("Senha = '" + hashed + "' AND cpf = '" + login + "'", Cliente.class);

        return retorno.iterator().next();
    }
}
