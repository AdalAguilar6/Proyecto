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
import org.websistemaproduccion.entidades.Usuario;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOUsuarioSB extends DAOEntidadSB<Usuario> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Usuario buscarUsuarioxId(Usuario usuario) {
        Usuario us = null;
        Query q = em.createNamedQuery("Usuario.findByIdUsuario");
        q.setParameter("idUsuario", usuario.getIdUsuario());
        us = (Usuario) q.getSingleResult();
        return us;
    }

    public List<Usuario> listarUsuarioActivo() {
        List<Usuario> lista = null;
        try {
            Query q = em.createNamedQuery("Usuario.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    public List<Usuario> listarUsuarioxEstado(String estado) {
        List<Usuario> lista = null;
        try {
            Query q = em.createNamedQuery("Usuario.findByIdEstado");
            q.setParameter(":idEstado", estado);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    } 
}
