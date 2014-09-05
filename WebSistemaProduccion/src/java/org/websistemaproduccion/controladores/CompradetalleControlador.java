/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.controladores;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.websistemaproduccion.ejb.DAOCompraDetalleSB;
import org.websistemaproduccion.entidades.Compra;
import org.websistemaproduccion.entidades.Compradetalle;


@ManagedBean
@SessionScoped
public class CompradetalleControlador implements Serializable{
    @EJB
    private DAOCompraDetalleSB dAOCompraDetalleSB;
    private Compradetalle compraDetalle;
    private Integer idCompra;
    private Compra compra;
    private List<Compradetalle> listaDetalleCompra;
       
    public CompradetalleControlador() {
         compraDetalle = new Compradetalle(0,0);
    }

    public Compradetalle getCompraDetalle() {
        return compraDetalle;
    }

    public void setCompraDetalle(Compradetalle compraDetalle) {
        this.compraDetalle = compraDetalle;
    }
    
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    public String insertar(){
        dAOCompraDetalleSB.insertar(compraDetalle);
        compraDetalle = new Compradetalle(0,0);
        return "";
    }
    
    public String buscarCompraDetalle(){
        Compradetalle compraDetCargadoDesdeBD = null;
        compraDetCargadoDesdeBD = dAOCompraDetalleSB.buscarCompraDetallexId(compraDetalle);
        this.compraDetalle = compraDetCargadoDesdeBD;
        return "";
    }
    
    public String eliminaCompraDetalle(){
        dAOCompraDetalleSB.elimina(compraDetalle);
        this.compraDetalle = new Compradetalle(0, 0);
        return "";
    }
    
    public String modificaCompraDetalle(){
        dAOCompraDetalleSB.modifica(compraDetalle);
        compraDetalle = new Compradetalle(0,0);
        return "";
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }  

    public List<Compradetalle> getListaDetalleCompra() {
        listaDetalleCompra = dAOCompraDetalleSB.listaDetalleCompra(idCompra);
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<Compradetalle> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }
}