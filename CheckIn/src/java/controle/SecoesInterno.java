/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@RequestScoped
public class SecoesInterno {

    /**
     * Creates a new instance of SecoesInterno
     */
    public SecoesInterno() {
        
    }
    
    
    public void sessionHotelSeleiconado(int idHotel) throws IOException{
     HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);        
     s.setAttribute("idHotel", idHotel);
     
     String view = "";
     Object viewId = FacesContext.getCurrentInstance().getExternalContext().getRequest();     
     if(viewId instanceof HttpServletRequest)
         view = ((HttpServletRequest)viewId).getRequestURI().toString();
     
     FacesContext.getCurrentInstance().getExternalContext().redirect(view);
    }
}
