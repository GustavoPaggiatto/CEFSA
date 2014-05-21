/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import Beans.Cliente;
import Beans.Usuario;
import Negocio.NegocioUsuarios;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped
public class Login {
    private final String response = "/CheckIn/listing.xhtml";
    public String loginUsuarioValue, senha;
    
    public Login()
    {
        
    }
    
    public void LoginUsuario()
    {
        try
        {
            Negocio.NegocioUsuarios negUsuarios = new NegocioUsuarios();
            if(negUsuarios.AutenticaUsuario(this.loginUsuarioValue, this.senha))                
            {
                String url = this.response;
                HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);        
                negUsuarios = new NegocioUsuarios();
                Cliente c = negUsuarios.obterClienteLogado(senha, loginUsuarioValue);               
                
                s.setAttribute("clienteLogado", c);
                
                FacesContext.getCurrentInstance().getExternalContext().redirect(url);
            }
        }
        catch(Exception e)
        {
            //Vai gravar Log
        }                
    }

    public String getLoginUsuarioValue() {
        return loginUsuarioValue;
    }

    public void setLoginUsuarioValue(String loginUsuarioValue) {
        this.loginUsuarioValue = loginUsuarioValue;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
