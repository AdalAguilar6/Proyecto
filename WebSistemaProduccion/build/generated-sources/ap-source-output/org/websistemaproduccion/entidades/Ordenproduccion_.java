package org.websistemaproduccion.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Bobinafardo;
import org.websistemaproduccion.entidades.Maquina;
import org.websistemaproduccion.entidades.Pedido;
import org.websistemaproduccion.entidades.Requisicion;
import org.websistemaproduccion.entidades.Tipo;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Ordenproduccion.class)
public class Ordenproduccion_ { 

    public static volatile SingularAttribute<Ordenproduccion, Pedido> idPedido;
    public static volatile SingularAttribute<Ordenproduccion, String> estadoOrden;
    public static volatile SingularAttribute<Ordenproduccion, Date> fecha;
    public static volatile SingularAttribute<Ordenproduccion, Float> largo;
    public static volatile SingularAttribute<Ordenproduccion, String> registros;
    public static volatile ListAttribute<Ordenproduccion, Bobinafardo> bobinafardoList;
    public static volatile ListAttribute<Ordenproduccion, Requisicion> requisicionList;
    public static volatile SingularAttribute<Ordenproduccion, Tipo> idTurno;
    public static volatile SingularAttribute<Ordenproduccion, Float> calibre;
    public static volatile SingularAttribute<Ordenproduccion, Integer> rodillo;
    public static volatile SingularAttribute<Ordenproduccion, Integer> repeticiones;
    public static volatile SingularAttribute<Ordenproduccion, Integer> correlativo;
    public static volatile SingularAttribute<Ordenproduccion, String> observacion;
    public static volatile SingularAttribute<Ordenproduccion, Integer> rollos;
    public static volatile SingularAttribute<Ordenproduccion, String> proceso;
    public static volatile SingularAttribute<Ordenproduccion, Maquina> idMaquina;
    public static volatile SingularAttribute<Ordenproduccion, Float> ancho;
    public static volatile SingularAttribute<Ordenproduccion, Integer> empaque;
    public static volatile SingularAttribute<Ordenproduccion, Integer> idOrden;

}