/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Reservas;
import java.lang.reflect.Type;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtility;

/**
 *
 * @author Gustavo
 */
public class DAOReservas extends Base {

    public Reservas obterReserva(int idReserva) {

        return (Reservas) Find(idReserva, this.getClass());
    }

    public void reservar(Reservas r) {
        super.save(r);
    }
}
