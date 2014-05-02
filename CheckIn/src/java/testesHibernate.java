/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import util.HibernateUtility;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@RequestScoped
public class testesHibernate {

    /**
     * Creates a new instance of testesHibernate
     */
    public testesHibernate() {
    }
    
    public void Testando() {
        String i = "0";
        Session s = HibernateUtility.getSession();        
    }
}
