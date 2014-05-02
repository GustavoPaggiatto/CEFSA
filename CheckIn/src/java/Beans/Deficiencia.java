package Beans;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author luizzabuscka
 */
@Entity
@Table(name = "Deficiencias")
public class Deficiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDeficiencia")
    private int ID;

    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "gravidade")
    private String gravidade;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AcompanhanteDeficiente",
            joinColumns = {@JoinColumn(name = "idDeficiencia")},
            inverseJoinColumns = {@JoinColumn(name = "idAcompanhante")})
    private Set<Acompanhante> acompanhantes;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ClienteDeficiente",
            joinColumns = {@JoinColumn(name = "idDeficiencia")},
            inverseJoinColumns = {@JoinColumn(name = "idCliente")})
    private Set<Cliente> clientes;

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

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public Set<Acompanhante> getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(HashSet<Acompanhante> acompanhantes) {
        this.acompanhantes = acompanhantes;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }

}
