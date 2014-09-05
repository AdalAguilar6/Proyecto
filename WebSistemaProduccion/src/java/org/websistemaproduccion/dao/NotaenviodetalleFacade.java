/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.websistemaproduccion.entidades.Notaenviodetalle;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class NotaenviodetalleFacade extends AbstractFacade<Notaenviodetalle> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaenviodetalleFacade() {
        super(Notaenviodetalle.class);
    }
    
}
