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
@Table(name = "Bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findByIdBodega", query = "SELECT b FROM Bodega b WHERE b.idBodega = :idBodega"),
    @NamedQuery(name = "Bodega.findByCodigo", query = "SELECT b FROM Bodega b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "Bodega.findByNombre", query = "SELECT b FROM Bodega b WHERE b.nombre = :nombre")})
public class Bodega implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBodega")
    @TableGenerator(name = "Bodega_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secBodega")
    @Id @GeneratedValue(generator = "Bodega_Gen")    
    private Integer idBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBodega")
    private List<Bobinafardo> bobinafardoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBodega")
    private List<Materiaprima> materiaprimaList;

    public Bodega() {
    }

    public Bodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Bodega(Integer idBodega, String codigo, String nombre) {
        this.idBodega = idBodega;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Bobinafardo> getBobinafardoList() {
        return bobinafardoList;
    }

    public void setBobinafardoList(List<Bobinafardo> bobinafardoList) {
        this.bobinafardoList = bobinafardoList;
    }

    @XmlTransient
    public List<Materiaprima> getMateriaprimaList() {
        return materiaprimaList;
    }

    public void setMateriaprimaList(List<Materiaprima> materiaprimaList) {
        this.materiaprimaList = materiaprimaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
