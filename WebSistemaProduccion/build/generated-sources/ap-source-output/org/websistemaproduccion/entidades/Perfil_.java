package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Menu;
import org.websistemaproduccion.entidades.Usuario;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, Integer> idPerfil;
    public static volatile SingularAttribute<Perfil, String> nombre;
    public static volatile ListAttribute<Perfil, Usuario> usuarioList;
    public static volatile SingularAttribute<Perfil, String> descripcion;
    public static volatile ListAttribute<Perfil, Menu> menuList;

}