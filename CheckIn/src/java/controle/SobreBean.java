/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Beans.Cliente;
import Beans.ClienteFisico;
import Beans.ClienteJuridico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@RequestScoped
public class SobreBean {

    /**
     * Creates a new instance of SobreBean
     */
    static Logger log = Logger.getLogger(SobreBean.class.getName());

    public SobreBean() {
        try {
            HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            if (((Cliente) (s.getAttribute("clienteLogado"))) != null) {
                if (((s.getAttribute("clienteLogado"))).getClass() == ClienteFisico.class) {
                    this.nomeCliente = ((ClienteFisico) (s.getAttribute("clienteLogado"))).getNome();
                } else {
                    this.nomeCliente = ((ClienteJuridico) (s.getAttribute("clienteLogado"))).getNomeEmpresa();
                }
            } else {
                this.nomeCliente = "Usuário";
            }
        } catch (Exception ex) {
            log.error(ex);
        }
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    private String nomeCliente = "";
}
