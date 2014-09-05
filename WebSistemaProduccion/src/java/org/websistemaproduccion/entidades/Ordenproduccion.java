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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "ordenproduccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenproduccion.findAll", query = "SELECT o FROM Ordenproduccion o"),
    @NamedQuery(name = "Ordenproduccion.findByIdOrden", query = "SELECT o FROM Ordenproduccion o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "Ordenproduccion.findByProceso", query = "SELECT o FROM Ordenproduccion o WHERE o.proceso = :proceso"),
    @NamedQuery(name = "Ordenproduccion.findByCorrelativo", query = "SELECT o FROM Ordenproduccion o WHERE o.correlativo = :correlativo"),
    @NamedQuery(name = "Ordenproduccion.findByFecha", query = "SELECT o FROM Ordenproduccion o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Ordenproduccion.findByObservacion", query = "SELECT o FROM Ordenproduccion o WHERE o.observacion = :observacion"),
    @NamedQuery(name = "Ordenproduccion.findByAncho", query = "SELECT o FROM Ordenproduccion o WHERE o.ancho = :ancho"),
    @NamedQuery(name = "Ordenproduccion.findByLargo", query = "SELECT o FROM Ordenproduccion o WHERE o.largo = :largo"),
    @NamedQuery(name = "Ordenproduccion.findByCalibre", query = "SELECT o FROM Ordenproduccion o WHERE o.calibre = :calibre"),
    @NamedQuery(name = "Ordenproduccion.findByEstadoOrden", query = "SELECT o FROM Ordenproduccion o WHERE o.estadoOrden = :estadoOrden"),
    @NamedQuery(name = "Ordenproduccion.findByEstadoProceso", query = "SELECT o FROM Ordenproduccion o WHERE o.estadoOrden = :estadoOrden and o.proceso = :proceso"),
    @NamedQuery(name = "Ordenproduccion.findByRodillo", query = "SELECT o FROM Ordenproduccion o WHERE o.rodillo = :rodillo"),
    @NamedQuery(name = "Ordenproduccion.findByRepeticiones", query = "SELECT o FROM Ordenproduccion o WHERE o.repeticiones = :repeticiones"),
    @NamedQuery(name = "Ordenproduccion.findByRollos", query = "SELECT o FROM Ordenproduccion o WHERE o.rollos = :rollos"),
    @NamedQuery(name = "Ordenproduccion.findByEmpaque", query = "SELECT o FROM Ordenproduccion o WHERE o.empaque = :empaque"),
    @NamedQuery(name = "Ordenproduccion.conteo", query = "SELECT count(o) FROM Ordenproduccion o WHERE o.proceso = :proceso"),
    @NamedQuery(name = "Ordenproduccion.findByRegistros", query = "SELECT o FROM Ordenproduccion o WHERE o.registros = :registros")})
public class Ordenproduccion implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOrden")
    @TableGenerator(name = "OrdenProd_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secOrdenProduccion")
    @Id @GeneratedValue(generator = "OrdenProd_Gen")      
    private Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "proceso")
    private String proceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correlativo")
    private int correlativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ancho")
    private float ancho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "largo")
    private Float largo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calibre")
    private float calibre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estadoOrden")
    private String estadoOrden;
    @Column(name = "rodillo")
    private Integer rodillo;
    @Column(name = "repeticiones")
    private Integer repeticiones;
    @Column(name = "rollos")
    private Integer rollos;
    @Column(name = "empaque")
    private Integer empaque;
    @Size(max = 45)
    @Column(name = "registros")
    private String registros;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrden")
    private List<Bobinafardo> bobinafardoList;
    @JoinColumn(name = "idTurno", referencedColumnName = "idTipo")
    @ManyToOne(optional = false)
    private Tipo idTurno;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido")
    @ManyToOne(optional = false)
    private Pedido idPedido;
    @JoinColumn(name = "idMaquina", referencedColumnName = "idMaquina")
    @ManyToOne(optional = false)
    private Maquina idMaquina;
    @OneToMany(mappedBy = "idOrden")
    private List<Requisicion> requisicionList;

    public Ordenproduccion() {
    }

    public Ordenproduccion(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Ordenproduccion(Integer idOrden, String proceso, int correlativo, Date fecha, String observacion, float ancho, float largo, float calibre, String estadoOrden, Integer rodillo, Integer repeticiones, Integer rollos, Integer empaque, String registros) {
        this.idOrden = idOrden;
        this.proceso = proceso;
        this.correlativo = correlativo;
        this.fecha = fecha;
        this.observacion = observacion;
        this.ancho = ancho;
        this.largo = largo;
        this.calibre = calibre;
        this.estadoOrden = estadoOrden;
        this.rodillo = rodillo;
        this.repeticiones = repeticiones;
        this.rollos = rollos;
        this.empaque = empaque;
        this.registros = registros;
    }    
    
    public Ordenproduccion(Integer idOrden, String proceso, int correlativo, Date fecha, float ancho, float calibre, String estadoOrden) {
        this.idOrden = idOrden;
        this.proceso = proceso;
        this.correlativo = correlativo;
        this.fecha = fecha;
        this.ancho = ancho;
        this.calibre = calibre;
        this.estadoOrden = estadoOrden;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public Float getLargo() {
        return largo;
    }

    public void setLargo(Float largo) {
        this.largo = largo;
    }

    public float getCalibre() {
        return calibre;
    }

    public void setCalibre(float calibre) {
        this.calibre = calibre;
    }

    public String getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(String estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public Integer getRodillo() {
        return rodillo;
    }

    public void setRodillo(Integer rodillo) {
        this.rodillo = rodillo;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Integer getRollos() {
        return rollos;
    }

    public void setRollos(Integer rollos) {
        this.rollos = rollos;
    }

    public Integer getEmpaque() {
        return empaque;
    }

    public void setEmpaque(Integer empaque) {
        this.empaque = empaque;
    }

    public String getRegistros() {
        return registros;
    }

    public void setRegistros(String registros) {
        this.registros = registros;
    }

    @XmlTransient
    public List<Bobinafardo> getBobinafardoList() {
        return bobinafardoList;
    }

    public void setBobinafardoList(List<Bobinafardo> bobinafardoList) {
        this.bobinafardoList = bobinafardoList;
    }

    public Tipo getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Tipo idTurno) {
        this.idTurno = idTurno;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Maquina getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Maquina idMaquina) {
        this.idMaquina = idMaquina;
    }

    @XmlTransient
    public List<Requisicion> getRequisicionList() {
        return requisicionList;
    }

    public void setRequisicionList(List<Requisicion> requisicionList) {
        this.requisicionList = requisicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenproduccion)) {
            return false;
        }
        Ordenproduccion other = (Ordenproduccion) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idOrden;
    }
    
}
