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

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAORequisicionSB extends DAOEntidadSB<Requisicion> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Requisicion buscarRequisicionxId(Requisicion requisicion) {
        Requisicion cm = null;
        Query q = em.createNamedQuery("Requisicion.findByIdRequisicion");
        q.setParameter("idRequisicion", requisicion.getIdRequisicion());
        cm = (Requisicion) q.getSingleResult();
        return cm;
    }
    
    public List<Requisicion> listarTodos() {
        List<Requisicion> lista = null;
        try {
            Query q = em.createNamedQuery("Requisicion.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }        
}
