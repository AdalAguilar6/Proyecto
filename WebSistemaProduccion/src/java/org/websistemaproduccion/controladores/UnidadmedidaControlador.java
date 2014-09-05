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
import org.websistemaproduccion.ejb.DAOUnidadMedidaSB;
import org.websistemaproduccion.entidades.Unidadmedida;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "unidadmedidaControlador")
@SessionScoped
public class UnidadmedidaControlador implements Serializable{
    @EJB
    private DAOUnidadMedidaSB dAOUnidadMedidaSB;
    private Unidadmedida unidadmedida;
    private List<Unidadmedida> listaTodos;    

    public UnidadmedidaControlador() {
        unidadmedida = new Unidadmedida(0,"-", "-");
    }
    
    public String insertar(){
        try{
            dAOUnidadMedidaSB.insertar(unidadmedida);
            unidadmedida = new Unidadmedida(0,"-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "UnidadMedida.insertar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "UnidadMedida.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }               
        return "";
    }
    
    public String buscarUnidad(){
        Unidadmedida unidadCargadoDesdeBD = null;
        unidadCargadoDesdeBD = dAOUnidadMedidaSB.buscarUnidadMedidaxId(unidadmedida);
        this.unidadmedida = unidadCargadoDesdeBD;
        return "";
    }
    
    public String eliminaUnidad(){
        try{
            dAOUnidadMedidaSB.elimina(unidadmedida);
            this.unidadmedida = new Unidadmedida(0,"-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "UnidadMedida.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "UnidadMedida.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }   
        return "";
    }
    
    public String modificaUnidad(){
        try{
            dAOUnidadMedidaSB.modifica(unidadmedida);
            unidadmedida = new Unidadmedida(0,"-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "UnidadMedida.modifica", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "UnidadMedida.modifica",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }               
        return "";
    } 

    public Unidadmedida getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(Unidadmedida unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public List<Unidadmedida> getListaTodos() {
        listaTodos = dAOUnidadMedidaSB.listarTodos();       
        return listaTodos;
    }

    public void setListaTodos(List<Unidadmedida> listaTodos) {
        this.listaTodos = listaTodos;
    }
}
