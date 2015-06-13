package com.pruebaejb.facade;

import com.pruebaejb.models.EstadoPedidos;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EstadoPedidosFacadeLocal {

    void create(EstadoPedidos estadoPedidos);

    void edit(EstadoPedidos estadoPedidos);

    void remove(EstadoPedidos estadoPedidos);

    EstadoPedidos find(Object id);

    List<EstadoPedidos> findAll();

    List<EstadoPedidos> findRange(int[] range);

    int count();
    
}
