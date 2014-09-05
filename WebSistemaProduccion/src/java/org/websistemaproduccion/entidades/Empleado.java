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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findEmpleadoxTipo", query = "SELECT e FROM Empleado e WHERE e.idPuesto.nombre LIKE :puesto and e.idEstado.nombre LIKE :estado and e.idPuesto.idDepto.nombre LIKE :depto"),   
    @NamedQuery(name = "Empleado.findEmpleadoxPuesto", query = "SELECT e FROM Empleado e WHERE e.idPuesto.nombre LIKE :puesto"),       
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEmpleado")
    @TableGenerator(name = "Empleado_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secEmpleado")
    @Id @GeneratedValue(generator = "Empleado_Gen")       
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "idEstado", referencedColumnName = "idTipo")
    @ManyToOne(optional = false)
    private Tipo idEstado;
    @JoinColumn(name = "idPuesto", referencedColumnName = "idPuesto")
    @ManyToOne(optional = false)
    private Puesto idPuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSupervisor")
    private List<Bobinafardo> bobinafardoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperario")
    private List<Bobinafardo> bobinafardoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVendedor")
    private List<Pedido> pedidoList;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String nombre, String apellido) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Tipo getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Tipo idEstado) {
        this.idEstado = idEstado;
    }

    public Puesto getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Puesto idPuesto) {
        this.idPuesto = idPuesto;
    }

    @XmlTransient
    public List<Bobinafardo> getBobinafardoList() {
        return bobinafardoList;
    }

    public void setBobinafardoList(List<Bobinafardo> bobinafardoList) {
        this.bobinafardoList = bobinafardoList;
    }

    @XmlTransient
    public List<Bobinafardo> getBobinafardoList1() {
        return bobinafardoList1;
    }

    public void setBobinafardoList1(List<Bobinafardo> bobinafardoList1) {
        this.bobinafardoList1 = bobinafardoList1;
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
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
}
