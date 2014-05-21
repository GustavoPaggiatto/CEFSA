/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Hotel;
import java.lang.reflect.Type;

/**
 *
 * @author Gustavo
 */
public class DAOHotel extends Base {

    public Iterable<Hotel> ObterHoteis(Type t) {
        return super.GetAll(t);
    }

    public Hotel obterHotelPorCodigo(int id, Type t) {
        return (Hotel)super.Find(id, t);
    }
}
