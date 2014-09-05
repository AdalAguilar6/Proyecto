/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "requisiciondetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisiciondetalle.findAll", query = "SELECT r FROM Requisiciondetalle r"),
    @NamedQuery(name = "Requisiciondetalle.conteo", query = "SELECT count(r) FROM Requisiciondetalle r"),
    @NamedQuery(name = "Requisiciondetalle.findByIdRequisicionDetalle", query = "SELECT r FROM Requisiciondetalle r WHERE r.idRequisicionDetalle = :idRequisicionDetalle"),
    @NamedQuery(name = "Requisiciondetalle.findByIdRequisicion", query = "SELECT r FROM Requisiciondetalle r WHERE r.idRequisicion.idRequisicion = :idRequisicion"),    
    @NamedQuery(name = "Requisiciondetalle.findByCantidad", query = "SELECT r FROM Requisiciondetalle r WHERE r.cantidad = :cantidad")})
public class Requisiciondetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRequisicionDetalle")
    @TableGenerator(name = "RequiDet_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secRequisicionDetalle")
    @Id @GeneratedValue(generator = "RequiDet_Gen")          
    private Integer idRequisicionDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @JoinColumn(name = "idRequisicion", referencedColumnName = "idRequisicion")
    @ManyToOne(optional = false)
    private Requisicion idRequisicion;
    @JoinColumn(name = "idMateriaPrima", referencedColumnName = "idMateriaPrima")
    @ManyToOne(optional = false)
    private Materiaprima idMateriaPrima;

    public Requisiciondetalle() {
    }

    public Requisiciondetalle(Integer idRequisicionDetalle) {
        this.idRequisicionDetalle = idRequisicionDetalle;
    }

    public Requisiciondetalle(Integer idRequisicionDetalle, float cantidad) {
        this.idRequisicionDetalle = idRequisicionDetalle;
        this.cantidad = cantidad;
    }

    public Integer getIdRequisicionDetalle() {
        return idRequisicionDetalle;
    }

    public void setIdRequisicionDetalle(Integer idRequisicionDetalle) {
        this.idRequisicionDetalle = idRequisicionDetalle;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Requisicion getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(Requisicion idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Materiaprima getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Materiaprima idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequisicionDetalle != null ? idRequisicionDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisiciondetalle)) {
            return false;
        }
        Requisiciondetalle other = (Requisiciondetalle) object;
        if ((this.idRequisicionDetalle == null && other.idRequisicionDetalle != null) || (this.idRequisicionDetalle != null && !this.idRequisicionDetalle.equals(other.idRequisicionDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idRequisicionDetalle + " ]";
    }
    
}
