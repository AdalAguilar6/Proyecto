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
import org.websistemaproduccion.ejb.DAOProductoSB;
import org.websistemaproduccion.entidades.Producto;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "productoControlador")
@SessionScoped
public class ProductoControlador implements Serializable{
    @EJB
    private DAOProductoSB dAOProductoSB;
    private Producto producto;
    private List<Producto> listaTodos;    

    public ProductoControlador() {
        producto = new Producto(0, "-");
    }
    
    public String insertar(){
        try{
            dAOProductoSB.insertar(producto);
            producto = new Producto(0,"-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Producto.insertar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Producto.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                       
        return "";
    }
    
    public String buscarProducto(){
        Producto productoCargadoDesdeBD = null;
        productoCargadoDesdeBD = dAOProductoSB.buscarProductoxId(producto);
        this.producto = productoCargadoDesdeBD;
        return "";
    }

    public String eliminaProducto(){
        try{
            dAOProductoSB.elimina(producto);
            this.producto = new Producto(0, "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Producto.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Producto.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                                   
        return "";
    }
    
    public String modificaProducto(){
        try{
            dAOProductoSB.modifica(producto);
            producto = new Producto(0, "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Producto.modificar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Producto.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                                   
        return "";
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaTodos() {
        listaTodos = dAOProductoSB.listarTodos();
        return listaTodos;
    }

    public void setListaTodos(List<Producto> listaTodos) {
        this.listaTodos = listaTodos;
    }
}
