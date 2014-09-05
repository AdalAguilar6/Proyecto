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
import org.websistemaproduccion.entidades.Bodega;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOBodegaSB extends DAOEntidadSB<Bodega> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Bodega buscarBodegaxId(Bodega bodega) {
        Bodega bd = null;
        Query q = em.createNamedQuery("Bodega.findByIdBodega");
        q.setParameter("idBodega", bodega.getIdBodega());
        bd = (Bodega) q.getSingleResult();
        return bd;
    }    

    public Bodega buscarBodegaId(int idBodega) {
        Bodega bd = null;
        Query q = em.createNamedQuery("Bodega.findByIdBodega");
        q.setParameter("idBodega", idBodega);
        bd = (Bodega) q.getSingleResult();
        return bd;
    }        
    
    public Bodega buscarBodegaxCodigo(Bodega bodega) {
        Bodega bd = null;
        Query q = em.createNamedQuery("Bodega.findByCodigo");
        q.setParameter("codigo", bodega.getCodigo());
        bd = (Bodega) q.getSingleResult();
        return bd;
    }    

    public List<Bodega> listarTodos() {
        List<Bodega> lista = null;
        try {
            Query q = em.createNamedQuery("Bodega.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }  
}
