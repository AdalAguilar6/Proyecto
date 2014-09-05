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
@Table(name = "unidadmedida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidadmedida.findAll", query = "SELECT u FROM Unidadmedida u"),
    @NamedQuery(name = "Unidadmedida.findByIdUnidadMedida", query = "SELECT u FROM Unidadmedida u WHERE u.idUnidadMedida = :idUnidadMedida"),
    @NamedQuery(name = "Unidadmedida.findByNombre", query = "SELECT u FROM Unidadmedida u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Unidadmedida.findByAbreviatura", query = "SELECT u FROM Unidadmedida u WHERE u.abreviatura = :abreviatura")})
public class Unidadmedida implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUnidadMedida")
    @TableGenerator(name = "UnidMed_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secUnidadMedida")
    @Id @GeneratedValue(generator = "UnidMed_Gen")      
    private Integer idUnidadMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "abreviatura")
    private String abreviatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedida")
    private List<Materiaprima> materiaprimaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUniadMedida")
    private List<Pedido> pedidoList;

    public Unidadmedida() {
    }

    public Unidadmedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public Unidadmedida(Integer idUnidadMedida, String nombre, String abreviatura) {
        this.idUnidadMedida = idUnidadMedida;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @XmlTransient
    public List<Materiaprima> getMateriaprimaList() {
        return materiaprimaList;
    }

    public void setMateriaprimaList(List<Materiaprima> materiaprimaList) {
        this.materiaprimaList = materiaprimaList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadMedida != null ? idUnidadMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadmedida)) {
            return false;
        }
        Unidadmedida other = (Unidadmedida) object;
        if ((this.idUnidadMedida == null && other.idUnidadMedida != null) || (this.idUnidadMedida != null && !this.idUnidadMedida.equals(other.idUnidadMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
