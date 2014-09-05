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
import org.websistemaproduccion.ejb.DAOPuestoSB;
import org.websistemaproduccion.ejb.DAOTipoSB;
import org.websistemaproduccion.entidades.Puesto;
import org.websistemaproduccion.entidades.Tipo;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "puestoControlador")
@SessionScoped
public class PuestoControlador implements Serializable{
    @EJB
    private DAOTipoSB dAOTipoSB;
    @EJB
    private DAOPuestoSB dAOPuestoSB;
    private Puesto puesto;
    private List<Puesto> lista;
    private Puesto selectedPuesto;
    private List<Tipo> listaDepto;

    public PuestoControlador() {
        puesto = new Puesto(0,"-");
        //lista= new ArrayList<Puesto>();
    }
    
    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
    public String insertar(){
        try{
            dAOPuestoSB.insertar(puesto);
            puesto = new Puesto(0,"-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Puesto.insertar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Puesto.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                                   
        return "";
    }
    
    public String buscarPuesto(){
        Puesto PuestoCargadoDesdeBD = null;
        PuestoCargadoDesdeBD = dAOPuestoSB.buscarPuestoxId(puesto);
        this.puesto = PuestoCargadoDesdeBD;
        return "";
    }
   
    public String eliminaPuesto(){
        try{
            dAOPuestoSB.elimina(puesto);
            this.puesto = new Puesto(0, "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Puesto.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Puesto.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                              
        return "";
    }
    
    public String modificaPuesto(){
        try{
            dAOPuestoSB.modifica(puesto);
            puesto = new Puesto(0, "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Puesto.modificar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Puesto.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                              
        return "";
    }

    public List<Puesto> getLista() {
        lista = dAOPuestoSB.buscarPuestoTodas();
        return lista;
    }

    public void setLista(List<Puesto> lista) {
        this.lista = lista;
    }

    public Puesto getSelectedPuesto() {
        return selectedPuesto;
    }

    public void setSelectedPuesto(Puesto selectedPuesto) {
        this.selectedPuesto = selectedPuesto;
    }

    public List<Tipo> getListaDepto() {
        listaDepto = dAOTipoSB.buscarTipoxLetra("D");
        return listaDepto;
    }

    public void setListaDepto(List<Tipo> listaDepto) {
        this.listaDepto = listaDepto;
    }
}
