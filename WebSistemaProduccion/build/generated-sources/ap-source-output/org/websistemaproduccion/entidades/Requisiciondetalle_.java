package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Materiaprima;
import org.websistemaproduccion.entidades.Requisicion;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Requisiciondetalle.class)
public class Requisiciondetalle_ { 

    public static volatile SingularAttribute<Requisiciondetalle, Float> cantidad;
    public static volatile SingularAttribute<Requisiciondetalle, Integer> idRequisicionDetalle;
    public static volatile SingularAttribute<Requisiciondetalle, Requisicion> idRequisicion;
    public static volatile SingularAttribute<Requisiciondetalle, Materiaprima> idMateriaPrima;

}