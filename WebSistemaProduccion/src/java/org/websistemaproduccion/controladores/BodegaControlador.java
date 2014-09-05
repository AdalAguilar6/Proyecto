/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.controladores;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.websistemaproduccion.ejb.DAOBodegaSB;
import org.websistemaproduccion.entidades.Bodega;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "bodegaControlador")
@SessionScoped
public class BodegaControlador implements Serializable{
    @EJB
    private DAOBodegaSB dAOBodegaSB;
    private Bodega bodega;
    private List<Bodega> listaTodos;

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public BodegaControlador() {
        bodega = new Bodega(0,"-","-");
    }
    
    public String insertar(){
        try {
            dAOBodegaSB.insertar(bodega);
            bodega = new Bodega(0,"-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Bodega.insertar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Bodega.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
        return "";
    }
    
    public String buscarBodega(){
        Bodega bodegaCargadoDesdeBD = null;
        bodegaCargadoDesdeBD = dAOBodegaSB.buscarBodegaxId(bodega);
        this.bodega = bodegaCargadoDesdeBD;
        return "";
    }

    public String buscarBodegaCodigo(){
        Bodega bodegaCargadoDesdeBD = null;
        bodegaCargadoDesdeBD = dAOBodegaSB.buscarBodegaxCodigo(bodega);
        this.bodega = bodegaCargadoDesdeBD;
        return "";
    }
    
    public String eliminaBodega(){
        try{   
            dAOBodegaSB.elimina(bodega);
            this.bodega = new Bodega(0, "-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Bodega.eliminar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Bodega.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
        return "";
    }
    
    public String modificaBodega(){
        try{
            dAOBodegaSB.modifica(bodega);
            bodega = new Bodega(0, "-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Bodega.modificar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Bodega.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }    
        return "";
    }

    public List<Bodega> getListaTodos() {
        listaTodos = dAOBodegaSB.listarTodos();        
        return listaTodos;
    }

    public void setListaTodos(List<Bodega> listaTodos) {
        this.listaTodos = listaTodos;
    }
}
