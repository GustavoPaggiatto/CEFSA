package Beans;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luizzabuscka
 */
@Entity
@Table(name = "CotacoesStatus")
public class CotacoesStatus implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCotacoesStatus")
    private int ID;
    
    @Column(name = "descricao")
    private String descricao;    
    
    @OneToMany(mappedBy = "status")
    private Set<CotacoesReservas> cotacoes;

    public Set<CotacoesReservas> getCotacoes() {
        return cotacoes;
    }

    public void setCotacoes(HashSet<CotacoesReservas> cotacoes) {
        this.cotacoes = cotacoes;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
}
