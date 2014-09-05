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
import org.websistemaproduccion.ejb.DAOTipoSB;
import org.websistemaproduccion.entidades.Tipo;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "tipoControlador")
@SessionScoped
public class TipoControlador implements Serializable{
    @EJB
    private DAOTipoSB dAOTipoSB;
    private Tipo tipo;
    private String letra;
    private List<Tipo> lista;
    private List<Tipo> listaTodos;

    public TipoControlador() {
        tipo = new Tipo("-","-");
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String insertar(){
        try{
            dAOTipoSB.insertar(tipo);
            tipo = new Tipo("-","-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Tipo.insertar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Tipo.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                        
        return "";
    }
    
    public String buscarTipoId(){
        Tipo bodegaCargadoDesdeBD = null;
        bodegaCargadoDesdeBD = dAOTipoSB.buscarTipoxId(tipo);
        this.tipo = bodegaCargadoDesdeBD;
        return "";
    }
    
    public String eliminaTipo(){
        try{
            dAOTipoSB.elimina(tipo);
            this.tipo = new Tipo("-","-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Tipo.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Tipo.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                                    
        return "";
    }
    
    public String modificaTipo(){
        try{
            dAOTipoSB.modifica(tipo);
            tipo = new Tipo("-","-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Tipo.modificar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Tipo.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                                    
        return "";
    }

    public List<Tipo> getLista() {
        lista = dAOTipoSB.buscarTipoxLetra(letra);
        return lista;
    }

    public void setLista(List<Tipo> lista) {
        this.lista = lista;
    }

    public List<Tipo> getListaTodos() {
        listaTodos = dAOTipoSB.listarTodos();
        return listaTodos;
    }

    public void setListaTodos(List<Tipo> listaTodos) {
        this.listaTodos = listaTodos;
    }
}
