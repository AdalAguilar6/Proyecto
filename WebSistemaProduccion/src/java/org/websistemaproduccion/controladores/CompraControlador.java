/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.websistemaproduccion.ejb.DAOCompraSB;
import org.websistemaproduccion.ejb.DAOMateriaPrimaSB;
import org.websistemaproduccion.ejb.DAOPersonaSB;
import org.websistemaproduccion.entidades.Compra;
import org.websistemaproduccion.entidades.Compradetalle;
import org.websistemaproduccion.entidades.Materiaprima;
import org.websistemaproduccion.entidades.Persona;
import org.websistemaproduccion.controladores.util.JsfUtil;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.websistemaproduccion.ejb.DAOCompraDetalleSB;
/**
 *
 * @author Super Usuario
 */
@ManagedBean
@SessionScoped
public class CompraControlador implements Serializable{
    @EJB
    private DAOCompraDetalleSB dAOCompraDetalleSB;
    @EJB
    private DAOMateriaPrimaSB dAOMateriaPrimaSB;
    @EJB
    private DAOPersonaSB dAOPersonaSB;
    @EJB
    private DAOCompraSB dAOCompraSB;
    private Compra compra;
    private Materiaprima materiaprima;
    private List<Persona> listaProveedor;
    Date fecha = new Date();
    private List<Compra> listaTodos;
    //private DataModel<Compradetalle> listaDetalle;
    private List<Compradetalle> listaDt;   
    private List<Materiaprima> listaMateriaPrima;
    private Compradetalle dt;    
    private Compra selectedcompra;
    private List<Compradetalle> listaDetallexCompra;    
    private Compradetalle selectedetalle;
    private Integer compraid;    
    

    public Compradetalle getSelectedetalle() {
        return selectedetalle;
    }

    public void setSelectedetalle(Compradetalle selectedetalle) {
        this.selectedetalle = selectedetalle;
    }

    public Compra getSelectedcompra() {
        return selectedcompra;
    }

    public void setSelectedcompra(Compra selectedcompra) {
        this.selectedcompra = selectedcompra;
    }

    public CompraControlador() {
        listaDt  = new ArrayList<Compradetalle>();
        compra = new Compra(0,fecha);
        nuevoDetalle();
    }
   
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    public String insertar(){
        dAOCompraSB.insertar(compra);
        compra = new Compra(0,fecha);
        return "";
    }
    
    public String buscarCompra(){
        Compra compraCargadoDesdeBD = null;
        compraCargadoDesdeBD = dAOCompraSB.buscarCompraxId(compra);
        this.compra = compraCargadoDesdeBD;
        return "";
    }
    
    public String eliminaCompra(){
        dAOCompraSB.elimina(compra);
        compra = new Compra(0,fecha);        
        return "";
    }
    
    public String modificaCompra(){
        dAOCompraSB.modifica(compra);
        compra = new Compra(0,fecha);        
        return "";
    } 
    
    public List<Persona> getListaProveedor() {
        listaProveedor = dAOPersonaSB.buscarPersonaProveedor(1);
        return listaProveedor;
    }

    public void setListaCliente(List<Persona> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public List<Compra> getListaTodos() {
        listaTodos = dAOCompraSB.listarTodos();
        return listaTodos;
    }

    public void setListaTodos(List<Compra> listaTodos) {
        this.listaTodos = listaTodos;
    }
/*
    public DataModel<Compradetalle> getListaDetalle() {
        listaDetalle =  new ListDataModel<Compradetalle>(listaDt);
        return listaDetalle;
    }
*/
    public List<Compradetalle> getListaDt() {
        return listaDt;
    }

    public void setListaDt(List<Compradetalle> listaDt) {
        this.listaDt = listaDt;
    }
    
    public Compradetalle getDt() {
        return dt;
    }

    public void setDt(Compradetalle dt) {
        this.dt = dt;
    }    
    
    public String guardarMovimiento(){
        try {
            dAOCompraSB.insertar(compra); 
            //int x=0;
            float existencias;
            //x = dAOCompraDetalleSB.ConteoDetalles();
            
            for (Compradetalle detalle : listaDt) { 
                //x+=1;
                detalle.setIdCompra(compra); 
                //detalle.setIdCompraDet(x);

                materiaprima = dAOMateriaPrimaSB.buscarMateriaPrimaxId(detalle.getIdMateriaPrima());
                existencias = materiaprima.getExistencia() + detalle.getCantidad();  
                materiaprima.setExistencia(existencias);
                
                dAOCompraDetalleSB.insertar(detalle);
                dAOMateriaPrimaSB.modifica(materiaprima);
            }
            //compra.setCompradetalleList(listaDt);
            dAOCompraSB.modifica(compra);
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Compra.guardarMovimiento", 
                    "Compra registrada con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Compra.guardarMovimiento", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
        return "";
    }    

    public List<Materiaprima> getListaMateriaPrima() {
        listaMateriaPrima = dAOMateriaPrimaSB.listarTodos();
        return listaMateriaPrima;
    }

    public void setListaMateriaPrima(List<Materiaprima> listaMateriaPrima) {
        this.listaMateriaPrima = listaMateriaPrima;
    }
    
    public String nuevoDetalle(){
        dt = new Compradetalle();
        dt.setIdCompraDet(0);
        return "";
    }
    
    public String guardarDetalle(){
        listaDt.add(dt); 
        nuevoDetalle();
        return "";
    }    
    
   public String borrarDetalle(){
        listaDt.remove(dt); 
        return "";
   } 
       
    public String cargardetaxidcompra(){
        try {
        List<Compradetalle> notadetaCargadoDesdeBD = null;
        notadetaCargadoDesdeBD = dAOCompraDetalleSB.ListadoDetallexIdcompra(selectedcompra);
        this.setListaDt(notadetaCargadoDesdeBD);
        return "";
       } catch (Exception e) {
          return null;
        }
    }
    
     public void cargardetallexidcompra(Integer vcod){
            this.setListaDt(dAOCompraDetalleSB.ListaDetallexIdcompra(vcod));
            
     }
    
      public String buscarCompra_deta(){
          try {
        Compradetalle notadetaCargadoDesdeBD = null;
        notadetaCargadoDesdeBD = dAOCompraDetalleSB.buscarCompraDetallexId(dt);
        this.dt = notadetaCargadoDesdeBD;
        return "";
        } catch (Exception e) {
           return null;
        }   
    }
      
         public String insertar_detalle(){
           try {
            float existencias;
             materiaprima = dAOMateriaPrimaSB.buscarMateriaPrimaxId(dt.getIdMateriaPrima());
                existencias = materiaprima.getExistencia() + dt.getCantidad();  
                materiaprima.setExistencia(existencias);
        dAOCompraDetalleSB.insertar(dt);
         dAOMateriaPrimaSB.modifica(materiaprima);
        dt = new  Compradetalle(0);  
         FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Compra.insertar_detalle", dt.getIdCompra() + " - Se Almaceno el Detalle Satisfactoriamente.");
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Compra.guardarMovimiento", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        
            }
        return "";
        
    }
        
   public String elimina_deta(){
        try{
        dAOCompraDetalleSB.elimina(dt);
         dt = new Compradetalle(0); 
         selectedetalle= new Compradetalle(0);
         FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Compra.elimina_detalle", dt.getIdCompra() + " - Se Elimino el Detalle Satisfactoriamente.");
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
       
         } catch (Exception e) {
          FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Compra.insertar_detalle", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } 
         return "";
    }
    
    public String modifica_deta(){
        try {
         dAOCompraDetalleSB.modifica(dt);       
         dt = new Compradetalle(0); 
         selectedetalle= new Compradetalle(0);
          FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Compra.insertar_detalle", dt.getIdCompra() + " - Se Almaceno el Detalle Satisfactoriamente.");
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        
         } catch (Exception e) {
           FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Compra.insertar_detalle", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } 
        
        return "";
    }
    
    public void filtrarDetalleCompra(int idCompra){
        listaDetallexCompra = dAOCompraDetalleSB.listaDetalleCompra(idCompra);
    }     

    public List<Compradetalle> getListaDetallexCompra() {
        return listaDetallexCompra;
    }

    public void setListaDetallexCompra(List<Compradetalle> listaDetallexCompra) {
        this.listaDetallexCompra = listaDetallexCompra;
    }
}