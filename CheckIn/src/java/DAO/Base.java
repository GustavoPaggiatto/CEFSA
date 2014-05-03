/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import util.HibernateUtility;

/**
 *
 * @author Gustavo
 */
public abstract class Base<T> {

    private Class classe;
    private Session session;
    //protected Session session;

    public Base() {
//        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        setSession();
    }

    public void setSession() {
        this.session = HibernateUtility.getSession();
    }

    public void save(T t) {
        this.session.beginTransaction();
        this.session.save(t);
        this.session.getTransaction().commit();
        this.session.close();
    }

    public void delete(T t) {
        this.session.beginTransaction();
        this.session.delete(t);
        this.session.getTransaction().commit();
        this.session.close();
    }

    public void alter(T t) {
        this.session.beginTransaction();
        this.session.update(t);
        this.session.getTransaction().commit();
        this.session.close();
    }    
}
