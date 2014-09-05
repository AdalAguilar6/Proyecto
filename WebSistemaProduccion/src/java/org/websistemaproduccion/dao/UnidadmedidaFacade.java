/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.websistemaproduccion.entidades.Unidadmedida;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class UnidadmedidaFacade extends AbstractFacade<Unidadmedida> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadmedidaFacade() {
        super(Unidadmedida.class);
    }
    
}
