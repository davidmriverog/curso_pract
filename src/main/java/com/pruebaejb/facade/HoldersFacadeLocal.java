package com.pruebaejb.facade;

import com.pruebaejb.models.Holders;
import java.util.List;
import javax.ejb.Local;


@Local
public interface HoldersFacadeLocal {

    void create(Holders holders);

    void edit(Holders holders);

    void remove(Holders holders);

    Holders find(Object id);

    List<Holders> findAll();

    List<Holders> findRange(int[] range);

    int count();
    
}
