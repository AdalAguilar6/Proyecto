/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.websistemaproduccion.entidades.Requisicion;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class RequisicionFacade extends AbstractFacade<Requisicion> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequisicionFacade() {
        super(Requisicion.class);
    }
    
}
