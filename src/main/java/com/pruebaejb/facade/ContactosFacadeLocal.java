package com.pruebaejb.facade;

import com.pruebaejb.models.Contactos;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ContactosFacadeLocal {

    void create(Contactos contactos);

    void edit(Contactos contactos);

    void remove(Contactos contactos);

    Contactos find(Object id);

    List<Contactos> findAll();
    
    List<Contactos> findAllByTipos(int cedula_contacto, int holder);

    List<Contactos> findRange(int[] range);

    int count();
    
}
