/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Super Usuario
 */
@Embeddable
public class SecuenciaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "secuenciaNombre")
    private String secuenciaNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "secuenciaValor")
    private int secuenciaValor;

    public SecuenciaPK() {
    }

    public SecuenciaPK(String secuenciaNombre, int secuenciaValor) {
        this.secuenciaNombre = secuenciaNombre;
        this.secuenciaValor = secuenciaValor;
    }

    public String getSecuenciaNombre() {
        return secuenciaNombre;
    }

    public void setSecuenciaNombre(String secuenciaNombre) {
        this.secuenciaNombre = secuenciaNombre;
    }

    public int getSecuenciaValor() {
        return secuenciaValor;
    }

    public void setSecuenciaValor(int secuenciaValor) {
        this.secuenciaValor = secuenciaValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaNombre != null ? secuenciaNombre.hashCode() : 0);
        hash += (int) secuenciaValor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecuenciaPK)) {
            return false;
        }
        SecuenciaPK other = (SecuenciaPK) object;
        if ((this.secuenciaNombre == null && other.secuenciaNombre != null) || (this.secuenciaNombre != null && !this.secuenciaNombre.equals(other.secuenciaNombre))) {
            return false;
        }
        if (this.secuenciaValor != other.secuenciaValor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.websistemaproduccion.entidades.SecuenciaPK[ secuenciaNombre=" + secuenciaNombre + ", secuenciaValor=" + secuenciaValor + " ]";
    }
    
}
