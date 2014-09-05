/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.websistemaproduccion.entidades.Maquina;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class MaquinaFacade extends AbstractFacade<Maquina> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaquinaFacade() {
        super(Maquina.class);
    }
    
}
