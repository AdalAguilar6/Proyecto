package org.websistemaproduccion.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Compradetalle;
import org.websistemaproduccion.entidades.Persona;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile ListAttribute<Compra, Compradetalle> compradetalleList;
    public static volatile SingularAttribute<Compra, Date> fecha;
    public static volatile SingularAttribute<Compra, Persona> idProveedor;
    public static volatile SingularAttribute<Compra, Integer> idCompra;

}