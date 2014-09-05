/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.websistemaproduccion.entidades.Secuencia;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class SecuenciaFacade extends AbstractFacade<Secuencia> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SecuenciaFacade() {
        super(Secuencia.class);
    }
    
}
