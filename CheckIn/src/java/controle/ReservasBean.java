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
import Beans.Reservas;
import Negocio.NegocioReservas;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luiz Zabuscka
 */
@ManagedBean
@ViewScoped
public class ReservasBean {

    private Reservas reserva;
    private Quartos quarto;
    private Date dataInicial, dataFinal;
    private ClienteFisico cliente;
    private ArrayList<Integer> qtdHospedes;
    private Integer selecionado;
    private String nomeCliente;
    
    
    public ReservasBean() {
        
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if(((Cliente)(s.getAttribute("clienteLogado"))) == null){
            //redirect to expired session page
        }
        
        if (((s.getAttribute("clienteLogado"))).getClass() == ClienteFisico.class) {
            nomeCliente = ((ClienteFisico) (s.getAttribute("clienteLogado"))).getNome();
        } else {
            nomeCliente = ((ClienteJuridico) (s.getAttribute("clienteLogado"))).getNomeEmpresa();
        }
            
        reserva = new Reservas();
        quarto = new Quartos();
        
        int idQuarto = Integer.parseInt(s.getAttribute("idQuarto").toString());

        cliente = new ClienteFisico();
        cliente = this.getSessaoCliente();
        quarto = new Negocio.NegocioQuartos().obterQuarto(idQuarto);

        int i = 1, max = quarto.getQtdHospedes();
        qtdHospedes = new ArrayList<Integer>();
        while (i <= max) {
            qtdHospedes.add(i);
            i++;
        }
    }

    public void reservarQuarto() {
        //reserva.setDataReserva(new Date());
        reserva.setPreco(this.CalcularPreco());
        reserva.setQtdDias(this.dataFinal.getDate() - this.dataInicial.getDate());
        reserva.setQuarto(this.quarto);
        reserva.setCliente(cliente);

        NegocioReservas negReservas = new NegocioReservas();
        negReservas.reservar(reserva);
        //reserva.setStatus(null); criar ENUM para status da reserva        
    }

    public Integer getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Integer selecionado) {
        this.selecionado = selecionado;
    }

    public ArrayList<Integer> getQtdHospedes() {
        return qtdHospedes;
    }

    public void setQtdHospedes(ArrayList<Integer> qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }

    private ClienteFisico getSessaoCliente() {
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return (ClienteFisico) s.getAttribute("clienteLogado");
    }

    public ClienteFisico getCliente() {
        return cliente;
    }

    public void setCliente(ClienteFisico cliente) {
        this.cliente = cliente;
    }

    private Double CalcularPreco() {
        double dias = dataFinal.getDate() - dataInicial.getDate();
        return quarto.getValorDiaria() * dias;
    }

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }

    public Quartos getQuarto() {
        return quarto;
    }

    public void setQuarto(Quartos quarto) {
        this.quarto = quarto;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public ArrayList<String> qtdHospedesString() {
        ArrayList<String> lista = new ArrayList<>();
        for (int ind : qtdHospedes) {
            if (ind == 1) {
                lista.add(ind + " pessoa");
            } else {
                lista.add(ind + " pessoas");
            }
        }
        return lista;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }   

    public void setSelecionado(int id) {
        this.selecionado = id;
    }
}
