package org.websistemaproduccion.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Notaenviodetalle;
import org.websistemaproduccion.entidades.Pedido;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Notaenvio.class)
public class Notaenvio_ { 

    public static volatile SingularAttribute<Notaenvio, Pedido> idPedido;
    public static volatile ListAttribute<Notaenvio, Notaenviodetalle> notaenviodetalleList;
    public static volatile SingularAttribute<Notaenvio, Integer> idNotaEnvio;
    public static volatile SingularAttribute<Notaenvio, Date> fechaDespacho;

}