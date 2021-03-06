/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Beans.TiposQuartos;
import DAO.DAOTiposQuartos;
import java.lang.reflect.Type;

/**
 *
 * @author Gustavo
 */
public class NegocioTiposQuartos {

    private DAOTiposQuartos _daoTiposQuartos;

    public NegocioTiposQuartos() {
        _daoTiposQuartos = new DAOTiposQuartos();
    }

    public TiposQuartos obterTipoQuarto(int idTipoQuarto) {
        TiposQuartos tipoQuarto;

        tipoQuarto = _daoTiposQuartos.obterTipoQuarto(idTipoQuarto);

        return tipoQuarto;
    }

    public void insertTiposQuartos(TiposQuartos tiposQuartos) {
        _daoTiposQuartos.insertTiposQuartos(tiposQuartos);
    }

    public Iterable<TiposQuartos> ConsultarTiposQuartos(String predicado, Type t) {
        return _daoTiposQuartos.ConsultarTiposQuartos(predicado, t);
    }
}
