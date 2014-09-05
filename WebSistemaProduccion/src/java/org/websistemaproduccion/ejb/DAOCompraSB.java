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
import org.websistemaproduccion.entidades.Compra;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOCompraSB extends DAOEntidadSB<Compra> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }


    public Compra buscarCompraxId(Compra compra) {
        Compra cm = null;
        Query q = em.createNamedQuery("Compra.findByIdCompra");
        q.setParameter("idCompra", compra.getIdCompra());
        cm = (Compra) q.getSingleResult();
        return cm;
    }

    public List<Compra> listarTodos() {
        List<Compra> lista = null;
        try {
            Query q = em.createNamedQuery("Compra.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }     
}
