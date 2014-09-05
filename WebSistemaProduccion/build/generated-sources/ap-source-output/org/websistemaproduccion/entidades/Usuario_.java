package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Bitacora;
import org.websistemaproduccion.entidades.Empleado;
import org.websistemaproduccion.entidades.Perfil;
import org.websistemaproduccion.entidades.Tipo;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, Empleado> empleadoList;
    public static volatile SingularAttribute<Usuario, String> idUsuario;
    public static volatile ListAttribute<Usuario, Perfil> perfilList;
    public static volatile SingularAttribute<Usuario, Tipo> idEstado;
    public static volatile ListAttribute<Usuario, Bitacora> bitacoraList;
    public static volatile SingularAttribute<Usuario, String> password;

}