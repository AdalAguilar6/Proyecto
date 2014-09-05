package org.websistemaproduccion.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.websistemaproduccion.entidades.Bobinafardo;
import org.websistemaproduccion.entidades.Notaenvio;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-09-05T14:32:00")
@StaticMetamodel(Notaenviodetalle.class)
public class Notaenviodetalle_ { 

    public static volatile SingularAttribute<Notaenviodetalle, Integer> idNotaEnvioDet;
    public static volatile SingularAttribute<Notaenviodetalle, Bobinafardo> idBobinaFardo;
    public static volatile SingularAttribute<Notaenviodetalle, Notaenvio> idNotaEnvio;

}