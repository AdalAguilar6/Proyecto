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
import org.websistemaproduccion.entidades.Producto;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOProductoSB extends DAOEntidadSB<Producto> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Producto buscarProductoxId(Producto producto) {
        Producto pr = null;
        Query q = em.createNamedQuery("Producto.findByIdProducto");
        q.setParameter("idProducto", producto.getIdProducto());
        pr = (Producto) q.getSingleResult();
        return pr;
    }

    public List<Producto> listarTodos() {
        List<Producto> lista = null;
        try {
            Query q = em.createNamedQuery("Producto.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }
}
