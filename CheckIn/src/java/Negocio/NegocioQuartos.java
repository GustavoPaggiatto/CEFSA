/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Beans.Quartos;
import DAO.DAOQuartos;

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
}
