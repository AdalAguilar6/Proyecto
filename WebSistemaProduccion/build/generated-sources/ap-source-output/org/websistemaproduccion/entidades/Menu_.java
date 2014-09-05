package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Perfil;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile ListAttribute<Menu, Perfil> perfilList;
    public static volatile SingularAttribute<Menu, String> descripcion;
    public static volatile SingularAttribute<Menu, Integer> idMenu;
    public static volatile SingularAttribute<Menu, Integer> posicion;

}