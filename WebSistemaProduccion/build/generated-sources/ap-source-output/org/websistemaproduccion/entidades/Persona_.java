package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Compra;
import org.websistemaproduccion.entidades.Pedido;
import org.websistemaproduccion.entidades.Tipo;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:00")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> registroFiscal;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile SingularAttribute<Persona, String> nrc;
    public static volatile ListAttribute<Persona, Pedido> pedidoList;
    public static volatile SingularAttribute<Persona, Integer> cliente;
    public static volatile SingularAttribute<Persona, Tipo> idTipoPago;
    public static volatile ListAttribute<Persona, Compra> compraList;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, Tipo> idTipoPersona;
    public static volatile SingularAttribute<Persona, Integer> proveedor;
    public static volatile SingularAttribute<Persona, Integer> idPersona;

}