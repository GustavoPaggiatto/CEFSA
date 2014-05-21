/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Quartos;
import java.lang.reflect.Type;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtility;

/**
 *
 * @author Gustavo
 */
public class DAOQuartos extends Base{

    public Quartos obterQuarto(int idQuarto) {
        Quartos retorno;
        Session session = HibernateUtility.getSession();
        
        Query query = HibernateUtility.getSession().createQuery("from Quartos where ID = :idQuarto");
        query.setParameter("idQuarto", idQuarto);

        retorno = ((Quartos) query.list().get(0));
        
        session.close();
        
        return retorno;
    }
    
    public Iterable<Quartos> obterQuartosPorCodigoHotel(int idHotel, Type t)
    {
        return super.Where("hotel.ID = " + idHotel, t);
    }
}
