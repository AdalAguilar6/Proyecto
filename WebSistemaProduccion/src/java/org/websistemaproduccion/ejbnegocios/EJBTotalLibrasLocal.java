/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.ejbnegocios;

import javax.ejb.Local;

/**
 *
 * @author Super Usuario
 */
@Local
public interface EJBTotalLibrasLocal {
    float totalLibras(float ancho, float largo, float adicional, float calibre, float cantidad, int idProducto);   
}
