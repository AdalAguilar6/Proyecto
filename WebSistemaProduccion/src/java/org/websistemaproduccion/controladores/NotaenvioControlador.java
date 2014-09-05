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
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.websistemaproduccion.ejb.DAOBobinaFardoSB;
import org.websistemaproduccion.ejb.DAONotaEnvioDetalleSB;
import org.websistemaproduccion.ejb.DAONotaEnvioSB;
import org.websistemaproduccion.ejb.DAOPedidoSB;
import org.websistemaproduccion.entidades.Bobinafardo;
import org.websistemaproduccion.entidades.Notaenvio;
import org.websistemaproduccion.entidades.Notaenviodetalle;
import org.websistemaproduccion.entidades.Pedido;

/**
 *
 * @author Super Usuario
 */
@ManagedBean
@SessionScoped
public class NotaenvioControlador implements Serializable{
    @EJB
    private DAOBobinaFardoSB dAOBobinaFardoSB;
    @EJB
    private DAOPedidoSB dAOPedidoSB;
    @EJB
    private DAONotaEnvioDetalleSB dAONotaEnvioDetalleSB;
    @EJB
    private DAONotaEnvioSB dAONotaEnvioSB;
    private Notaenvio notaenvio;
    Date fecha = new Date();  
    private List<Notaenvio> lista;
    private Notaenviodetalle dt;
    private List<Notaenviodetalle> listaDt;
    private DataModel<Notaenviodetalle> listaDetalle;
    private List<Notaenviodetalle> listaDtodos;
    private Notaenvio selectionota;
    private Integer Idnotaenvio;
    private List<Pedido> ListarPedidos;
    private List<Bobinafardo> ListaBobina;
    private List<Notaenviodetalle> listaDetallexNota;

    public List<Notaenviodetalle> getListaDetallexNota() {
        return listaDetallexNota;
    }

    public void setListaDetallexNota(List<Notaenviodetalle> listaDetallexNota) {
        this.listaDetallexNota = listaDetallexNota;
    }    
    
    public List<Bobinafardo> getListaBobina() {
        ListaBobina=dAOBobinaFardoSB.listarTodos();
        return ListaBobina;
    }

    public void setListaBobina(List<Bobinafardo> ListaBobina) {
        this.ListaBobina = ListaBobina;
    }

    
    public List<Pedido> getListarPedidos() {
        ListarPedidos=dAOPedidoSB.listarTodos();
        return ListarPedidos;
    }

    public void setListarPedidos(List<Pedido> ListarPedidos) {
        this.ListarPedidos = ListarPedidos;
    }
   
    public Notaenvio getSelectionota() {
        
        return selectionota;
    }

    public void setSelectionota(Notaenvio selectionota) {
        this.selectionota = selectionota;
    }
   
     
    public List<Notaenviodetalle> getListaDtodos() {
        // listaDtodos = dAONotaEnvioDetalleSB.listarTodos();     
        return listaDtodos;
    }

    public void setListaDtodos(List<Notaenviodetalle> listaDtodos) {
        this.listaDtodos = listaDtodos;
    }
     
    
    public DataModel<Notaenviodetalle> getListaDetalle() {
        listaDetalle =  new ListDataModel<Notaenviodetalle>(listaDt);
        return listaDetalle;
    }

    public void setListaDetalle(DataModel<Notaenviodetalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

     
    public Notaenviodetalle getDt() {
        return dt;
    }

    public void setDt(Notaenviodetalle dt) {
        this.dt = dt;
    }
      

    public List<Notaenviodetalle> getListaDt() {
        return listaDt;
    }

    public void setListaDt(List<Notaenviodetalle> listaDt) {
        this.listaDt = listaDt;
    }
     
    public List<Notaenvio> getLista() {
        lista = dAONotaEnvioSB.listarTodos();                
        return lista;
    }

    public void setLista(List<Notaenvio>  lista) {
        this.lista = lista;
    }

    public NotaenvioControlador() {
         listaDt  = new ArrayList<Notaenviodetalle>();
         notaenvio = new Notaenvio(0,fecha);
         dt = new Notaenviodetalle(0);        
    }

    public Notaenvio getNotaenvio() {
        return notaenvio;
    }

    public void setNotaenvio(Notaenvio notaenvio) {
        this.notaenvio = notaenvio;
    }
    
    public String insertar(){
        try{
            dAONotaEnvioSB.insertar(notaenvio);
            notaenvio = new Notaenvio(0,fecha);        
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "NotaEnvio.insertar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "NotaEnvio.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }            
        return "";
    }
    
     public String insertar_detalle(){
       try{
            dAONotaEnvioDetalleSB.insertar(dt);
            dt = new Notaenviodetalle(0);       
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "NotaEnvio.insertar_detalle", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "NotaEnvio.insertar_detalle",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                        
        return "";
    }
    
       
    public String buscarNotaEnvio(){
        try {
        Notaenvio notaCargadoDesdeBD = null;
        notaCargadoDesdeBD = dAONotaEnvioSB.buscarNotaEnvioxId(notaenvio);
        this.notaenvio = notaCargadoDesdeBD;
        return "";
         
        } catch (Exception e) {
           return null;
        }    
    }
    
    public String eliminaNotaEnvio(){
        try{
            dAONotaEnvioSB.elimina(notaenvio);
            notaenvio = new Notaenvio(0,fecha);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "NotaEnvio.eliminar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "NotaEnvio.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                        
        return "";
    }
    
    public String modificaNotaEnvio(){
        try{
            dAONotaEnvioSB.modifica(notaenvio);
            notaenvio = new Notaenvio(0,fecha);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "NotaEnvio.modificar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "NotaEnvio.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                        
        return "";
    }
    
     public String guardarDetalle(){
        listaDt.add(dt); 
        nuevoDetalle();
        return "";
    }
     
      public String nuevoDetalle(){
        dt = new Notaenviodetalle();
        return "";
    }
     
       public String guardarNota (){
           dAONotaEnvioSB.insertar(notaenvio); 
           
           for (Notaenviodetalle detalle : listaDt) { 
                notaenvio.setNotaenviodetalleList(listaDt);
                detalle.setIdNotaEnvio(notaenvio); 
                
                dAONotaEnvioDetalleSB.insertar(detalle);
                dAONotaEnvioSB.modifica(notaenvio);
           }        
           return "";
       }
       
        public String buscarNotaEnvio_deta(){
          try {
            Notaenviodetalle notadetaCargadoDesdeBD = null;
            notadetaCargadoDesdeBD = dAONotaEnvioDetalleSB.buscarNotaEnvioDetallexId(dt);
            this.dt = notadetaCargadoDesdeBD;
            return "";
            } catch (Exception e) {
                return null;
            }   
        }
        
      public String eliminaNota_deta(){
        try{
            dAONotaEnvioDetalleSB.elimina(dt);
            dt = new Notaenviodetalle(0); 
            return "";
         } catch (Exception e) {
           return null;
        }  
    }
    
    public String modificaNota_deta(){
        try {
            dAONotaEnvioDetalleSB.modifica(dt);
            dt = new Notaenviodetalle(0); 
            return "";
         } catch (Exception e) {
           return null;
        }  
    }
        
      public void cargardetallexidNota(Integer vcod){
         this.setListaDt(dAONotaEnvioDetalleSB.ListadoDetallexIdnotaenvio(vcod));
        } 
      
       public void filtrarDetalleNotaEnvio(int idnota){
         this.setListaDetallexNota(dAONotaEnvioDetalleSB.ListadoDetallexIdnotaenvio(idnota));        
    }        
}