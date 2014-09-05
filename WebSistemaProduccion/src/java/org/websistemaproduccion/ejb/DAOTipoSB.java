/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.websistemaproduccion.entidades.Tipo;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOTipoSB extends DAOEntidadSB<Tipo> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Tipo buscarTipoxId(Tipo tipo) {
        Tipo cl = null;
        Query q = em.createNamedQuery("Tipo.findByIdTipo");
        q.setParameter("idTipo", tipo.getIdTipo());
        cl = (Tipo) q.getSingleResult();
        return cl;
    }

    public List<Tipo> buscarTipoxNombre(String nombre) {
        List<Tipo> lista = null;
        try {
            Query q = em.createNamedQuery("Tipo.findByNombre");
            q.setParameter("nombre", "%".concat(nombre).concat("%"));
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    public List<Tipo> buscarTipoxLetra(String letra) {
        List<Tipo> lista = null;
        try {
            Query q = em.createNamedQuery("Tipo.findByLetra");
            q.setParameter("letra", (letra).concat("%"));
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }
    
    public List<Tipo> listarTodos() {
        List<Tipo> lista = null;
        try {
            Query q = em.createNamedQuery("Tipo.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    } 
}
