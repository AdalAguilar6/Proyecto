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
import org.websistemaproduccion.entidades.Maquina;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOMaquinaSB extends DAOEntidadSB<Maquina> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Maquina buscarMaquinaxId(Maquina maquina) {
        Maquina mq = null;
        Query q = em.createNamedQuery("Maquina.findByIdMaquina");
        q.setParameter("idMaquina", maquina.getIdMaquina());
        mq = (Maquina) q.getSingleResult();
        return mq;
    }

    public List<Maquina> buscarMaquinaxTipoxEstado(String estado, String tipomaq) {
        List<Maquina> lista = null;
        try {
            Query q = em.createNamedQuery("Maquina.MaquinaxTipoxEstado");
            q.setParameter("estado", estado);
            q.setParameter("tipomaquina", (tipomaq).concat("%"));
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }
    
    public List<Maquina> listarTodos() {
        List<Maquina> lista = null;
        try {
            Query q = em.createNamedQuery("Maquina.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    } 
}
