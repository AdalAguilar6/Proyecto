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
import org.websistemaproduccion.ejb.DAOPersonaSB;
import org.websistemaproduccion.ejb.DAOTipoSB;
import org.websistemaproduccion.entidades.Persona;
import org.websistemaproduccion.entidades.Tipo;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "personaControlador")
@SessionScoped
public class PersonaControlador implements Serializable{
    @EJB
    private DAOTipoSB dAOTipoSB;
    @EJB
    private DAOPersonaSB dAOPersonaSB;
    private Persona persona;
    private Boolean checkCliente;
    private Boolean checkProveedor;    
    private List<Tipo> listaTipoPersona;
    private List<Tipo> listaTipoPago;
    private List<Persona> listaTodos;
    
    
    public PersonaControlador() {
        persona = new Persona(0, "-", "-", "-", "-", "-", 1, 1);
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String insertar(){
        try{
            if (checkCliente) {
                persona.setCliente(1);
            } else {
                persona.setCliente(0);
            }

            if (checkProveedor) {
                persona.setProveedor(1);
            } else {
                persona.setProveedor(0);
            }
            dAOPersonaSB.insertar(persona);
            persona = new Persona(0, "-", "-", "-", "-", "-", 1, 1);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Persona.insertar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Persona.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                              
        return "";
    }
    
    public String buscarPersona(){
        Persona empDesdeBD = null;
        empDesdeBD = dAOPersonaSB.buscarPersonaxId(persona);
        this.persona = empDesdeBD;
        return "";
    }
    
    public String eliminaPersona(){
        try{
            dAOPersonaSB.elimina(persona);
            persona = new Persona(0, "-", "-", "-", "-", "-", 1, 1);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Persona.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Persona.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }               
        return "";
    }
    
    public String modificaPersona(){
        try{
            if (checkCliente) {
                persona.setCliente(1);
            } else {
                persona.setCliente(0);
            }

            if (checkProveedor) {
                persona.setProveedor(1);
            } else {
                persona.setProveedor(0);
            }        
            dAOPersonaSB.modifica(persona);
            persona = new Persona(0, "-", "-", "-", "-", "-", 1, 1);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Persona.modificar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Persona.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }               
        return "";
    }    

    public Boolean getCheckCliente() {
        if (persona.getCliente().equals(new Integer(1))) {
            checkCliente = true;
        } else {
            checkCliente = false;
        }           
        return checkCliente;
    }

    public void setCheckCliente(Boolean checkCliente) {
        this.checkCliente = checkCliente;
    }

    public Boolean getCheckProveedor() {
        if (persona.getProveedor().equals(new Integer(1))) {
            checkProveedor = true;
        } else {
            checkProveedor = false;
        }           
        return checkProveedor;
    }

    public void setCheckProveedor(Boolean checkProveedor) {
        this.checkProveedor = checkProveedor;
    }

    public List<Tipo> getListaTipoPersona() {
        listaTipoPersona = dAOTipoSB.buscarTipoxLetra("PER");        
        return listaTipoPersona;
    }

    public void setListaTipoPersona(List<Tipo> listaTipoPersona) {
        this.listaTipoPersona = listaTipoPersona;
    }

    public List<Tipo> getListaTipoPago() {
        listaTipoPago = dAOTipoSB.buscarTipoxLetra("P0");
        return listaTipoPago;
    }

    public void setListaTipoPago(List<Tipo> listaTipoPago) {
        this.listaTipoPago = listaTipoPago;
    }

    public List<Persona> getListaTodos() {
        listaTodos = dAOPersonaSB.listarTodos();
        return listaTodos;
    }

    public void setListaTodos(List<Persona> listaTodos) {
        this.listaTodos = listaTodos;
    }
}
