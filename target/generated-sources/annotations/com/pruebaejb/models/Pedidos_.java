package com.pruebaejb.models;

import com.pruebaejb.models.Contactos;
import com.pruebaejb.models.EstadoPedidos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-12T23:22:54")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, Double> monto_pagar_pedido;
    public static volatile SingularAttribute<Pedidos, Contactos> contactosId;
    public static volatile SingularAttribute<Pedidos, EstadoPedidos> estadoPedidoId;
    public static volatile SingularAttribute<Pedidos, Date> fecha_entrega_pedido;
    public static volatile SingularAttribute<Pedidos, Integer> id;
    public static volatile SingularAttribute<Pedidos, Date> fecha_emision_pedido;
    public static volatile SingularAttribute<Pedidos, String> conceptoPedido;

}