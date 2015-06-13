package com.pruebaejb.facade;

import com.pruebaejb.models.EstadoPedidos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstadoPedidosFacade extends AbstractFacade<EstadoPedidos> implements EstadoPedidosFacadeLocal {
    @PersistenceContext(unitName = "PruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoPedidosFacade() {
        super(EstadoPedidos.class);
    }
    
}
