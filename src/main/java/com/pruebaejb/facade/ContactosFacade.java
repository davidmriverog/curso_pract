/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaejb.facade;

import com.pruebaejb.models.Contactos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author davidmriverog
 */
@Stateless
public class ContactosFacade extends AbstractFacade<Contactos> implements ContactosFacadeLocal {
    @PersistenceContext(unitName = "PruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }   

    public ContactosFacade() {
        super(Contactos.class);
    }

    @Override
    public List<Contactos> findAllByTipos(int cedula_contacto, int holder) {
        
        TypedQuery<Contactos> query = em.createNamedQuery("Contactos.findAllByTipos", Contactos.class);
        query.setParameter("cedula", cedula_contacto);
        query.setParameter("holders", holder);
        
        return query.getResultList();
    }
    
    
    
}
