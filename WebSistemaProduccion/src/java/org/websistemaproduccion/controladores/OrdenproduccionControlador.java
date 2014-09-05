/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.websistemaproduccion.ejb.DAOOrdenProduccionSB;
import org.websistemaproduccion.ejb.DAOPedidoSB;
import org.websistemaproduccion.ejb.DAOTipoSB;
import org.websistemaproduccion.entidades.Ordenproduccion;
import org.websistemaproduccion.entidades.Pedido;
import org.websistemaproduccion.entidades.Tipo;

@ManagedBean
@SessionScoped
public class OrdenproduccionControlador implements Serializable{
    @EJB
    private DAOPedidoSB dAOPedidoSB;
    @EJB
    private DAOOrdenProduccionSB dAOOrdenProduccionSB;
    @EJB
    private DAOTipoSB dAOTipoSB;
    private Ordenproduccion ordenproduccion;
    private Pedido pedido;
    Date fecha = new Date();
    private List<Tipo> listaTurnos;
    private List<Ordenproduccion> listaOrdenesEx;
    private List<Ordenproduccion> listaOrdenesFl;
    private List<Ordenproduccion> listaOrdenesRe;
    private List<Ordenproduccion> listaOrdenesCs;
    private List<Ordenproduccion> listaOrdenesDb;
    int x=0;
            
    public OrdenproduccionControlador() {
        ordenproduccion = new Ordenproduccion(0,"-",0,fecha,"-",0,0,0,"-",0,0,0,0,"-");                    
        //opRe= new Ordenproduccion(0,"Re",0,fecha,"-",0,0,0,"Pr",0,0,0,0,"-");                    
    }

    public Ordenproduccion getOrdenproduccion() {
        return ordenproduccion;
    }

    public void setOrdenproduccion(Ordenproduccion ordenproduccion) {
        this.ordenproduccion = ordenproduccion;
    }
    
    public String insertar(){
        try{
            dAOOrdenProduccionSB.insertar(ordenproduccion);
            pedido.setEstado("Pr");
            dAOPedidoSB.modifica(pedido);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "OrdenProduccion.insertar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "OrdenProduccion.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }        
        return "";
    }  
    
    public String buscarOrdenProduccion(){
        Ordenproduccion OrdenProdCargadoDesdeBD = null;
        OrdenProdCargadoDesdeBD = dAOOrdenProduccionSB.buscarOrdenxId(ordenproduccion);
        this.ordenproduccion = OrdenProdCargadoDesdeBD;
        return "";
    }
    
    public String eliminaOrdenProduccion(){
        dAOOrdenProduccionSB.elimina(ordenproduccion);
        ordenproduccion = new Ordenproduccion(0,"-",0,fecha,"-",0,0,0,"-",0,0,0,0,"-");             
        return "";
    }
    
    public String modificaOrdenProduccion(){
        dAOOrdenProduccionSB.modifica(ordenproduccion);
        ordenproduccion = new Ordenproduccion(0,"-",0,fecha,"-",0,0,0,"-",0,0,0,0,"-");             
        return "";
    }    

    public List<Tipo> getListaTurnos() {
        listaTurnos = dAOTipoSB.buscarTipoxLetra("TUR");
        return listaTurnos;
    }

    public void setListaTurnos(List<Tipo> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
    
    public void filtrarPedidoRe(int idPedido){
        x = dAOOrdenProduccionSB.ConteoOrdenes("Re");
        ordenproduccion.setCorrelativo(x);
        ordenproduccion.setProceso("Re");
        ordenproduccion.setRollos(0);
        inicializarPedidoOrden(idPedido);
    }      

    public void filtrarPedidoEx(int idPedido){
        x = dAOOrdenProduccionSB.ConteoOrdenes("Ex");
        ordenproduccion.setCorrelativo(x);
        ordenproduccion.setProceso("Ex");
        inicializarPedidoOrden(idPedido);
    }     

    public void filtrarPedidoDb(int idPedido){
        x = dAOOrdenProduccionSB.ConteoOrdenes("Db");
        ordenproduccion.setCorrelativo(x);
        ordenproduccion.setProceso("Db");
        inicializarPedidoOrden(idPedido);
    }   

    public void filtrarPedidoFl(int idPedido){
        x = dAOOrdenProduccionSB.ConteoOrdenes("Fl");
        ordenproduccion.setCorrelativo(x);
        ordenproduccion.setProceso("Fl");
        ordenproduccion.setRepeticiones(0);
        ordenproduccion.setRodillo(0);
        ordenproduccion.setRegistros("CONTINUO");
        inicializarPedidoOrden(idPedido);
    }       

    public void filtrarPedidoCs(int idPedido){
        x = dAOOrdenProduccionSB.ConteoOrdenes("Cs");
        ordenproduccion.setCorrelativo(x);
        ordenproduccion.setProceso("Cs");
        ordenproduccion.setEmpaque(0);
        inicializarPedidoOrden(idPedido);
    }        
    
    public void inicializarPedidoOrden(int idPedido){
        pedido = dAOPedidoSB.buscarPedidoId(idPedido);
        ordenproduccion.setIdOrden(0);
        ordenproduccion.setEstadoOrden("Pr");
        ordenproduccion.setFecha(fecha);
        ordenproduccion.setObservacion("-");
        ordenproduccion.setAncho(pedido.getAncho());
        ordenproduccion.setCalibre(pedido.getCalibre());
        ordenproduccion.setLargo(pedido.getLargo());
        ordenproduccion.setIdPedido(pedido);          
    }
    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Ordenproduccion> getListaOrdenesEx() {
        listaOrdenesEx = dAOOrdenProduccionSB.buscarOrdenxEstadoxProceso("Pr", "Ex");
        return listaOrdenesEx;
    }

    public void setListaOrdenesEx(List<Ordenproduccion> listaOrdenesEx) {
        this.listaOrdenesEx = listaOrdenesEx;
    }

    public List<Ordenproduccion> getListaOrdenesFl() {
        listaOrdenesFl = dAOOrdenProduccionSB.buscarOrdenxEstadoxProceso("Pr", "Fl");
        return listaOrdenesFl;
    }

    public void setListaOrdenesFl(List<Ordenproduccion> listaOrdenesFl) {
        this.listaOrdenesFl = listaOrdenesFl;
    }

    public List<Ordenproduccion> getListaOrdenesRe() {
        listaOrdenesRe = dAOOrdenProduccionSB.buscarOrdenxEstadoxProceso("Pr", "Re");
        return listaOrdenesRe;
    }

    public void setListaOrdenesRe(List<Ordenproduccion> listaOrdenesRe) {
        this.listaOrdenesRe = listaOrdenesRe;
    }

    public List<Ordenproduccion> getListaOrdenesCs() {
        listaOrdenesCs = dAOOrdenProduccionSB.buscarOrdenxEstadoxProceso("Pr", "Cs");
        return listaOrdenesCs;
    }

    public void setListaOrdenesCs(List<Ordenproduccion> listaOrdenesCs) {
        this.listaOrdenesCs = listaOrdenesCs;
    }

    public List<Ordenproduccion> getListaOrdenesDb() {
        listaOrdenesDb = dAOOrdenProduccionSB.buscarOrdenxEstadoxProceso("Pr", "Db");
        return listaOrdenesDb;
    }

    public void setListaOrdenesDb(List<Ordenproduccion> listaOrdenesDb) {
        this.listaOrdenesDb = listaOrdenesDb;
    }
}
