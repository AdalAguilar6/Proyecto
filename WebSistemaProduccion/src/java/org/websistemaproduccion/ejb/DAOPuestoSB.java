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
import org.websistemaproduccion.entidades.Puesto;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOPuestoSB extends DAOEntidadSB<Puesto> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Puesto buscarPuestoxId(Puesto puesto) {
        Puesto bd = null;
        Query q = em.createNamedQuery("Puesto.findByIdPuesto");
        q.setParameter("idPuesto", puesto.getIdPuesto());
        bd = (Puesto) q.getSingleResult();
        return bd;
    }

    public List<Puesto> buscarPuestoxDepto(String depto) {
        List<Puesto> lista = null;
        try {
            Query q = em.createNamedQuery("Puesto.findByDepartamento");
            q.setParameter("departamento", "%".concat(depto).concat("%"));
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    public List<Puesto> buscarPuestoTodas() {
        List<Puesto> lista = null;
        try {
            Query q = em.createNamedQuery("Puesto.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }
}
