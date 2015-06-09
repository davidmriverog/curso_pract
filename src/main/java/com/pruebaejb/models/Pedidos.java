package com.pruebaejb.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="pedidos")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Pedidos.findAll",query="SELECT r FROM Pedidos r")
})
public class Pedidos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @JoinColumn(name="contactos_id",referencedColumnName="id")
    @ManyToOne(optional=false)
    private Contactos contactosId;
    
    @Column(name="fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fecha_emision_pedido;
    
    @Column(name="fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fecha_entrega_pedido;
    
    @Column(name="monto_pagar")
    private double monto_pagar_pedido;
    
    // --> Transients
    @Transient
    private Integer cedulaTitular;
    
    @Transient
    private String nombreCompletoTitular;
    
    @Transient
    private String nombreCompletoBeneficiario;
    
    /* Getter and Setter */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contactos getContactosId() {
        return contactosId;
    }

    public void setContactosId(Contactos contactosId) {
        this.contactosId = contactosId;
    }

    public Date getFecha_emision_pedido() {
        return fecha_emision_pedido;
    }

    public void setFecha_emision_pedido(Date fecha_emision_pedido) {
        this.fecha_emision_pedido = fecha_emision_pedido;
    }

    public Date getFecha_entrega_pedido() {
        return fecha_entrega_pedido;
    }

    public void setFecha_entrega_pedido(Date fecha_entrega_pedido) {
        this.fecha_entrega_pedido = fecha_entrega_pedido;
    }

    public double getMonto_pagar_pedido() {
        return monto_pagar_pedido;
    }

    public void setMonto_pagar_pedido(double monto_pagar_pedido) {
        this.monto_pagar_pedido = monto_pagar_pedido;
    }

    public Integer getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(Integer cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public String getNombreCompletoTitular() {
        return nombreCompletoTitular;
    }

    public void setNombreCompletoTitular(String nombreCompletoTitular) {
        this.nombreCompletoTitular = nombreCompletoTitular;
    }

    public String getNombreCompletoBeneficiario() {
        return nombreCompletoBeneficiario;
    }

    public void setNombreCompletoBeneficiario(String nombreCompletoBeneficiario) {
        this.nombreCompletoBeneficiario = nombreCompletoBeneficiario;
    }
    
    
    /* Methods */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pruebaejb.models.Pedidos[ id=" + id + " ]";
    }
    
}
