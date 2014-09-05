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
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pedido.findByFechaEntrega", query = "SELECT p FROM Pedido p WHERE p.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Pedido.findByDirecEntrega", query = "SELECT p FROM Pedido p WHERE p.direcEntrega = :direcEntrega"),
    @NamedQuery(name = "Pedido.findByObservacion", query = "SELECT p FROM Pedido p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Pedido.findByAprobado", query = "SELECT p FROM Pedido p WHERE p.aprobado = :aprobado and p.estado = :estado"),
    @NamedQuery(name = "Pedido.findByEstado", query = "SELECT p FROM Pedido p WHERE p.estado = :estado"),
    @NamedQuery(name = "Pedido.findByCantidad", query = "SELECT p FROM Pedido p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Pedido.findByAncho", query = "SELECT p FROM Pedido p WHERE p.ancho = :ancho"),
    @NamedQuery(name = "Pedido.findByLargo", query = "SELECT p FROM Pedido p WHERE p.largo = :largo"),
    @NamedQuery(name = "Pedido.findByCalibre", query = "SELECT p FROM Pedido p WHERE p.calibre = :calibre"),
    @NamedQuery(name = "Pedido.findByLibrasTotales", query = "SELECT p FROM Pedido p WHERE p.librasTotales = :librasTotales"),
    @NamedQuery(name = "Pedido.findByRefilado", query = "SELECT p FROM Pedido p WHERE p.refilado = :refilado"),
    @NamedQuery(name = "Pedido.findByDoblado", query = "SELECT p FROM Pedido p WHERE p.doblado = :doblado"),
    @NamedQuery(name = "Pedido.findByImpresa", query = "SELECT p FROM Pedido p WHERE p.impresa = :impresa"),
    @NamedQuery(name = "Pedido.findByTamanoAdicional", query = "SELECT p FROM Pedido p WHERE p.tamanoAdicional = :tamanoAdicional"),
    @NamedQuery(name = "Pedido.findByResistencia", query = "SELECT p FROM Pedido p WHERE p.resistencia = :resistencia"),
    @NamedQuery(name = "Pedido.findByTamanoFuelle1", query = "SELECT p FROM Pedido p WHERE p.tamanoFuelle1 = :tamanoFuelle1"),
    @NamedQuery(name = "Pedido.findByTamanoFuelle2", query = "SELECT p FROM Pedido p WHERE p.tamanoFuelle2 = :tamanoFuelle2"),
    @NamedQuery(name = "Pedido.findByPigmento", query = "SELECT p FROM Pedido p WHERE p.pigmento = :pigmento"),
    @NamedQuery(name = "Pedido.findByPrecioUnitario", query = "SELECT p FROM Pedido p WHERE p.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "Pedido.findByTipoTinta", query = "SELECT p FROM Pedido p WHERE p.tipoTinta = :tipoTinta"),
    @NamedQuery(name = "Pedido.findByImpresionFrente", query = "SELECT p FROM Pedido p WHERE p.impresionFrente = :impresionFrente"),
    @NamedQuery(name = "Pedido.findByImpresionDorso", query = "SELECT p FROM Pedido p WHERE p.impresionDorso = :impresionDorso"),
    @NamedQuery(name = "Pedido.findByImpresionUnaCara", query = "SELECT p FROM Pedido p WHERE p.impresionUnaCara = :impresionUnaCara"),
    @NamedQuery(name = "Pedido.findByImpresionDosCara", query = "SELECT p FROM Pedido p WHERE p.impresionDosCara = :impresionDosCara"),
    @NamedQuery(name = "Pedido.findByImpresionContinua", query = "SELECT p FROM Pedido p WHERE p.impresionContinua = :impresionContinua"),
    @NamedQuery(name = "Pedido.findByTextoImpreso", query = "SELECT p FROM Pedido p WHERE p.textoImpreso = :textoImpreso"),
    @NamedQuery(name = "Pedido.findByEstadoEtapa", query = "SELECT p FROM Pedido p WHERE p.estado = :estado and p.etapa = :etapa and p.aprobado = :aprobado"),
    @NamedQuery(name = "Pedido.findByEtapa", query = "SELECT p FROM Pedido p WHERE p.etapa = :etapa")})

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPedido")
    @TableGenerator(name = "Pedido_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secPedido")
    @Id @GeneratedValue(generator = "Pedido_Gen")       
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direcEntrega")
    private String direcEntrega;
    @Size(max = 250)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "aprobado")
    private Integer aprobado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ancho")
    private float ancho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "largo")
    private float largo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calibre")
    private float calibre;
    @Column(name = "librasTotales")
    private float librasTotales;
    @Column(name = "refilado")
    private Integer refilado;
    @Column(name = "doblado")
    private Integer doblado;
    @Column(name = "impresa")
    private Integer impresa;
    @Column(name = "tamanoAdicional")
    private float tamanoAdicional;
    @Size(max = 6)
    @Column(name = "resistencia")
    private String resistencia;
    @Column(name = "tamanoFuelle1")
    private float tamanoFuelle1;
    @Column(name = "tamanoFuelle2")
    private Float tamanoFuelle2;
    @Size(max = 45)
    @Column(name = "pigmento")
    private String pigmento;
    @Column(name = "precioUnitario")
    private float precioUnitario;
    @Size(max = 45)
    @Column(name = "tipoTinta")
    private String tipoTinta;
    @Column(name = "impresionFrente")
    private Integer impresionFrente;
    @Column(name = "impresionDorso")
    private Integer impresionDorso;
    @Column(name = "impresionUnaCara")
    private Integer impresionUnaCara;
    @Column(name = "impresionDosCara")
    private Integer impresionDosCara;
    @Column(name = "impresionContinua")
    private Integer impresionContinua;
    @Size(max = 250)
    @Column(name = "textoImpreso")
    private String textoImpreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "etapa")
    private String etapa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private List<Ordenproduccion> ordenproduccionList;
    @JoinColumn(name = "idUniadMedida", referencedColumnName = "idUnidadMedida")
    @ManyToOne(optional = false)
    private Unidadmedida idUniadMedida;
    @JoinColumn(name = "idTroquelado", referencedColumnName = "idTipo")
    @ManyToOne
    private Tipo idTroquelado;
    @JoinColumn(name = "idSello", referencedColumnName = "idTipo")
    @ManyToOne
    private Tipo idSello;
    @JoinColumn(name = "idFuelle2", referencedColumnName = "idTipo")
    @ManyToOne
    private Tipo idFuelle2;
    @JoinColumn(name = "idFuelle1", referencedColumnName = "idTipo")
    @ManyToOne
    private Tipo idFuelle1;
    @JoinColumn(name = "idAdicional", referencedColumnName = "idTipo")
    @ManyToOne
    private Tipo idAdicional;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "idCliente", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idCliente;
    @JoinColumn(name = "idVendedor", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado idVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private List<Notaenvio> notaenvioList;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, Date fecha, Date fechaEntrega, String direcEntrega, String observacion, String estado, String resistencia, String pigmento, String tipoTinta, String textoImpreso, String etapa, Integer refilado, Integer doblado, Integer impresa, Integer impresionFrente, Integer impresionDorso, Integer impresionUnaCara, Integer impresionDosCara, Integer impresionContinua, Integer aprobado,float cantidad,float ancho,float largo,float calibre,float librasTotales,float tamanoAdicional,float tamanoFuelle1,float tamanoFuelle2,float precioUnitario) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.direcEntrega = direcEntrega;
        this.observacion = observacion;
        this.estado = estado;
        this.resistencia = resistencia;
        this.pigmento = pigmento;
        this.tipoTinta = tipoTinta;
        this.textoImpreso = textoImpreso;
        this.etapa = etapa;
        this.refilado = refilado;
        this.doblado = doblado;
        this.impresa = impresa;
        this.impresionFrente = impresionFrente;
        this.impresionDorso = impresionDorso;
        this.impresionUnaCara = impresionUnaCara;
        this.impresionDosCara = impresionDosCara;
        this.impresionContinua = impresionContinua;
        this.aprobado = aprobado;
        this.cantidad = cantidad;
        this.ancho = ancho;
        this.largo = largo;
        this.calibre = calibre;
        this.librasTotales = librasTotales;
        this.tamanoAdicional = tamanoAdicional;
        this.tamanoFuelle1 = tamanoFuelle1;
        this.tamanoFuelle2 = tamanoFuelle2;
        this.precioUnitario = precioUnitario;
    }
    
    public Pedido(Integer idPedido, Date fecha, Date fechaEntrega, String direcEntrega, String estado, float cantidad, float ancho, float calibre, String etapa) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.direcEntrega = direcEntrega;
        this.estado = estado;
        this.cantidad = cantidad;
        this.ancho = ancho;
        this.calibre = calibre;
        this.etapa = etapa;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDirecEntrega() {
        return direcEntrega;
    }

    public void setDirecEntrega(String direcEntrega) {
        this.direcEntrega = direcEntrega;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getAprobado() {
        return aprobado;
    }

    public void setAprobado(Integer aprobado) {
        this.aprobado = aprobado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getCalibre() {
        return calibre;
    }

    public void setCalibre(float calibre) {
        this.calibre = calibre;
    }

    public float getLibrasTotales() {
        return librasTotales;
    }

    public void setLibrasTotales(float librasTotales) {
        this.librasTotales = librasTotales;
    }

    public Integer getRefilado() {
        return refilado;
    }

    public void setRefilado(Integer refilado) {
        this.refilado = refilado;
    }

    public Integer getDoblado() {
        return doblado;
    }

    public void setDoblado(Integer doblado) {
        this.doblado = doblado;
    }

    public Integer getImpresa() {
        return impresa;
    }

    public void setImpresa(Integer impresa) {
        this.impresa = impresa;
    }

    public float getTamanoAdicional() {
        return tamanoAdicional;
    }

    public void setTamanoAdicional(float tamanoAdicional) {
        this.tamanoAdicional = tamanoAdicional;
    }

    public String getResistencia() {
        return resistencia;
    }

    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }

    public float getTamanoFuelle1() {
        return tamanoFuelle1;
    }

    public void setTamanoFuelle1(float tamanoFuelle1) {
        this.tamanoFuelle1 = tamanoFuelle1;
    }

    public float getTamanoFuelle2() {
        return tamanoFuelle2;
    }

    public void setTamanoFuelle2(float tamanoFuelle2) {
        this.tamanoFuelle2 = tamanoFuelle2;
    }

    public String getPigmento() {
        return pigmento;
    }

    public void setPigmento(String pigmento) {
        this.pigmento = pigmento;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getTipoTinta() {
        return tipoTinta;
    }

    public void setTipoTinta(String tipoTinta) {
        this.tipoTinta = tipoTinta;
    }

    public Integer getImpresionFrente() {
        return impresionFrente;
    }

    public void setImpresionFrente(Integer impresionFrente) {
        this.impresionFrente = impresionFrente;
    }

    public Integer getImpresionDorso() {
        return impresionDorso;
    }

    public void setImpresionDorso(Integer impresionDorso) {
        this.impresionDorso = impresionDorso;
    }

    public Integer getImpresionUnaCara() {
        return impresionUnaCara;
    }

    public void setImpresionUnaCara(Integer impresionUnaCara) {
        this.impresionUnaCara = impresionUnaCara;
    }

    public Integer getImpresionDosCara() {
        return impresionDosCara;
    }

    public void setImpresionDosCara(Integer impresionDosCara) {
        this.impresionDosCara = impresionDosCara;
    }

    public Integer getImpresionContinua() {
        return impresionContinua;
    }

    public void setImpresionContinua(Integer impresionContinua) {
        this.impresionContinua = impresionContinua;
    }

    public String getTextoImpreso() {
        return textoImpreso;
    }

    public void setTextoImpreso(String textoImpreso) {
        this.textoImpreso = textoImpreso;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    @XmlTransient
    public List<Ordenproduccion> getOrdenproduccionList() {
        return ordenproduccionList;
    }

    public void setOrdenproduccionList(List<Ordenproduccion> ordenproduccionList) {
        this.ordenproduccionList = ordenproduccionList;
    }

    public Unidadmedida getIdUniadMedida() {
        return idUniadMedida;
    }

    public void setIdUniadMedida(Unidadmedida idUniadMedida) {
        this.idUniadMedida = idUniadMedida;
    }

    public Tipo getIdTroquelado() {
        return idTroquelado;
    }

    public void setIdTroquelado(Tipo idTroquelado) {
        this.idTroquelado = idTroquelado;
    }

    public Tipo getIdSello() {
        return idSello;
    }

    public void setIdSello(Tipo idSello) {
        this.idSello = idSello;
    }

    public Tipo getIdFuelle2() {
        return idFuelle2;
    }

    public void setIdFuelle2(Tipo idFuelle2) {
        this.idFuelle2 = idFuelle2;
    }

    public Tipo getIdFuelle1() {
        return idFuelle1;
    }

    public void setIdFuelle1(Tipo idFuelle1) {
        this.idFuelle1 = idFuelle1;
    }

    public Tipo getIdAdicional() {
        return idAdicional;
    }

    public void setIdAdicional(Tipo idAdicional) {
        this.idAdicional = idAdicional;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Persona getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Persona idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Empleado idVendedor) {
        this.idVendedor = idVendedor;
    }

    @XmlTransient
    public List<Notaenvio> getNotaenvioList() {
        return notaenvioList;
    }

    public void setNotaenvioList(List<Notaenvio> notaenvioList) {
        this.notaenvioList = notaenvioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idPedido;
    }
    
}
