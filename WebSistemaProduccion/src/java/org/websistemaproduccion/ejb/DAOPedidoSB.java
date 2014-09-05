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
import org.websistemaproduccion.entidades.Pedido;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOPedidoSB extends DAOEntidadSB<Pedido> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Pedido buscarPedidoId(int idPedido) {
        Pedido bd = null;
        Query q = em.createNamedQuery("Pedido.findByIdPedido");
        q.setParameter("idPedido", idPedido);
        bd = (Pedido) q.getSingleResult();
        return bd;
    }

    public Pedido buscarPedidoxId(Pedido pedido) {
        Pedido pr = null;
        Query q = em.createNamedQuery("Pedido.findByIdPedido");
        q.setParameter("idPedido", pedido.getIdPedido());
        pr = (Pedido) q.getSingleResult();
        return pr;
    }    
    
    
    public List<Pedido> buscarPedidoxEtapa(String etapa) {
        List<Pedido> lista = null;
        try {
            Query q = em.createNamedQuery("Pedido.findByEtapa");
            q.setParameter("etapa", etapa);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    public List<Pedido> buscarPedidoxEstado(String estado) {
        List<Pedido> lista = null;
        try {
            Query q = em.createNamedQuery("Pedido.findByEstado");
            q.setParameter("estado", estado);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    public List<Pedido> buscarPedidoEstadoEtapa(String estado, String etapa, int aprobado) {
        List<Pedido> lista = null;
        try {
            Query q = em.createNamedQuery("Pedido.findByEstadoEtapa");
            q.setParameter("estado", estado);
            q.setParameter("etapa", etapa);
            q.setParameter("aprobado", aprobado);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    public List<Pedido> listarTodos() {
        List<Pedido> lista = null;
        try {
            Query q = em.createNamedQuery("Pedido.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
    
    public List<Pedido> buscarPedidoxAprobar(int aprobar) {
        List<Pedido> lista = null;
        try {
            Query q = em.createNamedQuery("Pedido.findByAprobado");
            q.setParameter("aprobado", aprobar);
            q.setParameter("estado", "Pe");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
}
