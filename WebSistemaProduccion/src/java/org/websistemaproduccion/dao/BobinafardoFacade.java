/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.websistemaproduccion.entidades.Bobinafardo;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class BobinafardoFacade extends AbstractFacade<Bobinafardo> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BobinafardoFacade() {
        super(Bobinafardo.class);
    }
    
}
