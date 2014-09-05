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
import org.websistemaproduccion.entidades.Materiaprima;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOMateriaPrimaSB extends DAOEntidadSB<Materiaprima> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Materiaprima buscarMateriaPrimaxId(Materiaprima materiaPrima) {
        Materiaprima mp = null;
        Query q = em.createNamedQuery("Materiaprima.findByIdMateriaPrima");
        q.setParameter("idMateriaPrima", materiaPrima.getIdMateriaPrima());
        mp = (Materiaprima) q.getSingleResult();
        return mp;
    } 
    
    public List<Materiaprima> listarTodos() {
        List<Materiaprima> lista = null;
        try {
            Query q = em.createNamedQuery("Materiaprima.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
}
