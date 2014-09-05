/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.websistemaproduccion.entidades.Notaenvio;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class NotaenvioFacade extends AbstractFacade<Notaenvio> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaenvioFacade() {
        super(Notaenvio.class);
    }
    
}
