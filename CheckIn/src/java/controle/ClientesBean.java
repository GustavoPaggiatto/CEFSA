/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Beans.ClienteFisico;
import Beans.ClienteJuridico;
import Negocio.NegocioClientes;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Luiz Zabuscka
 */
@ManagedBean
@ViewScoped
public class ClientesBean {

    private ArrayList<ClienteFisico> clientesFisicos;
    private ArrayList<ClienteJuridico> clientesJuridicos;

    public ClientesBean() {
        clientesFisicos = new ArrayList<>();
        clientesJuridicos = new ArrayList<>();

        NegocioClientes n = new NegocioClientes();

        Iterable<ClienteFisico> t = n.ObterClientesFisicos(ClienteFisico.class);
        Iterator it = t.iterator();
        while (it.hasNext()) {
            clientesFisicos.add((ClienteFisico) it.next());
        }

        n = new NegocioClientes();
        Iterable<ClienteJuridico> t2 = n.ObterClientesJuridicos(ClienteJuridico.class);
        Iterator it2 = t2.iterator();
        while (it2.hasNext()) {
            clientesJuridicos.add((ClienteJuridico) it2.next());
        }

//        montarArraysTeste();
    }

    public ArrayList<ClienteFisico> getClientesFisicos() {
        return clientesFisicos;
    }

    public void setClientesFisicos(ArrayList<ClienteFisico> clientesFisicos) {
        this.clientesFisicos = clientesFisicos;
    }

    public ArrayList<ClienteJuridico> getClientesJuridicos() {
        return clientesJuridicos;
    }

    public void setClientesJuridicos(ArrayList<ClienteJuridico> clientesJuridicos) {
        this.clientesJuridicos = clientesJuridicos;
    }
}
