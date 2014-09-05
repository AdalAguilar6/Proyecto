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
import org.websistemaproduccion.ejb.DAOMateriaPrimaSB;
import org.websistemaproduccion.entidades.Materiaprima;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "materiaprimaControlador")
@SessionScoped
public class MateriaprimaControlador implements Serializable{
    @EJB
    private DAOMateriaPrimaSB dAOMateriaPrimaSB;
    private Materiaprima materiaprima;
    private List<Materiaprima> listaTodos;

    public MateriaprimaControlador() {
        materiaprima = new Materiaprima(0,"-",0);
    }

    public String insertar(){
        try{
            dAOMateriaPrimaSB.insertar(materiaprima);
            materiaprima = new Materiaprima(0,"-",0);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "MateriaPrima.insertar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "MateriaPrima.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }              
        return "";
    }
    
    public String buscarMateriaPrima(){
        Materiaprima MPCargadoDesdeBD = null;
        MPCargadoDesdeBD = dAOMateriaPrimaSB.buscarMateriaPrimaxId(materiaprima);
        this.materiaprima = MPCargadoDesdeBD;
        return "";
    }
    
    public String eliminaMateriaPrima(){
        try{
            dAOMateriaPrimaSB.elimina(materiaprima);
            this.materiaprima = new Materiaprima(0, "-", 0);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "MateriaPrima.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "MateriaPrima.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                          
        return "";
    }
    
    public String modificaMateriaPrima(){
        try{
            dAOMateriaPrimaSB.modifica(materiaprima);
            materiaprima = new Materiaprima(0, "-", 0);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "MateriaPrima.modifica", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "MateriaPrima.modifica",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                          
        return "";
    }    

    public Materiaprima getMateriaprima() {
        return materiaprima;
    }

    public void setMateriaprima(Materiaprima materiaprima) {
        this.materiaprima = materiaprima;
    }

    public List<Materiaprima> getListaTodos() {
        listaTodos = dAOMateriaPrimaSB.listarTodos();
        return listaTodos;
    }

    public void setListaTodos(List<Materiaprima> listaTodos) {
        this.listaTodos = listaTodos;
    }
}
