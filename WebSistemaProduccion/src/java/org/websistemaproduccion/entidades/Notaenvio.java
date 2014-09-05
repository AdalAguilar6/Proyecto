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
@Table(name = "notaenvio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notaenvio.findAll", query = "SELECT n FROM Notaenvio n"),
    @NamedQuery(name = "Notaenvio.findByIdNotaEnvio", query = "SELECT n FROM Notaenvio n WHERE n.idNotaEnvio = :idNotaEnvio"),
    @NamedQuery(name = "Notaenvio.findByFechaDespacho", query = "SELECT n FROM Notaenvio n WHERE n.fechaDespacho = :fechaDespacho")})
public class Notaenvio implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNotaEnvio")
    @TableGenerator(name = "NotaEnvio_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secNotaEnvio")
    @Id @GeneratedValue(generator = "NotaEnvio_Gen")        
    private Integer idNotaEnvio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDespacho")
    @Temporal(TemporalType.DATE)
    private Date fechaDespacho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNotaEnvio")
    private List<Notaenviodetalle> notaenviodetalleList;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido")
    @ManyToOne(optional = false)
    private Pedido idPedido;

    public Notaenvio() {
    }

    public Notaenvio(Integer idNotaEnvio) {
        this.idNotaEnvio = idNotaEnvio;
    }

    public Notaenvio(Integer idNotaEnvio, Date fechaDespacho) {
        this.idNotaEnvio = idNotaEnvio;
        this.fechaDespacho = fechaDespacho;
    }

    public Integer getIdNotaEnvio() {
        return idNotaEnvio;
    }

    public void setIdNotaEnvio(Integer idNotaEnvio) {
        this.idNotaEnvio = idNotaEnvio;
    }

    public Date getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(Date fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    @XmlTransient
    public List<Notaenviodetalle> getNotaenviodetalleList() {
        return notaenviodetalleList;
    }

    public void setNotaenviodetalleList(List<Notaenviodetalle> notaenviodetalleList) {
        this.notaenviodetalleList = notaenviodetalleList;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaEnvio != null ? idNotaEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notaenvio)) {
            return false;
        }
        Notaenvio other = (Notaenvio) object;
        if ((this.idNotaEnvio == null && other.idNotaEnvio != null) || (this.idNotaEnvio != null && !this.idNotaEnvio.equals(other.idNotaEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idNotaEnvio;
    }
    
}
