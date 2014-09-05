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
import org.websistemaproduccion.entidades.Persona;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOPersonaSB extends DAOEntidadSB<Persona> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Persona buscarPersonaxId(Persona persona){
        Persona per = null;
        Query q = em.createNamedQuery("Persona.findByIdPersona");
        q.setParameter("idPersona",persona.getIdPersona());
        per = (Persona) q.getSingleResult();
        return per;
    }
    
    public List<Persona> buscarPersonaProveedor(Integer tipo) {
        List<Persona> lista = null;
        try {
            Query q = em.createNamedQuery("Persona.findByProveedor");
            q.setParameter("proveedor", tipo);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
    
    public List<Persona> buscarPersonaCliente(Integer tipo) {
        List<Persona> lista = null;
        try {
            Query q = em.createNamedQuery("Persona.findByCliente");
            q.setParameter("cliente", tipo);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
    
    public List<Persona> listarTodos() {
        List<Persona> lista = null;
        try {
            Query q = em.createNamedQuery("Persona.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }   
}
