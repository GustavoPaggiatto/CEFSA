/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.ClienteFisico;
import Beans.ClienteJuridico;
import java.lang.reflect.Type;

/**
 *
 * @author Gustavo
 */
public class DAOClientes extends Base {

    public Iterable<ClienteJuridico> ObterClientesJuridicos(Type t) {
        return super.GetAll(t);
    }
    
     public Iterable<ClienteFisico> ObterClientesFisicos(Type t) {
        return super.GetAll(t);
    }
}
