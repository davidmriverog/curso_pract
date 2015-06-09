package com.pruebaejb.controller;

import com.pruebaejb.facade.ContactosFacadeLocal;
import com.pruebaejb.models.Contactos;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "contactosViewBean")
@ViewScoped
public class ContactosViewBean implements Serializable{

   @EJB 
   private ContactosFacadeLocal contactosLocal;
   
   
   private List<Contactos> contactosList;
   
   
   public ContactosViewBean() {
   }
   
   /* Getter and Setter */
   public List<Contactos> getContactosList() {
        return contactosList;
   }

   public void setContactosList(List<Contactos> contactosList) {
        this.contactosList = contactosList;
   }
   
   /* Methods */
   public List<Contactos> mostrarTodosContactos(){
       
       return this.contactosList = this.contactosLocal.findAll();
   }

    
   
   
}
