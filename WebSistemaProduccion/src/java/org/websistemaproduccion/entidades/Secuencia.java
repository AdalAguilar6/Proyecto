/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Super Usuario
 */
@Entity
@Table(name = "secuencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secuencia.findAll", query = "SELECT s FROM Secuencia s"),
    @NamedQuery(name = "Secuencia.findBySecuenciaNombre", query = "SELECT s FROM Secuencia s WHERE s.secuenciaPK.secuenciaNombre = :secuenciaNombre"),
    @NamedQuery(name = "Secuencia.findBySecuenciaValor", query = "SELECT s FROM Secuencia s WHERE s.secuenciaPK.secuenciaValor = :secuenciaValor")})
public class Secuencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SecuenciaPK secuenciaPK;

    public Secuencia() {
    }

    public Secuencia(SecuenciaPK secuenciaPK) {
        this.secuenciaPK = secuenciaPK;
    }

    public Secuencia(String secuenciaNombre, int secuenciaValor) {
        this.secuenciaPK = new SecuenciaPK(secuenciaNombre, secuenciaValor);
    }

    public SecuenciaPK getSecuenciaPK() {
        return secuenciaPK;
    }

    public void setSecuenciaPK(SecuenciaPK secuenciaPK) {
        this.secuenciaPK = secuenciaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaPK != null ? secuenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secuencia)) {
            return false;
        }
        Secuencia other = (Secuencia) object;
        if ((this.secuenciaPK == null && other.secuenciaPK != null) || (this.secuenciaPK != null && !this.secuenciaPK.equals(other.secuenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.websistemaproduccion.entidades.Secuencia[ secuenciaPK=" + secuenciaPK + " ]";
    }
    
}
