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
import org.websistemaproduccion.entidades.Notaenviodetalle;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAONotaEnvioDetalleSB extends DAOEntidadSB<Notaenviodetalle> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Notaenviodetalle buscarNotaEnvioDetallexId(Notaenviodetalle notaenviodetalle) {
        Notaenviodetalle cm = null;
        Query q = em.createNamedQuery("Notaenviodetalle.findByIdNotaEnvioDet");
        q.setParameter("idNotaEnvioDet", notaenviodetalle.getIdNotaEnvioDet());
        cm = (Notaenviodetalle) q.getSingleResult();
        return cm;
    }

     public List<Notaenviodetalle> listarTodos() {
        List<Notaenviodetalle> lista = null;
        try {
            Query q = em.createNamedQuery("Notaenviodetalle.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }       
     /*
      public List<Notaenviodetalle> ListadoDetallexIdnotaenvio(Notaenvio notaenvio) {
        List<Notaenviodetalle> cm = null;
        Query q = em.createNamedQuery("Notaenviodetalle.findIdNotaEnvio");
        q.setParameter("idNotaEnvio", notaenvio.getIdNotaEnvio());
        cm = q.getResultList();
        return cm;
     }    
    */  
      public List<Notaenviodetalle> ListadoDetallexIdnotaenvio(Integer notaenvioid) {
        List<Notaenviodetalle> cm = null;
        Query q = em.createNamedQuery("Notaenviodetalle.findIdNotaEnvio");
        q.setParameter("idNotaEnvio", notaenvioid);
        cm = q.getResultList();
        return cm;
    }         
}
