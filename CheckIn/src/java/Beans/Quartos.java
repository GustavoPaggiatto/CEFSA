package Beans;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author luizzabuscka
 */
@Entity
@Table(name="Quartos")
public class Quartos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idQuartos")    
    private int ID;
   
    @ManyToOne
    @JoinColumn(name = "idTiposQuartos")
    private TiposQuartos tipoQuarto;
    
    @ManyToOne
    @JoinColumn(name="idLocalidadesQuartos")
    private LocalidadesQuartos localidade;
    
    @Column(name = "qtdHospedes")
    private int qtdHospedes;
    
    @Column(name = "valorDiaria")
    private double valorDiaria;
    
    @ManyToOne
    @JoinColumn(name = "idHotel", nullable = true)
    private Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public TiposQuartos getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TiposQuartos tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public LocalidadesQuartos getLocalidade() {
        return localidade;
    }

    public void setLocalidade(LocalidadesQuartos localidade) {
        this.localidade = localidade;
    }

    public int getQtdHospedes() {
        return qtdHospedes;
    }

    public void setQtdHospedes(int qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    
    
}
