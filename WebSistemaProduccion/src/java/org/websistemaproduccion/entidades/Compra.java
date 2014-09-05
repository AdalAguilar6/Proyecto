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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c order by c.fecha desc"),
    @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compra.findByFecha", query = "SELECT c FROM Compra c WHERE c.fecha = :fecha")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompra")
    @TableGenerator(name = "Compra_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secCompra")
    @Id @GeneratedValue(generator = "Compra_Gen")    
    private Integer idCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompra")
    private List<Compradetalle> compradetalleList;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(Integer idCompra, Date fecha) {
        this.idCompra = idCompra;
        this.fecha = fecha;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Persona idProveedor) {
        this.idProveedor = idProveedor;
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
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+ idCompra;
    }
    
}
