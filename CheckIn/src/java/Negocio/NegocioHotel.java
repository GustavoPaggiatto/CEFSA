/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Beans.Hotel;
import DAO.DAOHotel;
import java.lang.reflect.Type;

/**
 *
 * @author Gustavo
 */
public class NegocioHotel {

    private DAOHotel _daoHotel;

    public NegocioHotel() {
        this._daoHotel = new DAOHotel();
    }

    public Iterable<Hotel> ObterHoteis(Type t) {
        return this._daoHotel.ObterHoteis(t);
    }
    
    public Hotel obterHotelPorCodigo(int id, Type t)
    {
        return _daoHotel.obterHotelPorCodigo(id, t);
    }
}
