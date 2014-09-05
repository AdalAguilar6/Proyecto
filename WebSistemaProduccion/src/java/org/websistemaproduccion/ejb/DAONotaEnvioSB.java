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
import org.websistemaproduccion.entidades.Notaenvio;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAONotaEnvioSB extends DAOEntidadSB<Notaenvio> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Notaenvio buscarNotaEnvioxId(Notaenvio notaenvio) {
        Notaenvio ne = null;
        Query q = em.createNamedQuery("Notaenvio.findByIdNotaEnvio");
        q.setParameter("idNotaEnvio", notaenvio.getIdNotaEnvio());
        ne = (Notaenvio) q.getSingleResult();
        return ne;
    }

    public List<Notaenvio> listarTodos() {
        List<Notaenvio> lista = null;
        try {
            Query q = em.createNamedQuery("Notaenvio.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }   
}
