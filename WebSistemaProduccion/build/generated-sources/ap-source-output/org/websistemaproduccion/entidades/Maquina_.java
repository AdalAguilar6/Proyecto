package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Ordenproduccion;
import org.websistemaproduccion.entidades.Tipo;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:00")
@StaticMetamodel(Maquina.class)
public class Maquina_ { 

    public static volatile SingularAttribute<Maquina, String> codigo;
    public static volatile SingularAttribute<Maquina, Integer> idMaquina;
    public static volatile SingularAttribute<Maquina, Tipo> idEstado;
    public static volatile SingularAttribute<Maquina, Tipo> idTipoMaq;
    public static volatile ListAttribute<Maquina, Ordenproduccion> ordenproduccionList;

}