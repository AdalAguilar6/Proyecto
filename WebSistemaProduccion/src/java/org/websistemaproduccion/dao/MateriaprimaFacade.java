/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.websistemaproduccion.entidades.Materiaprima;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class MateriaprimaFacade extends AbstractFacade<Materiaprima> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaprimaFacade() {
        super(Materiaprima.class);
    }
    
}
