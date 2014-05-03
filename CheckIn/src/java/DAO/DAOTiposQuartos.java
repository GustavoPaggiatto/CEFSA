/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.TiposQuartos;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtility;

/**
 *
 * @author Gustavo
 */
public class DAOTiposQuartos extends Base {

    public TiposQuartos obterTipoQuarto(int idTipoQuarto) {
        TiposQuartos retorno;
        Session session = HibernateUtility.getSession();

        Query query = session.createQuery("from TiposQuartos where ID = :idTipoQuarto");
        query.setParameter("idTipoQuarto", idTipoQuarto);

        retorno = ((TiposQuartos) query.list().get(0));

        session.close();

        return retorno;
    }
    
    public void insertTiposQuartos(TiposQuartos tiposQuartos){
        super.setSession();
        super.save(tiposQuartos);
    }
}
