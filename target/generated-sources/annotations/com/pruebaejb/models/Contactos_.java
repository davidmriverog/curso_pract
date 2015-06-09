package com.pruebaejb.models;

import com.pruebaejb.models.Holders;
import com.pruebaejb.models.Pedidos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-09T00:45:31")
@StaticMetamodel(Contactos.class)
public class Contactos_ { 

    public static volatile SingularAttribute<Contactos, String> nombre_completo_contacto;
    public static volatile SingularAttribute<Contactos, Holders> holders_contactos;
    public static volatile ListAttribute<Contactos, Pedidos> pedidosContactosList;
    public static volatile SingularAttribute<Contactos, String> nombres_contacto;
    public static volatile SingularAttribute<Contactos, Integer> id;
    public static volatile SingularAttribute<Contactos, String> apellidos_contacto;
    public static volatile SingularAttribute<Contactos, Integer> cedula_holder;
    public static volatile SingularAttribute<Contactos, Integer> cedula_contacto;

}