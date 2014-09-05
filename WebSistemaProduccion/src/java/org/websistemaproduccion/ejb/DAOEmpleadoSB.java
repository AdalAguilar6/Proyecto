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
import org.websistemaproduccion.entidades.Empleado;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class DAOEmpleadoSB extends DAOEntidadSB<Empleado> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Empleado buscarEmpleadoxId(Empleado empleado) {
        Empleado ep = null;
        Query q = em.createNamedQuery("Empleado.findByIdEmpleado");
        q.setParameter("idEmpleado", empleado.getIdEmpleado());
        ep = (Empleado) q.getSingleResult();
        return ep;
    }

    public List<Empleado> buscarEmpleadoxNombre(String nombre) {
        List<Empleado> lista = null;
        try {
            Query q = em.createNamedQuery("Empleado.findByNombre");
            q.setParameter("nombre", "%".concat(nombre).concat("%"));
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    public List<Empleado> buscarEmpleadoxApellido(String apellido) {
                List<Empleado> lista = null;
        try {
            Query q = em.createNamedQuery("Empleado.findByApellido");
            q.setParameter("apellido", "%".concat(apellido).concat("%"));
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    public List<Empleado> buscarTipoPuesto(String puesto) {
        List<Empleado> lista = null;
        try {
            Query q = em.createNamedQuery("Empleado.findEmpleadoxPuesto");
            q.setParameter("puesto", "%".concat(puesto).concat("%"));
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
    
    public List<Empleado> listarTodos() {
        List<Empleado> lista = null;
        try {
            Query q = em.createNamedQuery("Empleado.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    } 
    
    public List<Empleado> buscarEmpEstadoTipo(String estado, String depto, String puesto) {
        List<Empleado> lista = null;
        try {
            Query q = em.createNamedQuery("Empleado.findEmpleadoxTipo");
            q.setParameter("estado", (estado).concat("%"));
            q.setParameter("puesto", (puesto).concat("%"));
            q.setParameter("depto", (depto).concat("%"));
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }    
}
