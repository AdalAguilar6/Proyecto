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
import javax.persistence.Query;
import org.websistemaproduccion.ejb.DAOMateriaPrimaSB;
import org.websistemaproduccion.ejb.DAOOrdenProduccionSB;
import org.websistemaproduccion.ejb.DAORequisicionDetalleSB;
import org.websistemaproduccion.ejb.DAORequisicionSB;
import org.websistemaproduccion.entidades.Materiaprima;
import org.websistemaproduccion.entidades.Ordenproduccion;
import org.websistemaproduccion.entidades.Requisicion;
import org.websistemaproduccion.entidades.Requisiciondetalle;

/**
 *
 * @author Super Usuario
 */
@ManagedBean
@SessionScoped
public class RequisicionControlador implements Serializable{
    @EJB
    private DAOOrdenProduccionSB dAOOrdenProduccionSB;
    @EJB
    private DAOMateriaPrimaSB dAOMateriaPrimaSB;
    @EJB
    private DAORequisicionDetalleSB dAORequisicionDetalleSB;
    @EJB
    private DAORequisicionSB dAORequisicionSB;
    private Requisicion requisicion;
    Date fecha = new Date();
    private DataModel<Requisiciondetalle> listaDetalle;
    private List<Requisiciondetalle> listaDt;   
    private List<Materiaprima> listaMateriaPrima;
    private Requisiciondetalle dt;  
    private List<Requisicion> ListaTodos;
    private Materiaprima materiaprima;
    private List<Ordenproduccion> ListaOrdenP;    
    private List<Requisiciondetalle> listaDetallexRequisicion;

    public List<Requisiciondetalle> getListaDetallexRequisicion() {
        return listaDetallexRequisicion;
    }

    public void setListaDetallexRequisicion(List<Requisiciondetalle> listaDetallexRequisicion) {
        this.listaDetallexRequisicion = listaDetallexRequisicion;
    }    
    
    public List<Ordenproduccion> getListaOrdenP() {
        ListaOrdenP=dAOOrdenProduccionSB.listarTodos();  
        return ListaOrdenP;
    }

    public void setListaOrdenP(List<Ordenproduccion> ListaOrdenP) {
        this.ListaOrdenP = ListaOrdenP;
    }    

    public List<Requisicion> getListaTodos() {
        ListaTodos = dAORequisicionSB.listarTodos();
        return ListaTodos;
    }

    public void setListaTodos(List<Requisicion> listaTodos) {
        this.ListaTodos = listaTodos;
    }    
    
    public RequisicionControlador() {
        listaDt  = new ArrayList<Requisiciondetalle>();
        requisicion = new Requisicion(0,fecha,"Pe",null);
        nuevoDetalle();
    }

    public Requisicion getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(Requisicion requisicion) {
        this.requisicion = requisicion;
    }
    
    public String insertar(){
        dAORequisicionSB.insertar(requisicion);
        requisicion = new Requisicion(0,fecha,"Pe",null);        
        return "";
    }
    
    public String buscarRequisicion(){
        Requisicion requisicionCargadoDesdeBD = null;
        requisicionCargadoDesdeBD = dAORequisicionSB.buscarRequisicionxId(requisicion);
        this.requisicion = requisicionCargadoDesdeBD;
        return "";
    }
    
    public String eliminaRequisicion(){
        dAORequisicionSB.elimina(requisicion);
        requisicion = new Requisicion(0,fecha,"Pe",null);
        return "";
    }
    
    public String modificaRequisicion(){
        dAORequisicionSB.modifica(requisicion);
        requisicion = new Requisicion(0,fecha,"Pe",null);
        return "";
    }  
    
    public List<Requisiciondetalle> getListaDt() {
        return listaDt;
    }

    public void setListaDt(List<Requisiciondetalle> listaDt) {
        this.listaDt = listaDt;
    }
    
    public String guardarMovimiento(){
        try {
            dAORequisicionSB.insertar(requisicion); 
            float existencias;
            for (Requisiciondetalle detalle : listaDt) {                
                materiaprima = dAOMateriaPrimaSB.buscarMateriaPrimaxId(detalle.getIdMateriaPrima());
                
                if (detalle.getCantidad() < materiaprima.getExistencia()){
                    existencias = materiaprima.getExistencia() - detalle.getCantidad();  
                    materiaprima.setExistencia(existencias);
                    
                    detalle.setIdRequisicion(requisicion); 
                    dAORequisicionDetalleSB.insertar(detalle); //graba detalle
                    dAOMateriaPrimaSB.modifica(materiaprima); //actualiza existencias
                } else{
                    FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Requisicion.guardarMovimiento", materiaprima.getNombre() + " - Existencias Insuficientes.");
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
                }    
            }
            //requisicion.setRequisiciondetalleList(listaDt);
            dAORequisicionSB.modifica(requisicion);
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Requisicion.guardarMovimiento", 
                    "Requisicion registrada con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Requisicion.guardarMovimiento", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
        return "";
    }    

    public Requisiciondetalle getDt() {
        return dt;
    }

    public void setDt(Requisiciondetalle dt) {
        this.dt = dt;
    }    
    
    public List<Materiaprima> getListaMateriaPrima() {
        listaMateriaPrima = dAOMateriaPrimaSB.listarTodos();
        return listaMateriaPrima;
    }

    public void setListaMateriaPrima(List<Materiaprima> listaMateriaPrima) {
        this.listaMateriaPrima = listaMateriaPrima;
    }
    
    public String nuevoDetalle(){
        dt = new Requisiciondetalle();
        dt.setIdRequisicionDetalle(0);
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

    public DataModel<Requisiciondetalle> getListaDetalle() {
        listaDetalle =  new ListDataModel<Requisiciondetalle>(listaDt);
        return listaDetalle;
    }  

    public String insertar_detalle(){
         try {
          float existencias;
          materiaprima = dAOMateriaPrimaSB.buscarMateriaPrimaxId(dt.getIdMateriaPrima());
            if (dt.getCantidad()< materiaprima.getExistencia()){
                    existencias = materiaprima.getExistencia() - dt.getCantidad();  
                    materiaprima.setExistencia(existencias);                    
                   // dt.setIdRequisicion(requisicion); 
                    dAORequisicionDetalleSB.insertar(dt); //graba detalle
                    dAOMateriaPrimaSB.modifica(materiaprima); //actualiza existencias
                     dt = new  Requisiciondetalle(0);   
                     
                    FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Requisicion.insertar_detalle", dt.getIdRequisicionDetalle() + " - Se Almaceno Detalle Satisfactoriamente.");
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
                } else{
                     FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Requisicion.guardarMovimiento", materiaprima.getNombre() + " - Existencias Insuficientes.");
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
                } 
            } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Requisicion.guardarMovimiento", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        
            }
        return "";
    }    
    
   public String elimina_deta(){
        try{
        dAORequisicionDetalleSB.elimina(dt);
         dt = new Requisiciondetalle(0);         
        return "";
         } catch (Exception e) {
           return null;
        }  
    }
    
    public String modifica_deta(){
        try {
         dAORequisicionDetalleSB.modifica(dt);       
         dt = new Requisiciondetalle(0);  
         FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Requisicion.modificar_detalle", dt.getIdRequisicionDetalle() + " - Se Modifico Detalle Satisfactoriamente.");
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        return "";
         } catch (Exception e) {
           return null;
        }  
    }
    
       public void cargardetallexidRequi(Integer vcod){
         this.setListaDt(dAORequisicionDetalleSB.ListaDetallexIdrequi(vcod));
        } 
       
        public String buscarCompra_deta(){
          try {
                Requisiciondetalle CargadoDesdeBD = null;
                CargadoDesdeBD = dAORequisicionDetalleSB.buscarRequiDetallexId(dt);
                this.dt = CargadoDesdeBD;
                return "";
        } catch (Exception e) {
           return null;
        }   
    }    
    
    public String aprobarRequisicion(){
        if (requisicion.getFechaDespacho()==null){
            requisicion.setFechaDespacho(fecha);
            dAORequisicionSB.modifica(requisicion);
        }
        return "";
    }     

    public void filtrarDetalleRequisicion(int idRequisicion){
        listaDetallexRequisicion = dAORequisicionDetalleSB.listarDetalleRequi(idRequisicion);
    }      
}
