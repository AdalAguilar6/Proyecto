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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByRegistroFiscal", query = "SELECT p FROM Persona p WHERE p.registroFiscal = :registroFiscal"),
    @NamedQuery(name = "Persona.findByNrc", query = "SELECT p FROM Persona p WHERE p.nrc = :nrc"),
    @NamedQuery(name = "Persona.findByProveedor", query = "SELECT p FROM Persona p WHERE p.proveedor = :proveedor"),
    @NamedQuery(name = "Persona.findByCliente", query = "SELECT p FROM Persona p WHERE p.cliente = :cliente")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersona")
    @TableGenerator(name = "Persona_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secPersona")
    @Id @GeneratedValue(generator = "Persona_Gen")        
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "registroFiscal")
    private String registroFiscal;
    @Size(max = 45)
    @Column(name = "nrc")
    private String nrc;
    @Column(name = "proveedor")
    private Integer proveedor;
    @Column(name = "cliente")
    private Integer cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Pedido> pedidoList;
    @JoinColumn(name = "idTipoPersona", referencedColumnName = "idTipo")
    @ManyToOne
    private Tipo idTipoPersona;
    @JoinColumn(name = "idTipoPago", referencedColumnName = "idTipo")
    @ManyToOne
    private Tipo idTipoPago;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String nombre, String direccion, String telefono, String registroFiscal, String nrc, Integer proveedor, Integer cliente) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.registroFiscal = registroFiscal;
        this.nrc = nrc;
        this.proveedor = proveedor;
        this.cliente = cliente;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRegistroFiscal() {
        return registroFiscal;
    }

    public void setRegistroFiscal(String registroFiscal) {
        this.registroFiscal = registroFiscal;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Tipo getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Tipo idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public Tipo getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Tipo idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
