package org.websistemaproduccion.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Ordenproduccion;
import org.websistemaproduccion.entidades.Requisiciondetalle;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Requisicion.class)
public class Requisicion_ { 

    public static volatile SingularAttribute<Requisicion, String> estado;
    public static volatile ListAttribute<Requisicion, Requisiciondetalle> requisiciondetalleList;
    public static volatile SingularAttribute<Requisicion, Date> fecha;
    public static volatile SingularAttribute<Requisicion, Integer> idRequisicion;
    public static volatile SingularAttribute<Requisicion, Date> fechaDespacho;
    public static volatile SingularAttribute<Requisicion, Ordenproduccion> idOrden;

}