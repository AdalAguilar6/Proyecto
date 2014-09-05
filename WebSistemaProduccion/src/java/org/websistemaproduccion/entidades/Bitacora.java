/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "bitacora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b"),
    @NamedQuery(name = "Bitacora.findByIdBitacora", query = "SELECT b FROM Bitacora b WHERE b.idBitacora = :idBitacora"),
    @NamedQuery(name = "Bitacora.findByFechaModifica", query = "SELECT b FROM Bitacora b WHERE b.fechaModifica = :fechaModifica"),
    @NamedQuery(name = "Bitacora.findByTipoAccion", query = "SELECT b FROM Bitacora b WHERE b.tipoAccion = :tipoAccion"),
    @NamedQuery(name = "Bitacora.findByTabla", query = "SELECT b FROM Bitacora b WHERE b.tabla = :tabla"),
    @NamedQuery(name = "Bitacora.findByRegistro", query = "SELECT b FROM Bitacora b WHERE b.registro = :registro")})
public class Bitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBitacora")
    private Integer idBitacora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaModifica")
    @Temporal(TemporalType.DATE)
    private Date fechaModifica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoAccion")
    private String tipoAccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tabla")
    private String tabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "registro")
    private String registro;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Bitacora() {
    }

    public Bitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Bitacora(Integer idBitacora, Date fechaModifica, String tipoAccion, String tabla, String registro) {
        this.idBitacora = idBitacora;
        this.fechaModifica = fechaModifica;
        this.tipoAccion = tipoAccion;
        this.tabla = tabla;
        this.registro = registro;
    }

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.websistemaproduccion.entidades.Bitacora[ idBitacora=" + idBitacora + " ]";
    }
    
}
