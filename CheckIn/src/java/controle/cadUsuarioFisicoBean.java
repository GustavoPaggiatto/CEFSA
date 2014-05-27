/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Beans.ClienteFisico;
import Beans.Usuario;
import Negocio.NegocioClientes;
import Negocio.NegocioUsuarios;
import java.security.NoSuchAlgorithmException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.Logger;
import util.Criptografia;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@RequestScoped
public class cadUsuarioFisicoBean {

    /**
     * Creates a new instance of cadUsuarioFisicoBean
     */
    public cadUsuarioFisicoBean() {
    }
    
    static Logger log = Logger.getLogger(cadUsuarioFisicoBean.class.getName());

    public void insereUsuarioFisico() throws NoSuchAlgorithmException {
        try {
            Usuario u = new Usuario();
            u.setLogin(this.cpf);
            
            Criptografia c = new Criptografia();
            String hash = c.CriptografiaSenha(this.senha);
            
            u.setSenha(hash);
            
            ClienteFisico cli = new ClienteFisico();
            cli.setCpf(this.cpf);
            cli.setNome(this.nome);
            cli.setSenha(hash);
            cli.setSobrenome(this.sobrenome);
            
            NegocioUsuarios negUsuario = new NegocioUsuarios();
            negUsuario.InsereUsuario(u);
            
            NegocioClientes negClientes = new NegocioClientes();
            negClientes.InsereCliente(cli);
        } catch (Exception ex) {
            log.error(ex);
        }
    }
    
    private String nome, sobrenome, cpf, senha;
    
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
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
