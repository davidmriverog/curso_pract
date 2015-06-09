package com.pruebaejb.controller;

import com.pruebaejb.facade.HoldersFacadeLocal;
import com.pruebaejb.models.Holders;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "holderViewBean")
@ViewScoped
public class HolderViewBean implements Serializable{
    
    @EJB
    private HoldersFacadeLocal holderContactLocal;
    
    private List<Holders> holdersList;
    

    public HolderViewBean() {
    }
    
    /* Getter and Setter */
    public List<Holders> getHoldersList() {
        return holdersList;
    }

    public void setHoldersList(List<Holders> holdersList) {
        this.holdersList = holdersList;
    }
    
    /* Methods */
    public List<Holders> mostrarHolderContactos(){
        
        return this.holdersList = this.holderContactLocal.findAll();
    }

    
    
}
