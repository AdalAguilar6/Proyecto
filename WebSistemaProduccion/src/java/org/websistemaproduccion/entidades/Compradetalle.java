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
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
//import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "compradetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compradetalle.findAll", query = "SELECT c FROM Compradetalle c"),
    @NamedQuery(name = "Compradetalle.conteo", query = "SELECT count(c) FROM Compradetalle c"),
    @NamedQuery(name = "Compradetalle.findByIdCompra", query = "SELECT c FROM Compradetalle c WHERE c.idCompra.idCompra = :idCompra"),
    @NamedQuery(name = "Compradetalle.findByIdCompraDet", query = "SELECT c FROM Compradetalle c WHERE c.idCompraDet = :idCompraDet"),   
    @NamedQuery(name = "Compradetalle.findByCantidad", query = "SELECT c FROM Compradetalle c WHERE c.cantidad = :cantidad")})
public class Compradetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompraDet")
    @TableGenerator(name = "CompraDet_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secCompraDetalle")
    @Id @GeneratedValue(generator = "CompraDet_Gen")    
    private Integer idCompraDet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @JoinColumn(name = "idMateriaPrima", referencedColumnName = "idMateriaPrima")
    @ManyToOne(optional = false)
    private Materiaprima idMateriaPrima;
    @JoinColumn(name = "idCompra", referencedColumnName = "idCompra")
    @ManyToOne(optional = false)
    private Compra idCompra;

    public Compradetalle() {
    }

    public Compradetalle(Integer idCompraDet) {
        this.idCompraDet = idCompraDet;
    }

    public Compradetalle(Integer idCompraDet, float cantidad) {
        this.idCompraDet = idCompraDet;
        this.cantidad = cantidad;
    }

    public Integer getIdCompraDet() {
        return idCompraDet;
    }

    public void setIdCompraDet(Integer idCompraDet) {
        this.idCompraDet = idCompraDet;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Materiaprima getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Materiaprima idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraDet != null ? idCompraDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compradetalle)) {
            return false;
        }
        Compradetalle other = (Compradetalle) object;
        if ((this.idCompraDet == null && other.idCompraDet != null) || (this.idCompraDet != null && !this.idCompraDet.equals(other.idCompraDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.websistemaproduccion.entidades.Compradetalle[ idCompraDet=" + idCompraDet + " ]";
    }
    
}
