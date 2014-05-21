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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author luizzabuscka
 */
@Entity
@Table(name = "Hotel")
public class Hotel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHotel")
    private int ID;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "qtdEstrelas")
    private int qtdEstrelas;
    
    @Column(name = "anoConstrucao")
    private int anoConstrucao;
    
    @ManyToOne
    @JoinColumn(name = "idTipoHotel")
    private TipoHotel tipoHotel;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Endereco endereco;
    
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    private Set<Telefones> telefones;
    
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    private Set<Quartos> quartos;

    public Set<Quartos> getQuartos() {
        return quartos;
    }

    public void setQuartos(Set<Quartos> quartos) {
        this.quartos = quartos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEstrelas() {
        return qtdEstrelas;
    }

    public void setQtdEstrelas(int qtdEstrelas) {
        this.qtdEstrelas = qtdEstrelas;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public TipoHotel getTipoHotel() {
        return tipoHotel;
    }

    public void setTipoHotel(TipoHotel tipoHotel) {
        this.tipoHotel = tipoHotel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Set<Telefones> getTelefones() {
        return telefones;
    }

    public void setTelefones(HashSet<Telefones> telefones) {
        this.telefones = telefones;
    }
    
    
    
}
