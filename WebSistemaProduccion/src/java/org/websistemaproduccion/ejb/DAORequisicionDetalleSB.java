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
import org.websistemaproduccion.entidades.Requisicion;
import org.websistemaproduccion.entidades.Requisiciondetalle;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAORequisicionDetalleSB extends DAOEntidadSB<Requisiciondetalle> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Requisiciondetalle buscarRequisicionDetallexId(Requisiciondetalle requisiciondetalle) {
        Requisiciondetalle cm = null;
        Query q = em.createNamedQuery("Requisiciondetalle.findByIdRequisicionDetalle");
        q.setParameter("idRequisicionDetalle", requisiciondetalle.getIdRequisicionDetalle());
        cm = (Requisiciondetalle) q.getSingleResult();
        return cm;
    }
    
    public int ConteoDetalles() {
        Query q = em.createNamedQuery("Requisiciondetalle.conteo");
        return ((Long) q.getSingleResult()).intValue();
    }       
    
    public List<Requisiciondetalle> listarDetalleRequi(int idRequisicion) {
        List<Requisiciondetalle> lista = null;
        try {
            Query q = em.createNamedQuery("Requisiciondetalle.findByIdRequisicion");
            q.setParameter("idRequisicion", idRequisicion);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }      
    
     public List<Requisiciondetalle> ListaDetallexIdrequi(Integer requisicionid) {
        List<Requisiciondetalle> cm = null;
        Query q = em.createNamedQuery("Requisiciondetalle.findByIdRequisicion");
        q.setParameter("idRequisicion", requisicionid);
        cm = q.getResultList();
        return cm;
    }
     
      public Requisiciondetalle buscarRequiDetallexId(Requisiciondetalle requisiciondetalle) {
        Requisiciondetalle cm = null;
        Query q = em.createNamedQuery("Requisiciondetalle.findByIdRequisicionDetalle");
        q.setParameter("idRequisicionDetalle", requisiciondetalle.getIdRequisicionDetalle());
        cm = (Requisiciondetalle) q.getSingleResult();
        return cm;
    }    
}
