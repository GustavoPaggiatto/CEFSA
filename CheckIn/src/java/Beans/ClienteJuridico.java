package Beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "ClienteJuridico")
@PrimaryKeyJoinColumn(name = "idCliente")
public class ClienteJuridico extends Cliente {    

    @Column(name = "CNPJClienteJuridico")
    private String cnpj;
    
    @Column(name = "nomeEmpresa")
    private String nomeEmpresa;
    
    @Column(name = "multinacional")
    private boolean multinacional;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco localidadeMatriz;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public boolean isMultinacional() {
        return multinacional;
    }

    public void setMultinacional(boolean multinacional) {
        this.multinacional = multinacional;
    }

    public Endereco getLocalidadeMatriz() {
        return localidadeMatriz;
    }

    public void setLocalidadeMatriz(Endereco localidadeMatriz) {
        this.localidadeMatriz = localidadeMatriz;
    }
    
    
}
