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
import org.websistemaproduccion.entidades.Compradetalle;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOCompraDetalleSB extends DAOEntidadSB<Compradetalle> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }


    public Compradetalle buscarCompraDetallexId(Compradetalle compradetalle) {
        Compradetalle cmd = null;
        Query q = em.createNamedQuery("Compradetalle.findByIdCompraDet");
        q.setParameter("idCompraDet", compradetalle.getIdCompraDet());
        cmd = (Compradetalle) q.getSingleResult();
        return cmd;
    }

    public List<Compradetalle> listaDetalleCompra(int idCompra) {
        List<Compradetalle> lista = null;
        try {
            Query q = em.createNamedQuery("Compradetalle.findByIdCompra");
            q.setParameter("idCompra", idCompra);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
    
    public List<Compradetalle> listarTodos() {
        List<Compradetalle> lista = null;
        try {
            Query q = em.createNamedQuery("Compradetalle.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }  
    
    public int ConteoDetalles() {
        Query q = em.createNamedQuery("Compradetalle.conteo");
        return ((Long) q.getSingleResult()).intValue();
    }    
    
    public List<Compradetalle> ListadoDetallexIdcompra(Compra compra) {
        List<Compradetalle> cm = null;
        Query q = em.createNamedQuery("Compradetalle.findByIdCompra");
        q.setParameter("idCompra", compra.getIdCompra());
        cm = q.getResultList();
        return cm;
    }    
    
    public List<Compradetalle> ListaDetallexIdcompra(Integer compraid) {
        List<Compradetalle> cm = null;
        Query q = em.createNamedQuery("Compradetalle.findByIdCompra");
        q.setParameter("idCompra", compraid);
        cm = q.getResultList();
        return cm;
    }
}
