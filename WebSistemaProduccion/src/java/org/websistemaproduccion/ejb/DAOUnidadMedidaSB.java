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
import org.websistemaproduccion.entidades.Unidadmedida;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOUnidadMedidaSB extends DAOEntidadSB<Unidadmedida> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Unidadmedida buscarUnidadMedidaxId(Unidadmedida unidadmedida) {
        Unidadmedida bd = null;
        Query q = em.createNamedQuery("Unidadmedida.findByIdUnidadMedida");
        q.setParameter("idUnidadMedida", unidadmedida.getIdUnidadMedida());
        bd = (Unidadmedida) q.getSingleResult();
        return bd;
    }

    public List<Unidadmedida> listarTodos() {
        List<Unidadmedida> lista = null;
        try {
            Query q = em.createNamedQuery("Unidadmedida.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    } 
}
