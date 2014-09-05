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
import org.websistemaproduccion.ejb.DAOMaquinaSB;
import org.websistemaproduccion.ejb.DAOTipoSB;
import org.websistemaproduccion.entidades.Maquina;
import org.websistemaproduccion.entidades.Tipo;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "maquinaControlador")
@SessionScoped
public class MaquinaControlador implements Serializable{
    @EJB
    private DAOTipoSB dAOTipoSB;
    @EJB
    private DAOMaquinaSB dAOMaquinaSB;
    private Maquina maquina;
    private List<Tipo> lista;
    private List<Tipo> listaTipoMaquinas;
    private List<Maquina> listaMaqActivasRE;
    private List<Maquina> listaMaqActivasEX;
    private List<Maquina> listaMaqActivasFL;
    private List<Maquina> listaMaqActivasCS;
    private List<Maquina> listaMaqActivasDB;    
    private List<Maquina> listaTodos;

    public MaquinaControlador() {
        maquina = new Maquina(0,"-");
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
    
    public String insertar(){
        try{
            dAOMaquinaSB.insertar(maquina);
            maquina = new Maquina(0,"-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Maquina.insertar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Maquina.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }            
        return "";
    }
    
    public String buscarMaquina(){
        Maquina maquinaCargadoDesdeBD = null;
        maquinaCargadoDesdeBD = dAOMaquinaSB.buscarMaquinaxId(maquina);
        this.maquina = maquinaCargadoDesdeBD;
        return "";
    }  
    
    public String eliminaMaquina(){
        try{
            dAOMaquinaSB.elimina(maquina);
            this.maquina = new Maquina(0, "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Maquina.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Maquina.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                        
        return "";
    }
    
    public String modificaMaquina(){
        try{
            dAOMaquinaSB.modifica(maquina);
            maquina = new Maquina(0, "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Maquina.modifica", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Maquina.modifica",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                        
        return "";
    }

    public List<Tipo> getLista() {
        lista = dAOTipoSB.buscarTipoxLetra("E");
        return lista;
    }

    public void setLista(List<Tipo> lista) {
        this.lista = lista;
    }

    public List<Tipo> getListaTipoMaquinas() {
        listaTipoMaquinas = dAOTipoSB.buscarTipoxLetra("M");
        return listaTipoMaquinas;
    }

    public void setListaTipoMaquinas(List<Tipo> listaTipoMaquinas) {
        this.listaTipoMaquinas = listaTipoMaquinas;
    }

    public List<Maquina> getListaTodos() {
        listaTodos = dAOMaquinaSB.listarTodos();
        return listaTodos;
    }

    public List<Maquina> getListaMaqActivasRE() {
        listaMaqActivasRE = dAOMaquinaSB.buscarMaquinaxTipoxEstado("E00001", "RE");
        return listaMaqActivasRE;
    }

    public List<Maquina> getListaMaqActivasEX() {
        listaMaqActivasEX = dAOMaquinaSB.buscarMaquinaxTipoxEstado("E00001", "EX");
        return listaMaqActivasEX;
    }

    public List<Maquina> getListaMaqActivasFL() {
        listaMaqActivasFL = dAOMaquinaSB.buscarMaquinaxTipoxEstado("E00001", "FL");
        return listaMaqActivasFL;
    }

    public List<Maquina> getListaMaqActivasCS() {
        listaMaqActivasCS = dAOMaquinaSB.buscarMaquinaxTipoxEstado("E00001", "CO");
        return listaMaqActivasCS;
    }

    public List<Maquina> getListaMaqActivasDB() {
        listaMaqActivasDB = dAOMaquinaSB.buscarMaquinaxTipoxEstado("E00001", "DO");
        return listaMaqActivasDB;
    }
}
