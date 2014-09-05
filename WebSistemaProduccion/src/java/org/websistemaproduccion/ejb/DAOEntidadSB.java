/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.ejb;
import javax.persistence.EntityManager;


public abstract class DAOEntidadSB<T> {
public abstract EntityManager getEntityManager();    

    public void elimina(T entidad) {
        getEntityManager().remove(getEntityManager().merge(entidad));
    }

    public void insertar(T entidad) {
        getEntityManager().persist(entidad);
    }

    public void modifica(T entidad) {
        getEntityManager().merge(entidad);
    }

}
