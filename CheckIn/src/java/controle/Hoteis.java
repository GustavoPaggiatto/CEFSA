/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Beans.Hotel;
import Negocio.NegocioHotel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped
public class Hoteis {
    
    public ArrayList<Hotel> hoteis;
    private NegocioHotel negHotel;
    
    /**
     * Creates a new instance of Hotel
     */
    public Hoteis() {
        hoteis = new ArrayList<>();
        negHotel = new NegocioHotel();
        Iterable<Hotel> t = negHotel.ObterHoteis(Beans.Hotel.class);
        Iterator iterator = t.iterator();
        while (iterator.hasNext()) {
            this.hoteis.add((Hotel) iterator.next());
        }
    }

    public ArrayList<Hotel> getHoteis() {
        return hoteis;
    }

    public void setHoteis(ArrayList<Hotel> Hoteis) {
        this.hoteis = Hoteis;
    }

    public void redirecionaDetalhe(int id) throws IOException {            
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        s.setAttribute("idHotel", id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("detalhesHoteis.xhtml");
    }
}
