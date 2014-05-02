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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author luizzabuscka
 */
@Entity
@Table(name = "Clientes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable{
    
    //idCliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private int ID;

    @OneToMany(mappedBy = "cliente")    
    private Set<Acompanhante> acompanhantes;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ClienteDeficiente",
            joinColumns = {@JoinColumn(name = "idCliente")},
            inverseJoinColumns = {@JoinColumn(name = "idDeficiencia")})
    private Set<Deficiencia> deficiencias;
    
    @OneToMany(mappedBy = "cliente")
    private Set<Telefones> telefones;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente")
    private Set<CotacoesReservas> cotacoesReservas;

    public Set<CotacoesReservas> getCotacoesReservas() {
        return cotacoesReservas;
    }

    public void setCotacoesReservas(HashSet<CotacoesReservas> cotacoesReservas) {
        this.cotacoesReservas = cotacoesReservas;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Set<Acompanhante> getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(HashSet<Acompanhante> acompanhantes) {
        this.acompanhantes = acompanhantes;
    }

    public Set<Deficiencia> getDeficiencias() {
        return deficiencias;
    }

    public void setDeficiencias(HashSet<Deficiencia> deficiencias) {
        this.deficiencias = deficiencias;
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
