/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import Beans.Usuario;
import Negocio.NegocioUsuarios;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@ViewScoped
public class Login {
    private final String response = "/index.xhtml";
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
                
                FacesContext.getCurrentInstance().getExternalContext().dispatch(url);
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
