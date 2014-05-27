/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Beans.Reservas;
import DAO.DAOReservas;

/**
 *
 * @author Gustavo
 */
public class NegocioReservas {

    private DAOReservas _daoReservas;

    public NegocioReservas() {
        _daoReservas = new DAOReservas();
    }

    public Reservas obterReserva(int idReserva) {
        Reservas reserva;
        reserva = _daoReservas.obterReserva(idReserva);

        return reserva;
    }
    
    public void reservar(Reservas r)
    {
        _daoReservas.reservar(r);
    }
    
    public Iterable obterTodasReservas()
    {
        return _daoReservas.GetAll(Reservas.class);
    }
}
