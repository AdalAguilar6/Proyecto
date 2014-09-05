package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Empleado;
import org.websistemaproduccion.entidades.Tipo;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile SingularAttribute<Puesto, String> nombre;
    public static volatile ListAttribute<Puesto, Empleado> empleadoList;
    public static volatile SingularAttribute<Puesto, Integer> idPuesto;
    public static volatile SingularAttribute<Puesto, Tipo> idDepto;

}