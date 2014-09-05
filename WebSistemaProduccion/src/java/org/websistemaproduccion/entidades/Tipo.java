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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t"),
    @NamedQuery(name = "Tipo.findByIdTipo", query = "SELECT t FROM Tipo t WHERE t.idTipo = :idTipo"),
    @NamedQuery(name = "Tipo.findByLetra", query = "SELECT t FROM Tipo t WHERE t.idTipo LIKE :letra"),
    @NamedQuery(name = "Tipo.findByNombre", query = "SELECT t FROM Tipo t WHERE t.nombre = :nombre")})
public class Tipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "idTipo")
    private String idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMaq")
    private List<Maquina> maquinaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Maquina> maquinaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurno")
    private List<Ordenproduccion> ordenproduccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepto")
    private List<Puesto> puestoList;
    @OneToMany(mappedBy = "idTroquelado")
    private List<Pedido> pedidoList;
    @OneToMany(mappedBy = "idSello")
    private List<Pedido> pedidoList1;
    @OneToMany(mappedBy = "idFuelle2")
    private List<Pedido> pedidoList2;
    @OneToMany(mappedBy = "idFuelle1")
    private List<Pedido> pedidoList3;
    @OneToMany(mappedBy = "idAdicional")
    private List<Pedido> pedidoList4;
    @OneToMany(mappedBy = "idTipoPersona")
    private List<Persona> personaList;
    @OneToMany(mappedBy = "idTipoPago")
    private List<Persona> personaList1;

    public Tipo() {
    }

    public Tipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public Tipo(String idTipo, String nombre) {
        this.idTipo = idTipo;
        this.nombre = nombre;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Maquina> getMaquinaList() {
        return maquinaList;
    }

    public void setMaquinaList(List<Maquina> maquinaList) {
        this.maquinaList = maquinaList;
    }

    @XmlTransient
    public List<Maquina> getMaquinaList1() {
        return maquinaList1;
    }

    public void setMaquinaList1(List<Maquina> maquinaList1) {
        this.maquinaList1 = maquinaList1;
    }

    @XmlTransient
    public List<Ordenproduccion> getOrdenproduccionList() {
        return ordenproduccionList;
    }

    public void setOrdenproduccionList(List<Ordenproduccion> ordenproduccionList) {
        this.ordenproduccionList = ordenproduccionList;
    }

    @XmlTransient
    public List<Puesto> getPuestoList() {
        return puestoList;
    }

    public void setPuestoList(List<Puesto> puestoList) {
        this.puestoList = puestoList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList1() {
        return pedidoList1;
    }

    public void setPedidoList1(List<Pedido> pedidoList1) {
        this.pedidoList1 = pedidoList1;
    }

    @XmlTransient
    public List<Pedido> getPedidoList2() {
        return pedidoList2;
    }

    public void setPedidoList2(List<Pedido> pedidoList2) {
        this.pedidoList2 = pedidoList2;
    }

    @XmlTransient
    public List<Pedido> getPedidoList3() {
        return pedidoList3;
    }

    public void setPedidoList3(List<Pedido> pedidoList3) {
        this.pedidoList3 = pedidoList3;
    }

    @XmlTransient
    public List<Pedido> getPedidoList4() {
        return pedidoList4;
    }

    public void setPedidoList4(List<Pedido> pedidoList4) {
        this.pedidoList4 = pedidoList4;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Persona> getPersonaList1() {
        return personaList1;
    }

    public void setPersonaList1(List<Persona> personaList1) {
        this.personaList1 = personaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
