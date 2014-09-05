package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Bodega;
import org.websistemaproduccion.entidades.Compradetalle;
import org.websistemaproduccion.entidades.Requisiciondetalle;
import org.websistemaproduccion.entidades.Unidadmedida;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Materiaprima.class)
public class Materiaprima_ { 

    public static volatile SingularAttribute<Materiaprima, String> nombre;
    public static volatile SingularAttribute<Materiaprima, Unidadmedida> idUnidadMedida;
    public static volatile ListAttribute<Materiaprima, Compradetalle> compradetalleList;
    public static volatile ListAttribute<Materiaprima, Requisiciondetalle> requisiciondetalleList;
    public static volatile SingularAttribute<Materiaprima, Integer> idMateriaPrima;
    public static volatile SingularAttribute<Materiaprima, Bodega> idBodega;
    public static volatile SingularAttribute<Materiaprima, Float> existencia;

}