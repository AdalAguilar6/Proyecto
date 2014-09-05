package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Materiaprima;
import org.websistemaproduccion.entidades.Pedido;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:00")
@StaticMetamodel(Unidadmedida.class)
public class Unidadmedida_ { 

    public static volatile SingularAttribute<Unidadmedida, String> nombre;
    public static volatile SingularAttribute<Unidadmedida, Integer> idUnidadMedida;
    public static volatile SingularAttribute<Unidadmedida, String> abreviatura;
    public static volatile ListAttribute<Unidadmedida, Materiaprima> materiaprimaList;
    public static volatile ListAttribute<Unidadmedida, Pedido> pedidoList;

}