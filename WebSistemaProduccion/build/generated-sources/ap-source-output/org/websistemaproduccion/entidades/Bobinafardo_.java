package org.websistemaproduccion.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Bodega;
import org.websistemaproduccion.entidades.Empleado;
import org.websistemaproduccion.entidades.Notaenviodetalle;
import org.websistemaproduccion.entidades.Ordenproduccion;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Bobinafardo.class)
public class Bobinafardo_ { 

    public static volatile SingularAttribute<Bobinafardo, Date> horaFinal;
    public static volatile SingularAttribute<Bobinafardo, Integer> secuencial;
    public static volatile SingularAttribute<Bobinafardo, Date> horaInicio;
    public static volatile SingularAttribute<Bobinafardo, Float> pesoEntrada;
    public static volatile SingularAttribute<Bobinafardo, String> idBobinaFardo;
    public static volatile SingularAttribute<Bobinafardo, String> idBobinaFardoEntrada;
    public static volatile SingularAttribute<Bobinafardo, Empleado> idSupervisor;
    public static volatile SingularAttribute<Bobinafardo, Float> peso;
    public static volatile SingularAttribute<Bobinafardo, String> observacion;
    public static volatile SingularAttribute<Bobinafardo, Float> cantidad;
    public static volatile SingularAttribute<Bobinafardo, Empleado> idOperario;
    public static volatile ListAttribute<Bobinafardo, Notaenviodetalle> notaenviodetalleList;
    public static volatile SingularAttribute<Bobinafardo, Bodega> idBodega;
    public static volatile SingularAttribute<Bobinafardo, Ordenproduccion> idOrden;

}