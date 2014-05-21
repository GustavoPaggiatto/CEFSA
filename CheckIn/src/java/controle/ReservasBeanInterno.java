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
    public ReservasBeanInterno() {
        this.ObterReservas();
    }
    
    private ArrayList<Reservas> reservas;
    private NegocioReservas negReservas;
    
    public void ObterReservas()
    {
        negReservas = new NegocioReservas();
        Iterable<Reservas> iterable = negReservas.obterTodasReservas();
        
        reservas = new ArrayList<>();
        Iterator i = iterable.iterator();
        while(i.hasNext()){
            reservas.add((Reservas)i.next());
        }
    }

    public ArrayList<Reservas> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reservas> reservas) {
        this.reservas = reservas;
    }   
}
