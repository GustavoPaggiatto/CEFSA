/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;



import Beans.Reservas;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Luiz Zabuscka
 */
@ManagedBean
@ViewScoped
public class ReservasBean {
    
    private ArrayList<Reservas> reservas;
    
    public ReservasBean() {
        reservas = new ArrayList<>();
        
        montaDadosTeste();
    }
    

    public ArrayList<Reservas> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reservas> reservas) {
        this.reservas = reservas;
    }
    
    
    
    public void montaDadosTeste() {
        
        Reservas r1 = new Reservas();
        r1.setID(1);
        r1.setPreco(120.00);
        r1.setQtdDias(10);
        r1.setDataReserva(new Date());
        reservas.add(r1);
        
        Reservas r2 = new Reservas();
        r2.setID(2);
        r2.setPreco(130.00);
        r2.setQtdDias(15);
        r2.setDataReserva(new Date());
        reservas.add(r2);
        
        Reservas r3 = new Reservas();
        r3.setID(3);
        r3.setPreco(123.50);
        r3.setQtdDias(11);
        r3.setDataReserva(new Date());
        reservas.add(r3);
    }
    
}
