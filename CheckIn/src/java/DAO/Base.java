/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Reservas;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtility;

/**
 *
 * @author Gustavo
 */
public abstract class Base<T> {

    private Class<T> classe;
    private Session session;
    private static ArrayList<String> SessionHoteis = new  ArrayList<String>();
    private static HttpSession SessionContext;

    public Base() {
        //this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        setSession();
        SessionHoteis.add("Beans.Quartos");        
        SessionContext = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public void setSession() {
        this.session = HibernateUtility.getSession();
    }

    public T Find(int id, Type t) {
        String s = "from " + t.getTypeName() + " where ID = :id";

        if (SessionHoteis.contains(t.toString())) {
            s += " AND idHotel = " + (int) SessionContext.getAttribute("idHotel");
        }

        Query q = session.createQuery(s);
        q.setParameter("id", id);

        T obj = (T) q.list().get(0);

        session.close();

        return obj;

    }

    public Iterable<T> Where(String predicado, Type t) {
        try {
            Query q = session.createQuery("FROM " + t.getTypeName() + " WHERE " + predicado);

            Iterable<T> objs = q.list();

            return objs;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    public Iterable<T> GetAll(Type t) {
        try {

            String s = "FROM " + t.getTypeName();

            /*if (SessionHoteis.contains(t.getTypeName())) {
                s += " AND idHotel = " + (int) SessionContext.getAttribute("idHotel");
            }*/

            Query q = session.createQuery(s);

            Iterable<T> objs = q.list();

            return objs;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
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
