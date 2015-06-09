package com.pruebaejb.facade;

import com.pruebaejb.models.Holders;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HoldersFacade extends AbstractFacade<Holders> implements HoldersFacadeLocal {
    @PersistenceContext(unitName = "PruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HoldersFacade() {
        super(Holders.class);
    }
    
}
