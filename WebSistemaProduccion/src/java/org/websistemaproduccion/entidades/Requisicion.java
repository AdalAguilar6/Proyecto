/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "requisicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisicion.findAll", query = "SELECT r FROM Requisicion r"),
    @NamedQuery(name = "Requisicion.findByIdRequisicion", query = "SELECT r FROM Requisicion r WHERE r.idRequisicion = :idRequisicion"),
    @NamedQuery(name = "Requisicion.findByFecha", query = "SELECT r FROM Requisicion r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Requisicion.findByEstado", query = "SELECT r FROM Requisicion r WHERE r.estado = :estado"),
    @NamedQuery(name = "Requisicion.findByFechaDespacho", query = "SELECT r FROM Requisicion r WHERE r.fechaDespacho = :fechaDespacho")})
public class Requisicion implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRequisicion")
    @TableGenerator(name = "Requisicion_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secRequisicion")
    @Id @GeneratedValue(generator = "Requisicion_Gen")      
    private Integer idRequisicion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechaDespacho")
    @Temporal(TemporalType.DATE)
    private Date fechaDespacho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisicion")
    private List<Requisiciondetalle> requisiciondetalleList;
    @JoinColumn(name = "idOrden", referencedColumnName = "idOrden")
    @ManyToOne
    private Ordenproduccion idOrden;

    public Requisicion() {
    }

    public Requisicion(Integer idRequisicion, Date fecha, String estado, Date fechaDespacho) {
        this.idRequisicion = idRequisicion;
        this.fecha = fecha;
        this.estado = estado;
        this.fechaDespacho = fechaDespacho;
    }
    
    public Requisicion(Integer idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Integer getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(Integer idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(Date fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    @XmlTransient
    public List<Requisiciondetalle> getRequisiciondetalleList() {
        return requisiciondetalleList;
    }

    public void setRequisiciondetalleList(List<Requisiciondetalle> requisiciondetalleList) {
        this.requisiciondetalleList = requisiciondetalleList;
    }

    public Ordenproduccion getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Ordenproduccion idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequisicion != null ? idRequisicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicion)) {
            return false;
        }
        Requisicion other = (Requisicion) object;
        if ((this.idRequisicion == null && other.idRequisicion != null) || (this.idRequisicion != null && !this.idRequisicion.equals(other.idRequisicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idRequisicion;
    }
    
}
