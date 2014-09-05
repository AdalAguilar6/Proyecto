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
@Table(name = "maquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m"),
    @NamedQuery(name = "Maquina.MaquinaxTipoxEstado", query = "SELECT m FROM Maquina m WHERE m.idEstado.idTipo = :estado and m.idTipoMaq.nombre LIKE :tipomaquina"),
    @NamedQuery(name = "Maquina.findByIdMaquina", query = "SELECT m FROM Maquina m WHERE m.idMaquina = :idMaquina"),
    @NamedQuery(name = "Maquina.findByCodigo", query = "SELECT m FROM Maquina m WHERE m.codigo = :codigo")})
public class Maquina implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMaquina")
    @TableGenerator(name = "Maquina_Gen", table = "secuencia", pkColumnName = "secuenciaNombre", valueColumnName = "secuenciaValor", pkColumnValue= "secMaquina")
    @Id @GeneratedValue(generator = "Maquina_Gen")        
    private Integer idMaquina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "idTipoMaq", referencedColumnName = "idTipo")
    @ManyToOne(optional = false)
    private Tipo idTipoMaq;
    @JoinColumn(name = "idEstado", referencedColumnName = "idTipo")
    @ManyToOne(optional = false)
    private Tipo idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaquina")
    private List<Ordenproduccion> ordenproduccionList;

    public Maquina() {
    }

    public Maquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Maquina(Integer idMaquina, String codigo) {
        this.idMaquina = idMaquina;
        this.codigo = codigo;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Tipo getIdTipoMaq() {
        return idTipoMaq;
    }

    public void setIdTipoMaq(Tipo idTipoMaq) {
        this.idTipoMaq = idTipoMaq;
    }

    public Tipo getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Tipo idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public List<Ordenproduccion> getOrdenproduccionList() {
        return ordenproduccionList;
    }

    public void setOrdenproduccionList(List<Ordenproduccion> ordenproduccionList) {
        this.ordenproduccionList = ordenproduccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaquina != null ? idMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.idMaquina == null && other.idMaquina != null) || (this.idMaquina != null && !this.idMaquina.equals(other.idMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigo;
    }
    
}
