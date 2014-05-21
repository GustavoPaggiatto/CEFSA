/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Beans.Quartos;
import DAO.DAOQuartos;
import java.lang.reflect.Type;

/**
 *
 * @author Gustavo
 */
public class NegocioQuartos {

    private DAOQuartos _daoQuartos;

    public NegocioQuartos() {
        _daoQuartos = new DAOQuartos();
    }

    public Quartos obterQuarto(int idQuarto) {
        Quartos quarto;

        quarto = _daoQuartos.obterQuarto(idQuarto);

        return quarto;
    }

    public Iterable<Quartos> obterQuartosPorCodigoHotel(int idHotel, Type t) {
        return _daoQuartos.obterQuartosPorCodigoHotel(idHotel, t);
    }
    
    public Iterable<Quartos> obterTodosQuartos(Type t)
    {
        return _daoQuartos.GetAll(t);
    }
}
