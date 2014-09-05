package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Empleado;
import org.websistemaproduccion.entidades.Maquina;
import org.websistemaproduccion.entidades.Ordenproduccion;
import org.websistemaproduccion.entidades.Pedido;
import org.websistemaproduccion.entidades.Persona;
import org.websistemaproduccion.entidades.Puesto;
import org.websistemaproduccion.entidades.Usuario;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Tipo.class)
public class Tipo_ { 

    public static volatile ListAttribute<Tipo, Empleado> empleadoList;
    public static volatile ListAttribute<Tipo, Pedido> pedidoList;
    public static volatile ListAttribute<Tipo, Pedido> pedidoList3;
    public static volatile ListAttribute<Tipo, Maquina> maquinaList1;
    public static volatile ListAttribute<Tipo, Pedido> pedidoList4;
    public static volatile ListAttribute<Tipo, Ordenproduccion> ordenproduccionList;
    public static volatile ListAttribute<Tipo, Maquina> maquinaList;
    public static volatile SingularAttribute<Tipo, String> idTipo;
    public static volatile ListAttribute<Tipo, Persona> personaList1;
    public static volatile SingularAttribute<Tipo, String> nombre;
    public static volatile ListAttribute<Tipo, Puesto> puestoList;
    public static volatile ListAttribute<Tipo, Pedido> pedidoList2;
    public static volatile ListAttribute<Tipo, Pedido> pedidoList1;
    public static volatile ListAttribute<Tipo, Usuario> usuarioList;
    public static volatile ListAttribute<Tipo, Persona> personaList;

}