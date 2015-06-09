package com.pruebaejb.controller;

import com.pruebaejb.facade.ContactosFacadeLocal;
import com.pruebaejb.facade.PedidosFacadeLocal;
import com.pruebaejb.models.Contactos;
import com.pruebaejb.models.Pedidos;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "pedidosViewBean")
@ViewScoped
public class PedidosViewBean implements Serializable{

    @EJB
    private PedidosFacadeLocal pedidosLocal;
    
    @EJB
    private ContactosFacadeLocal contactosLocal;
    
    private List<Pedidos> pedidosList;
        
    
    public PedidosViewBean() {
    }
    
    /* Getter and Setter */
    
    public List<Pedidos> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedidos> pedidosList) {
        this.pedidosList = pedidosList;
    }
    
    /* Methods */
    public List<Pedidos> mostrarTodosPedidos(){
        
        List<Pedidos> lista = this.pedidosLocal.findAll();
        
        List<Contactos> contactTitular;
        
        
        for (Pedidos ordenarContactos : lista) {
            
            ordenarContactos.getContactosId().getId();
            
            if(ordenarContactos.getContactosId().getHolders_contactos().getId()!=1){
                
                contactTitular = contactosLocal.findAllByTipos(ordenarContactos.getContactosId().getCedula_holder(),1);
                
                ordenarContactos.setCedulaTitular(contactTitular.get(0).getCedula_contacto());
                ordenarContactos.setNombreCompletoTitular(contactTitular.get(0).getNombre_completo_contacto());
                ordenarContactos.setNombreCompletoBeneficiario(ordenarContactos.getContactosId().getNombre_completo_contacto());
            }
            else{
                ordenarContactos.setCedulaTitular(ordenarContactos.getContactosId().getCedula_contacto());
                ordenarContactos.setNombreCompletoTitular(ordenarContactos.getContactosId().getNombre_completo_contacto());
                ordenarContactos.setNombreCompletoBeneficiario(ordenarContactos.getContactosId().getNombre_completo_contacto());
            }
        }
        
        return lista;
    }
    
   
}
