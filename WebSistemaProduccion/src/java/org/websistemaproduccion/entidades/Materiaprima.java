/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "materiaprima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiaprima.findAll", query = "SELECT m FROM Materiaprima m"),
    @NamedQuery(name = "Materiaprima.findByIdMateriaPrima", query = "SELECT m FROM Materiaprima m WHERE m.idMateriaPrima = :idMateriaPrima"),
    @NamedQuery(name = "Materiaprima.findByNombre", query = "SELECT m FROM Materiaprima m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Materiaprima.findByExistencia", query = "SELECT m FROM Materiaprima m WHERE m.existencia = :existencia")})
public class Materiaprima implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMateriaPrima")
    @TableGenerator(name = "MateriaPrima_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secMateriaPrima")
    @Id @GeneratedValue(generator = "MateriaPrima_Gen")        
    private Integer idMateriaPrima;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "existencia")
    private float existencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateriaPrima")
    private List<Requisiciondetalle> requisiciondetalleList;
    @JoinColumn(name = "idUnidadMedida", referencedColumnName = "idUnidadMedida")
    @ManyToOne(optional = false)
    private Unidadmedida idUnidadMedida;
    @JoinColumn(name = "idBodega", referencedColumnName = "idBodega")
    @ManyToOne(optional = false)
    private Bodega idBodega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateriaPrima")
    private List<Compradetalle> compradetalleList;

    public Materiaprima() {
    }

    public Materiaprima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public Materiaprima(Integer idMateriaPrima, String nombre, float existencia) {
        this.idMateriaPrima = idMateriaPrima;
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public Integer getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getExistencia() {
        return existencia;
    }

    public void setExistencia(float existencia) {
        this.existencia = existencia;
    }

    @XmlTransient
    public List<Requisiciondetalle> getRequisiciondetalleList() {
        return requisiciondetalleList;
    }

    public void setRequisiciondetalleList(List<Requisiciondetalle> requisiciondetalleList) {
        this.requisiciondetalleList = requisiciondetalleList;
    }

    public Unidadmedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Unidadmedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    @XmlTransient
    public List<Compradetalle> getCompradetalleList() {
        return compradetalleList;
    }

    public void setCompradetalleList(List<Compradetalle> compradetalleList) {
        this.compradetalleList = compradetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaPrima != null ? idMateriaPrima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiaprima)) {
            return false;
        }
        Materiaprima other = (Materiaprima) object;
        if ((this.idMateriaPrima == null && other.idMateriaPrima != null) || (this.idMateriaPrima != null && !this.idMateriaPrima.equals(other.idMateriaPrima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
