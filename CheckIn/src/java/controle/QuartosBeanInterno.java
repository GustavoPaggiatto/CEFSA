/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Beans.Quartos;
import Beans.Reservas;
import Negocio.NegocioQuartos;
import static controle.QuartosBean.log;
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
public class QuartosBeanInterno {

    /**
     * Creates a new instance of QuartosBeanInterno
     */
    static Logger log = Logger.getLogger(QuartosBeanInterno.class.getName());
    
    public QuartosBeanInterno() {
        try {
            this.obterTodosOsQuartos();
        } catch (Exception ex) {
            log.error(ex);
        }
    }

    ArrayList<Quartos> quartos;
    NegocioQuartos negQuartos;

    private void obterTodosOsQuartos() {
        negQuartos = new NegocioQuartos();
        quartos = new ArrayList<>();
        String valueSession = "";

        Iterable t = negQuartos.obterTodosQuartos(Quartos.class);
        Iterator i = t.iterator();
        Object o = new Object();

        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (s.getAttribute("idHotel") != null) {
            valueSession = s.getAttribute("idHotel").toString();
        }

        while (i.hasNext()) {
            o = i.next();
            if (valueSession != "") {
                if (((Quartos) o).getHotel().getID() == Integer.parseInt(valueSession)) {
                    quartos.add((Quartos) o);
                }
            } else {
                quartos.add((Quartos) o);
            }
        }
    }

    public ArrayList<Quartos> getQuartos() {
        return quartos;
    }

    public void setQuartos(ArrayList<Quartos> quartos) {
        this.quartos = quartos;
    }
}
