/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Beans.Reservas;
import Negocio.NegocioReservas;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@RequestScoped
public class ReservasBeanInterno {

    /**
     * Creates a new instance of ReservasBeanInterno
     */
    static Logger log = Logger.getLogger(ReservasBeanInterno.class.getName());

    public ReservasBeanInterno() {
        try {
            this.ObterReservas();
        } catch (Exception ex) {
            log.error(ex);
        }
    }
    
    private ArrayList<Reservas> reservas;
    private NegocioReservas negReservas;
    
    public void ObterReservas() {
        negReservas = new NegocioReservas();
        Iterable<Reservas> iterable = negReservas.obterTodasReservas();
        String valueSession = "";
        Object o = new Object();
        
        reservas = new ArrayList<>();
        Iterator i = iterable.iterator();
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (s.getAttribute("idHotel") != null) {
            valueSession = s.getAttribute("idHotel").toString();
        }
        
        while (i.hasNext()) {
            o = i.next();
            if (valueSession != "") {
                if (((Reservas) o).getQuarto().getHotel().getID() == Integer.parseInt(valueSession)) {
                    reservas.add((Reservas) o);
                }
            } else {
                reservas.add((Reservas) o);
            }
        }
    }
    
    public ArrayList<Reservas> getReservas() {
        return reservas;
    }
    
    public void setReservas(ArrayList<Reservas> reservas) {
        this.reservas = reservas;
    }
}
