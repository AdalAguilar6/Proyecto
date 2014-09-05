package org.websistemaproduccion.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Empleado;
import org.websistemaproduccion.entidades.Notaenvio;
import org.websistemaproduccion.entidades.Ordenproduccion;
import org.websistemaproduccion.entidades.Persona;
import org.websistemaproduccion.entidades.Producto;
import org.websistemaproduccion.entidades.Tipo;
import org.websistemaproduccion.entidades.Unidadmedida;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:00")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Float> tamanoFuelle1;
    public static volatile SingularAttribute<Pedido, Empleado> idVendedor;
    public static volatile SingularAttribute<Pedido, Float> tamanoFuelle2;
    public static volatile SingularAttribute<Pedido, Integer> impresionDorso;
    public static volatile SingularAttribute<Pedido, Tipo> idSello;
    public static volatile SingularAttribute<Pedido, Float> largo;
    public static volatile SingularAttribute<Pedido, String> textoImpreso;
    public static volatile SingularAttribute<Pedido, Producto> idProducto;
    public static volatile SingularAttribute<Pedido, Integer> impresionFrente;
    public static volatile ListAttribute<Pedido, Ordenproduccion> ordenproduccionList;
    public static volatile SingularAttribute<Pedido, Integer> impresionUnaCara;
    public static volatile SingularAttribute<Pedido, Unidadmedida> idUniadMedida;
    public static volatile SingularAttribute<Pedido, Integer> aprobado;
    public static volatile SingularAttribute<Pedido, Integer> refilado;
    public static volatile SingularAttribute<Pedido, String> observacion;
    public static volatile SingularAttribute<Pedido, Float> librasTotales;
    public static volatile SingularAttribute<Pedido, Float> cantidad;
    public static volatile SingularAttribute<Pedido, Integer> impresionDosCara;
    public static volatile SingularAttribute<Pedido, Float> ancho;
    public static volatile SingularAttribute<Pedido, Integer> doblado;
    public static volatile SingularAttribute<Pedido, String> tipoTinta;
    public static volatile SingularAttribute<Pedido, Integer> idPedido;
    public static volatile SingularAttribute<Pedido, String> pigmento;
    public static volatile SingularAttribute<Pedido, Date> fecha;
    public static volatile SingularAttribute<Pedido, String> direcEntrega;
    public static volatile SingularAttribute<Pedido, Persona> idCliente;
    public static volatile SingularAttribute<Pedido, Integer> impresa;
    public static volatile ListAttribute<Pedido, Notaenvio> notaenvioList;
    public static volatile SingularAttribute<Pedido, Float> tamanoAdicional;
    public static volatile SingularAttribute<Pedido, Float> calibre;
    public static volatile SingularAttribute<Pedido, Float> precioUnitario;
    public static volatile SingularAttribute<Pedido, String> estado;
    public static volatile SingularAttribute<Pedido, String> etapa;
    public static volatile SingularAttribute<Pedido, Tipo> idFuelle2;
    public static volatile SingularAttribute<Pedido, String> resistencia;
    public static volatile SingularAttribute<Pedido, Date> fechaEntrega;
    public static volatile SingularAttribute<Pedido, Tipo> idFuelle1;
    public static volatile SingularAttribute<Pedido, Integer> impresionContinua;
    public static volatile SingularAttribute<Pedido, Tipo> idTroquelado;
    public static volatile SingularAttribute<Pedido, Tipo> idAdicional;

}