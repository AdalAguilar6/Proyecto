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
import org.websistemaproduccion.ejb.DAORequisicionDetalleSB;
import org.websistemaproduccion.entidades.Requisiciondetalle;

/**
 *
 * @author Super Usuario
 */
@ManagedBean
@SessionScoped
public class RequisiciondetalleControlador implements Serializable{
    @EJB
    private DAORequisicionDetalleSB dAORequisicionDetalleSB;
    private Requisiciondetalle requisiciondetalle;

    public RequisiciondetalleControlador() {
        requisiciondetalle = new Requisiciondetalle(0,0);
    }

    public Requisiciondetalle getRequisiciondetalle() {
        return requisiciondetalle;
    }

    public void setRequisiciondetalle(Requisiciondetalle requisiciondetalle) {
        this.requisiciondetalle = requisiciondetalle;
    }
    
    public String insertar(){
        dAORequisicionDetalleSB.insertar(requisiciondetalle);
        requisiciondetalle = new Requisiciondetalle(0,0);
        return "";
    }
    
    public String buscarRequisicionDetalle(){
        Requisiciondetalle compraDetCargadoDesdeBD = null;
        compraDetCargadoDesdeBD = dAORequisicionDetalleSB.buscarRequisicionDetallexId(requisiciondetalle);
        this.requisiciondetalle = compraDetCargadoDesdeBD;
        return "";
    }
    
    public String eliminaRequisicionDetalle(){
        dAORequisicionDetalleSB.elimina(requisiciondetalle);
        this.requisiciondetalle = new Requisiciondetalle(0, 0);
        return "";
    }
    
    public String modificaRequisicionDetalle(){
        dAORequisicionDetalleSB.modifica(requisiciondetalle);
        requisiciondetalle = new Requisiciondetalle(0,0);
        return "";
    }
}
