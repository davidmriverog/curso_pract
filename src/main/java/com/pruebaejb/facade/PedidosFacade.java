package com.pruebaejb.facade;

import com.pruebaejb.models.Pedidos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PedidosFacade extends AbstractFacade<Pedidos> implements PedidosFacadeLocal {
    @PersistenceContext(unitName = "PruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidosFacade() {
        super(Pedidos.class);
    }

    @Override
    public List<Pedidos> findAllbyStatus(int idStatus) {
         TypedQuery<Pedidos> query = em.createNamedQuery("Pedidos.findAllByStatus", Pedidos.class);
        query.setParameter("statusId", idStatus);
        return query.getResultList(); 
    }
    
    
    
}
