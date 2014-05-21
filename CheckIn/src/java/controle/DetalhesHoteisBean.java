/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Beans.Hotel;
import Beans.Quartos;
import Negocio.NegocioHotel;
import Negocio.NegocioQuartos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped
public class DetalhesHoteisBean {

    @ManagedProperty(value = "#{hoteis}")
    private Hoteis hotel;
    private Hotel h;
    private NegocioHotel negHotel;
    private NegocioQuartos negQuartos;
    private ArrayList<Quartos> quartos;

    /**
     * Creates a new instance of DetalhesHoteisBean
     */
    public DetalhesHoteisBean() {
        try {
            Map<String, Object> ms = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            negHotel = new NegocioHotel();

            h = negHotel.obterHotelPorCodigo(Integer.parseInt(ms.get("idHotel").toString()), Hotel.class);    
            //teste
            //h = negHotel.obterHotelPorCodigo(1, Hotel.class);

            negQuartos = new NegocioQuartos();
            Iterable<Quartos> itens = negQuartos.obterQuartosPorCodigoHotel(h.getID(), Quartos.class);
            Iterator i = itens.iterator();

            quartos = new ArrayList<>();

            while (i.hasNext()) {
                this.quartos.add((Beans.Quartos) i.next());
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fieldset Toggled", "Visibility:" + event.getVisibility());
    }

    public Hotel getH() {
        return h;
    }

    public void setH(Hotel h) {
        this.h = h;
    }

    public void setHotel(Hoteis hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Quartos> getQuartos() {
        return quartos;
    }

    public void setQuartos(ArrayList<Quartos> quartos) {
        this.quartos = quartos;
    }
}
