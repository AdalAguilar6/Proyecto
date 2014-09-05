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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "notaenviodetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notaenviodetalle.findAll", query = "SELECT n FROM Notaenviodetalle n"),
    @NamedQuery(name = "Notaenviodetalle.findIdNotaEnvio", query = "SELECT n FROM Notaenviodetalle n WHERE n.idNotaEnvio.idNotaEnvio = :idNotaEnvio"),
    @NamedQuery(name = "Notaenviodetalle.findByIdNotaEnvioDet", query = "SELECT n FROM Notaenviodetalle n WHERE n.idNotaEnvioDet = :idNotaEnvioDet")})
public class Notaenviodetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNotaEnvioDet")
    @TableGenerator(name = "NotaEnvioDet_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secNotaEnvioDetalle")
    @Id @GeneratedValue(generator = "NotaEnvioDet_Gen")        
    private Integer idNotaEnvioDet;
    @JoinColumn(name = "idBobinaFardo", referencedColumnName = "idBobinaFardo")
    @ManyToOne(optional = false)
    private Bobinafardo idBobinaFardo;
    @JoinColumn(name = "idNotaEnvio", referencedColumnName = "idNotaEnvio")
    @ManyToOne(optional = false)
    private Notaenvio idNotaEnvio;

    public Notaenviodetalle() {
    }

    public Notaenviodetalle(Integer idNotaEnvioDet) {
        this.idNotaEnvioDet = idNotaEnvioDet;
    }

    public Integer getIdNotaEnvioDet() {
        return idNotaEnvioDet;
    }

    public void setIdNotaEnvioDet(Integer idNotaEnvioDet) {
        this.idNotaEnvioDet = idNotaEnvioDet;
    }

    public Bobinafardo getIdBobinaFardo() {
        return idBobinaFardo;
    }

    public void setIdBobinaFardo(Bobinafardo idBobinaFardo) {
        this.idBobinaFardo = idBobinaFardo;
    }

    public Notaenvio getIdNotaEnvio() {
        return idNotaEnvio;
    }

    public void setIdNotaEnvio(Notaenvio idNotaEnvio) {
        this.idNotaEnvio = idNotaEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaEnvioDet != null ? idNotaEnvioDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notaenviodetalle)) {
            return false;
        }
        Notaenviodetalle other = (Notaenviodetalle) object;
        if ((this.idNotaEnvioDet == null && other.idNotaEnvioDet != null) || (this.idNotaEnvioDet != null && !this.idNotaEnvioDet.equals(other.idNotaEnvioDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.websistemaproduccion.entidades.Notaenviodetalle[ idNotaEnvioDet=" + idNotaEnvioDet + " ]";
    }
    
}
