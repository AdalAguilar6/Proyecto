package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Bobinafardo;
import org.websistemaproduccion.entidades.Materiaprima;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:01")
@StaticMetamodel(Bodega.class)
public class Bodega_ { 

    public static volatile SingularAttribute<Bodega, String> codigo;
    public static volatile SingularAttribute<Bodega, String> nombre;
    public static volatile ListAttribute<Bodega, Materiaprima> materiaprimaList;
    public static volatile SingularAttribute<Bodega, Integer> idBodega;
    public static volatile ListAttribute<Bodega, Bobinafardo> bobinafardoList;

}