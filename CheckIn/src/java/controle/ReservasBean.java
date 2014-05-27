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
import Beans.ReservasStatus;
import Negocio.NegocioReservas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Luiz Zabuscka
 */
@ManagedBean
@ViewScoped
public class ReservasBean {
    
    private Reservas reserva;
    private Quartos quarto;
    private String dataInicial, dataFinal; // era Date, puis String para testar
    private ClienteFisico cliente;
    private ArrayList<String> qtdHospedes; // era integer
    private Integer selecionado;
    private String nomeCliente;
    static Logger log = Logger.getLogger(ReservasBean.class.getName());
    
    public ReservasBean() {
        try {
            
            HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            if (((Cliente) (s.getAttribute("clienteLogado"))) == null) {
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
            
            Integer i = 1, max = quarto.getQtdHospedes();
            qtdHospedes = new ArrayList<String>();
            while (i <= max) {
                qtdHospedes.add(i.toString());
                i++;
            }
        } catch (Exception ex) {
            log.error(ex);
        }
    }
    
    public void reservarQuarto() throws ParseException {
        Date dtIni, dtFim;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        dtIni = formatter.parse(dataInicial);
        dtFim = formatter.parse(dataFinal);
        
        reserva.setDataReserva(new Date());
        reserva.setPreco(this.CalcularPreco());
        
        reserva.setQtdDias(dtFim.getDate() - dtIni.getDate());
        reserva.setQuarto(this.quarto);
        reserva.setCliente(cliente);
        
        ReservasStatus rs = new ReservasStatus();
        rs.setID(4);
        
        reserva.setStatus(rs); //criar ENUM para status da reserva        
        
        NegocioReservas negReservas = new NegocioReservas();
        negReservas.reservar(reserva);
    }
    
    public Integer getSelecionado() {
        return selecionado;
    }
    
    public void setSelecionado(Integer selecionado) {
        this.selecionado = selecionado;
    }
    
    public ArrayList<String> getQtdHospedes() {
        return qtdHospedes;
    }
    
    public void setQtdHospedes(ArrayList<String> qtdHospedes) {
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
        double dias = 2; // teste
        //double dias = dataFinal.getDate() - dataInicial.getDate();
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
    
    public String getDataInicial() {
        return dataInicial;
    }
    
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public String getDataFinal() {
        return dataFinal;
    }
    
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public ArrayList<String> qtdHospedesString() {
        ArrayList<String> lista = new ArrayList<>();
        for (String ind : qtdHospedes) {
            if (ind == "1") {
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
