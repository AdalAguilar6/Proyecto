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
import org.websistemaproduccion.entidades.Ordenproduccion;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOOrdenProduccionSB extends DAOEntidadSB<Ordenproduccion> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    public Ordenproduccion buscarOrdenxId(Ordenproduccion ordenproduccion) {
        Ordenproduccion op = null;
        Query q = em.createNamedQuery("Ordenproduccion.findByIdOrden");
        q.setParameter("idOrden", ordenproduccion.getIdOrden());
        op = (Ordenproduccion) q.getSingleResult();
        return op;
    }    

    public Ordenproduccion buscarOrdenId(int idOrden) {
        Ordenproduccion op = null;
        Query q = em.createNamedQuery("Ordenproduccion.findByIdOrden");
        q.setParameter("idOrden", idOrden);
        op = (Ordenproduccion) q.getSingleResult();
        return op;
    }    
    
    
    public List<Ordenproduccion> buscarOrdenxProceso(String proceso) {
        List<Ordenproduccion> lista = null;
        try {
            Query q = em.createNamedQuery("Ordenproduccion.findByProceso");
            q.setParameter("proceso", proceso);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
    
    public List<Ordenproduccion> buscarOrdenxEstado(String estado) {
        List<Ordenproduccion> lista = null;
        try {
            Query q = em.createNamedQuery("Ordenproduccion.findByEstadoOrden");
            q.setParameter("estadoOrden", estado);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }        
            
    public Ordenproduccion buscarOrdenxProcesoCorrel(Ordenproduccion ordenproduccion) {
        Ordenproduccion bd = null;
        Query q = em.createNamedQuery("Ordenproduccion.findByProcesoCorrel");
        q.setParameter("proceso", ordenproduccion.getProceso());
        q.setParameter("correlativo", ordenproduccion.getCorrelativo());
        bd = (Ordenproduccion) q.getSingleResult();
        return bd;
    }  

    public List<Ordenproduccion> buscarOrdenxEstadoxProceso(String estado, String proceso) {
        List<Ordenproduccion> lista = null;
        try {
            Query q = em.createNamedQuery("Ordenproduccion.findByEstadoProceso");
            q.setParameter("estadoOrden", estado);
            q.setParameter("proceso", proceso);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }       
        
    public List<Ordenproduccion> listarTodos() {
        List<Ordenproduccion> lista = null;
        try {
            Query q = em.createNamedQuery("Ordenproduccion.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    } 
      
    public int ConteoOrdenes(String proceso) {
        Query q = em.createNamedQuery("Ordenproduccion.conteo");
        q.setParameter("proceso", proceso);
        return ((Long) q.getSingleResult()).intValue()+1;
    }         
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
