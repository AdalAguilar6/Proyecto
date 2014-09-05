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
import org.websistemaproduccion.ejb.DAOEmpleadoSB;
import org.websistemaproduccion.ejb.DAOTipoSB;
import org.websistemaproduccion.entidades.Empleado;
import org.websistemaproduccion.entidades.Tipo;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name= "empleadoControlador")
@SessionScoped
public class EmpleadoControlador implements Serializable{
    @EJB
    private DAOTipoSB dAOTipoSB;
    @EJB
    private DAOEmpleadoSB dAOEmpleadoSB;
    private Empleado empleado;
    private List<Tipo> lista;
    private List<Empleado> listaEmpleados;
    private List<Empleado> listaTodos;
    private List<Empleado> listaSuperActivoRE;
    private List<Empleado> listaSuperActivoEX;
    private List<Empleado> listaSuperActivoFL;
    private List<Empleado> listaSuperActivoCS;
    private List<Empleado> listaSuperActivoDB;        
    private List<Empleado> listaOperActivoRE;
    private List<Empleado> listaOperActivoEX;
    private List<Empleado> listaOperActivoFL;
    private List<Empleado> listaOperActivoCS;
    private List<Empleado> listaOperActivoDB;        
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EmpleadoControlador() {
        empleado = new Empleado(0,"-","-");
    }
    
    public String insertar(){
        try{
            dAOEmpleadoSB.insertar(empleado);
            empleado = new Empleado(0,"-","-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Empleado.insertar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Empleado.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
        return "";
    }
    
    public String buscarEmpleado(){
        Empleado empleadoCargadoDesdeBD = null;
        empleadoCargadoDesdeBD = dAOEmpleadoSB.buscarEmpleadoxId(empleado);
        this.empleado = empleadoCargadoDesdeBD;
        return "";
    }
    
    public String eliminaEmpleado(){
        try{
            dAOEmpleadoSB.elimina(empleado);
            this.empleado = new Empleado(0, "-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Empleado.eliminar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Empleado.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }            
        return "";
    }
    
    public String modificaEmpleado(){
        try{
            dAOEmpleadoSB.modifica(empleado);
            this.empleado = new Empleado(0, "-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Empleado.modificar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Empleado.modificar",  e.getMessage());
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

    public List<Empleado> getListaEmpleados() {
        listaEmpleados = dAOEmpleadoSB.buscarTipoPuesto("VENDEDOR");
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Empleado> getListaTodos() {
        listaTodos = dAOEmpleadoSB.listarTodos();
        return listaTodos;
    }

    public void setListaTodos(List<Empleado> listaTodos) {
        this.listaTodos = listaTodos;
    }

    public List<Empleado> getListaSuperActivoRE() {
        listaSuperActivoRE = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "RE", "SUPER");
        return listaSuperActivoRE;
    }

    public List<Empleado> getListaSuperActivoEX() {
        listaSuperActivoEX = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "EX", "SUPER");
        return listaSuperActivoEX;
    }

    public List<Empleado> getListaSuperActivoFL() {
        listaSuperActivoFL = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "FL", "SUPER");
        return listaSuperActivoFL;
    }

    public List<Empleado> getListaSuperActivoCS() {
        listaSuperActivoCS = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "CS", "SUPER");
        return listaSuperActivoCS;
    }

    public List<Empleado> getListaSuperActivoDB() {
        listaSuperActivoDB = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "DB", "SUPER");
        return listaSuperActivoDB;
    }

    public List<Empleado> getListaOperActivoRE() {
        listaOperActivoRE = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "RE", "OPER");
        return listaOperActivoRE;
    }

    public List<Empleado> getListaOperActivoEX() {
        listaOperActivoEX = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "EX", "OPER");
        return listaOperActivoEX;
    }

    public List<Empleado> getListaOperActivoFL() {
        listaOperActivoFL = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "FL", "OPER");
        return listaOperActivoFL;
    }

    public List<Empleado> getListaOperActivoCS() {
        listaOperActivoCS = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "CS", "OPER");
        return listaOperActivoCS;
    }

    public List<Empleado> getListaOperActivoDB() {
        listaOperActivoDB = dAOEmpleadoSB.buscarEmpEstadoTipo("ACT", "DB", "OPER");
        return listaOperActivoDB;
    }
}
