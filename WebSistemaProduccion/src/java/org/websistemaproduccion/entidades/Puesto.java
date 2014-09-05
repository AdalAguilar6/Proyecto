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
@Table(name = "puesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p"),
    @NamedQuery(name = "Puesto.findByIdPuesto", query = "SELECT p FROM Puesto p WHERE p.idPuesto = :idPuesto"),
    @NamedQuery(name = "Puesto.findByNombre", query = "SELECT p FROM Puesto p WHERE p.nombre = :nombre")})
public class Puesto implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPuesto")
    @TableGenerator(name = "Puesto_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secPuesto")
    @Id @GeneratedValue(generator = "Puesto_Gen")        
    private Integer idPuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuesto")
    private List<Empleado> empleadoList;
    @JoinColumn(name = "idDepto", referencedColumnName = "idTipo")
    @ManyToOne(optional = false)
    private Tipo idDepto;

    public Puesto() {
    }

    public Puesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public Puesto(Integer idPuesto, String nombre) {
        this.idPuesto = idPuesto;
        this.nombre = nombre;
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Tipo getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Tipo idDepto) {
        this.idDepto = idDepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuesto != null ? idPuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.idPuesto == null && other.idPuesto != null) || (this.idPuesto != null && !this.idPuesto.equals(other.idPuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
