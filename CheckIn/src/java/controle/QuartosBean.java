/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Beans.Cliente;
import Beans.ClienteFisico;
import Beans.ClienteJuridico;
import Beans.Quartos;
import Negocio.NegocioQuartos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
public class QuartosBean {

    private NegocioQuartos negQuartos;
    private ArrayList<Quartos> quartos;
    private String nomeCliente, visibilityLogin;
    private String visibleButton = "block";
    static Logger log = Logger.getLogger(QuartosBean.class.getName());
    
    /**
     * Creates a new instance of QuartosBean
     */
    public QuartosBean() {
        try {
            HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            /*if (((Cliente) (s.getAttribute("clienteLogado"))) == null) {
             //redirect to expired session page}
             }*/

            quartos = new ArrayList<Quartos>();
            negQuartos = new NegocioQuartos();

            if (((Cliente) (s.getAttribute("clienteLogado"))) != null) {
                if (((s.getAttribute("clienteLogado"))).getClass() == ClienteFisico.class) {
                    nomeCliente = ((ClienteFisico) (s.getAttribute("clienteLogado"))).getNome();
                } else {
                    nomeCliente = ((ClienteJuridico) (s.getAttribute("clienteLogado"))).getNomeEmpresa();
                }
            } else {
                nomeCliente = "Usuário";
                this.visibleButton = "none";
            }

            Iterable<Quartos> qs = negQuartos.obterTodosQuartos(Quartos.class);
            Iterator i = qs.iterator();
            while (i.hasNext()) {
                quartos.add((Quartos) i.next());
            }
        } catch (Exception e) {            
            log.error(e);
        }
    }

    public void SelecioQuartoReserva(int idQuarto) throws IOException {
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (((Cliente) (s.getAttribute("clienteLogado"))) != null) {
            s.setAttribute("idQuarto", idQuarto);
            FacesContext.getCurrentInstance().getExternalContext().redirect("location.xhtml");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index_1.xhtml");
        }
    }

    public String getVisibilityLogin() {
        return visibilityLogin;
    }

    public void setVisibilityLogin(String visibilityLogin) {
        this.visibilityLogin = visibilityLogin;
    }

    public ArrayList<Quartos> getQuartos() {
        return quartos;
    }

    public void setQuartos(ArrayList<Quartos> quartos) {
        this.quartos = quartos;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
