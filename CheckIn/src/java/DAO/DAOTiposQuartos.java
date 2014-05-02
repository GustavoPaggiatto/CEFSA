/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.TiposQuartos;
import org.hibernate.Query;
import util.HibernateUtility;

/**
 *
 * @author Gustavo
 */
public class DAOTiposQuartos {

    public TiposQuartos obterTipoQuarto(int idTipoQuarto) {
        Query query = HibernateUtility.getSession().createQuery("from TiposQuartos where ID = :idTipoQuarto");
        query.setParameter("idTipoQuarto", idTipoQuarto);
        
        return((TiposQuartos)query.list().get(0));
    }
}
