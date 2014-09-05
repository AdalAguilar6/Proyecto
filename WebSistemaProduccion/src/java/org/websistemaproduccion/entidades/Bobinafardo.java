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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "bobinafardo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bobinafardo.findAll", query = "SELECT b FROM Bobinafardo b"),
    @NamedQuery(name = "Bobinafardo.findByIdBobinaFardo", query = "SELECT b FROM Bobinafardo b WHERE b.idBobinaFardo = :idBobinaFardo"),
    @NamedQuery(name = "Bobinafardo.findByPeso", query = "SELECT b FROM Bobinafardo b WHERE b.peso = :peso"),
    @NamedQuery(name = "Bobinafardo.findByCantidad", query = "SELECT b FROM Bobinafardo b WHERE b.cantidad = :cantidad"),
    @NamedQuery(name = "Bobinafardo.findByHoraInicio", query = "SELECT b FROM Bobinafardo b WHERE b.horaInicio = :horaInicio"),
    @NamedQuery(name = "Bobinafardo.findByHoraFinal", query = "SELECT b FROM Bobinafardo b WHERE b.horaFinal = :horaFinal"),
    @NamedQuery(name = "Bobinafardo.findByObservacion", query = "SELECT b FROM Bobinafardo b WHERE b.observacion = :observacion"),
    @NamedQuery(name = "Bobinafardo.findByIdBobinaFardoEntrada", query = "SELECT b FROM Bobinafardo b WHERE b.idBobinaFardoEntrada = :idBobinaFardoEntrada"),
    @NamedQuery(name = "Bobinafardo.findByPesoEntrada", query = "SELECT b FROM Bobinafardo b WHERE b.pesoEntrada = :pesoEntrada"),
    @NamedQuery(name = "Bobinafardo.conteoSecuencia", query = "SELECT COUNT(b) FROM Bobinafardo b WHERE b.idOrden.idOrden = :idOrden"),
    @NamedQuery(name = "Bobinafardo.findByIdOrden", query = "SELECT b FROM Bobinafardo b WHERE b.idOrden.idOrden = :idOrden"),  
    @NamedQuery(name = "Bobinafardo.findByEtapaAnt", query = "SELECT b FROM Bobinafardo b WHERE b.idOrden.proceso LIKE :etapaAnt and b.idOrden.idPedido.idPedido = :idPedido and b.idBodega.idBodega = :idBodega"),         
    @NamedQuery(name = "Bobinafardo.findBySecuencial", query = "SELECT b FROM Bobinafardo b WHERE b.secuencial = :secuencial")})
public class Bobinafardo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "idBobinaFardo")
    private String idBobinaFardo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private float peso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Float cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaFinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinal;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 100)
    @Column(name = "idBobinaFardoEntrada")
    private String idBobinaFardoEntrada;
    @Column(name = "pesoEntrada")
    private Float pesoEntrada;
    @Column(name = "secuencial")
    private Integer secuencial;
    @JoinColumn(name = "idOrden", referencedColumnName = "idOrden")
    @ManyToOne(optional = false)
    private Ordenproduccion idOrden;
    @JoinColumn(name = "idSupervisor", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado idSupervisor;
    @JoinColumn(name = "idOperario", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado idOperario;
    @JoinColumn(name = "idBodega", referencedColumnName = "idBodega")
    @ManyToOne(optional = false)
    private Bodega idBodega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBobinaFardo")
    private List<Notaenviodetalle> notaenviodetalleList;

    public Bobinafardo() {
    }

    public Bobinafardo(String idBobinaFardo) {
        this.idBobinaFardo = idBobinaFardo;
    }

    public Bobinafardo(String idBobinaFardo, float peso, float cantidad, Date horaInicio, Date horaFinal, String observacion, Integer secuencial) {
        this.idBobinaFardo = idBobinaFardo;
        this.peso = peso;
        this.cantidad = cantidad;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.observacion = observacion;
        this.secuencial = secuencial;
    }

    public Bobinafardo(String idBobinaFardo, float peso, Date horaInicio, Date horaFinal) {
        this.idBobinaFardo = idBobinaFardo;
        this.peso = peso;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public String getIdBobinaFardo() {
        return idBobinaFardo;
    }

    public void setIdBobinaFardo(String idBobinaFardo) {
        this.idBobinaFardo = idBobinaFardo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getIdBobinaFardoEntrada() {
        return idBobinaFardoEntrada;
    }

    public void setIdBobinaFardoEntrada(String idBobinaFardoEntrada) {
        this.idBobinaFardoEntrada = idBobinaFardoEntrada;
    }

    public Float getPesoEntrada() {
        return pesoEntrada;
    }

    public void setPesoEntrada(Float pesoEntrada) {
        this.pesoEntrada = pesoEntrada;
    }

    public Integer getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(Integer secuencial) {
        this.secuencial = secuencial;
    }

    public Ordenproduccion getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Ordenproduccion idOrden) {
        this.idOrden = idOrden;
    }

    public Empleado getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Empleado idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Empleado getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(Empleado idOperario) {
        this.idOperario = idOperario;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    @XmlTransient
    public List<Notaenviodetalle> getNotaenviodetalleList() {
        return notaenviodetalleList;
    }

    public void setNotaenviodetalleList(List<Notaenviodetalle> notaenviodetalleList) {
        this.notaenviodetalleList = notaenviodetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBobinaFardo != null ? idBobinaFardo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bobinafardo)) {
            return false;
        }
        Bobinafardo other = (Bobinafardo) object;
        if ((this.idBobinaFardo == null && other.idBobinaFardo != null) || (this.idBobinaFardo != null && !this.idBobinaFardo.equals(other.idBobinaFardo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idBobinaFardo;
    }
    
}
