package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Compra;
import org.websistemaproduccion.entidades.Materiaprima;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Compradetalle.class)
public class Compradetalle_ { 

    public static volatile SingularAttribute<Compradetalle, Float> cantidad;
    public static volatile SingularAttribute<Compradetalle, Materiaprima> idMateriaPrima;
    public static volatile SingularAttribute<Compradetalle, Integer> idCompraDet;
    public static volatile SingularAttribute<Compradetalle, Compra> idCompra;

}