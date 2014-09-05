package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Bobinafardo;
import org.websistemaproduccion.entidades.Pedido;
import org.websistemaproduccion.entidades.Puesto;
import org.websistemaproduccion.entidades.Tipo;
import org.websistemaproduccion.entidades.Usuario;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile SingularAttribute<Empleado, String> apellido;
    public static volatile SingularAttribute<Empleado, Puesto> idPuesto;
    public static volatile SingularAttribute<Empleado, Usuario> idUsuario;
    public static volatile ListAttribute<Empleado, Bobinafardo> bobinafardoList1;
    public static volatile ListAttribute<Empleado, Pedido> pedidoList;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile SingularAttribute<Empleado, Tipo> idEstado;
    public static volatile ListAttribute<Empleado, Bobinafardo> bobinafardoList;

}