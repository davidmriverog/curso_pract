package com.pruebaejb.controller;

import com.pruebaejb.controller.enums.EstadoPedidosEnums;
import com.pruebaejb.facade.ContactosFacadeLocal;
import com.pruebaejb.facade.EstadoPedidosFacadeLocal;
import com.pruebaejb.facade.PedidosFacadeLocal;
import com.pruebaejb.models.Contactos;
import com.pruebaejb.models.EstadoPedidos;
import com.pruebaejb.models.Pedidos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

@Named(value = "pedidosViewBean")
@ViewScoped
public class PedidosViewBean implements Serializable{

    /* EJBs */
    @EJB
    private PedidosFacadeLocal pedidosLocal;
    
    @EJB
    private ContactosFacadeLocal contactosLocal;
    
    @EJB  
    private EstadoPedidosFacadeLocal estadoLocal;
    
    /* Attributes */
    
    private boolean btnConcept,btnVisibleAprobar;
    
    // Contactos
    
    // EstadoPedidos
    private int estadoId;
    
    private List<EstadoPedidos> estadoPedidosList;
    
    // Pedidos
    
    private List<Pedidos> pedidosList;
    private List<Pedidos> filtreredPedidos;
        
    
    /* Constructs */
    
    public PedidosViewBean() {
    }
    
    @PostConstruct
    public void init(){
        
        
        this.mostrarTodosPedidos();
        this.mostrarTodosEstadosPedidos();
    }
    
    /* Getter and Setter */
    
    public List<Pedidos> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedidos> pedidosList) {
        this.pedidosList = pedidosList;
    }

    public List<Pedidos> getFiltreredPedidos() {
        return filtreredPedidos;
    }

    public void setFiltreredPedidos(List<Pedidos> filtreredPedidos) {
        this.filtreredPedidos = filtreredPedidos;
    }

    public List<EstadoPedidos> getEstadoPedidosList() {
        return estadoPedidosList;
    }

    public void setEstadoPedidosList(List<EstadoPedidos> estadoPedidosList) {
        this.estadoPedidosList = estadoPedidosList;
    }

    public boolean isBtnConcept() {
        return btnConcept;
    }

    public void setBtnConcept(boolean btnConcept) {
        this.btnConcept = btnConcept;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public boolean isBtnVisibleAprobar() {
        return btnVisibleAprobar;
    }

    public void setBtnVisibleAprobar(boolean btnVisibleAprobar) {
        this.btnVisibleAprobar = btnVisibleAprobar;
    }
    
        
    /* Methods */
    
    public void mostrarTodosEstadosPedidos(){
       
      this.setEstadoPedidosList(this.estadoLocal.findAll());
      
    }
    
    public void mostrarTodosPedidos(){
        
        
        //List<Pedidos> lista s this.pedidosLocal.findAll();
        this.setPedidosList(this.pedidosLocal.findAll());
        
        
        List<Contactos> contactTitular;
        
        
        for (Pedidos ordenarContactos : this.getPedidosList()) {
            
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
    }
    
    public void mostrarPedidosPorEstados(){
      
        if(this.getEstadoId()!=0){
            this.setPedidosList(this.pedidosLocal.findAllbyStatus(this.getEstadoId()));
            List<Contactos> contactTitular;

            for (Pedidos ordenarContactos : this.getPedidosList()) {

                ordenarContactos.getContactosId().getId();

                if (ordenarContactos.getContactosId().getHolders_contactos().getId() != 1) {

                    contactTitular = contactosLocal.findAllByTipos(ordenarContactos.getContactosId().getCedula_holder(), 1);

                    ordenarContactos.setCedulaTitular(contactTitular.get(0).getCedula_contacto());
                    ordenarContactos.setNombreCompletoTitular(contactTitular.get(0).getNombre_completo_contacto());
                    ordenarContactos.setNombreCompletoBeneficiario(ordenarContactos.getContactosId().getNombre_completo_contacto());
                } else {
                    ordenarContactos.setCedulaTitular(ordenarContactos.getContactosId().getCedula_contacto());
                    ordenarContactos.setNombreCompletoTitular(ordenarContactos.getContactosId().getNombre_completo_contacto());
                    ordenarContactos.setNombreCompletoBeneficiario(ordenarContactos.getContactosId().getNombre_completo_contacto());
                }
            }
           
            
            if(this.getEstadoId()==EstadoPedidosEnums.PENDIENTE.getValor()){
               this.setBtnVisibleAprobar(false);
               this.setBtnConcept(false);
            }
            if(this.getEstadoId()==EstadoPedidosEnums.EMITIDO.getValor()){
               this.setBtnVisibleAprobar(false);
               this.setBtnConcept(false);
            }
            if(this.getEstadoId()==EstadoPedidosEnums.SUSPENDIDO.getValor()){
               this.setBtnVisibleAprobar(true);
               this.setBtnConcept(true);
            }
            if(this.getEstadoId()==EstadoPedidosEnums.FINALIZADO.getValor()){
              this.setBtnVisibleAprobar(true);
              this.setBtnConcept(false);
            }
        }
        else{
            mostrarTodosPedidos();           
        }
        
            
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Éxito", "Usted Seleccionó:"+this.getEstadoId()));
        RequestContext.getCurrentInstance().update("form:messagePedidos");
        RequestContext.getCurrentInstance().update("form:pedidosTable");
        RequestContext.getCurrentInstance().update("form:btnAprobar");
       
    }
   
}
