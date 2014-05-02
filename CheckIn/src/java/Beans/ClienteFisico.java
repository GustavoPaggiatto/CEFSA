package Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ClienteFisico")
@PrimaryKeyJoinColumn(name = "idCliente")
public class ClienteFisico extends Cliente {
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "sobrenome")
    private String sobrenome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }   
    
}
