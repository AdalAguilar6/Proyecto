package org.websistemaproduccion.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Usuario;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Bitacora.class)
public class Bitacora_ { 

    public static volatile SingularAttribute<Bitacora, Usuario> idUsuario;
    public static volatile SingularAttribute<Bitacora, Integer> idBitacora;
    public static volatile SingularAttribute<Bitacora, String> registro;
    public static volatile SingularAttribute<Bitacora, String> tipoAccion;
    public static volatile SingularAttribute<Bitacora, Date> fechaModifica;
    public static volatile SingularAttribute<Bitacora, String> tabla;

}