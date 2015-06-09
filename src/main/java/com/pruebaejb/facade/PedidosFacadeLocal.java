package com.pruebaejb.facade;

import com.pruebaejb.models.Pedidos;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PedidosFacadeLocal {

    void create(Pedidos pedidos);

    void edit(Pedidos pedidos);

    void remove(Pedidos pedidos);

    Pedidos find(Object id);

    List<Pedidos> findAll();

    List<Pedidos> findRange(int[] range);

    int count();
    
}
