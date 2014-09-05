/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.ejbnegocios;

import javax.ejb.Stateless;

/**
 *
 * @author Super Usuario
 */
@Stateless
public class EJBTotalLibras implements EJBTotalLibrasLocal {
private float librasTotales;

    @Override
    public float totalLibras(float ancho, float largo, float adicional, float calibre, float cantidad, int idProducto) {
        if (idProducto == 1) {
            librasTotales = ancho * (largo + (adicional / 2)) * calibre / 15 * cantidad;	
        } else {
            librasTotales = cantidad;
        }
        return librasTotales;
    }

    

}
