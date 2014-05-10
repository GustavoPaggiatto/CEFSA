/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Beans.ClienteFisico;
import Beans.ClienteJuridico;
import DAO.DAOClientes;
import java.lang.reflect.Type;

/**
 *
 * @author Gustavo
 */
public class NegocioClientes {

    private DAO.DAOClientes _daoClientes;

    public NegocioClientes() {
        _daoClientes = new DAOClientes();
    }

    public Iterable<ClienteJuridico> ObterClientesJuridicos(Type t) {
        return _daoClientes.ObterClientesJuridicos(t);
    }
    
    public Iterable<ClienteFisico> ObterClientesFisicos(Type t) {
        return _daoClientes.ObterClientesFisicos(t);
    }
}
