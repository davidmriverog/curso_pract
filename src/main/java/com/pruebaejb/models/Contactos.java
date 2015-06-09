package com.pruebaejb.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="contactos")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name="Contactos.findAll",query = "SELECT r FROM Contactos r"),
   @NamedQuery(name="Contactos.findAllByTipos",query = "SELECT r FROM Contactos r WHERE r.cedula_holder = :cedula AND r.holders_contactos.id = :holders")
})
public class Contactos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    

    @Column(name="nombres")
    private String nombres_contacto;
    

    @Column(name="apellidos")
    private String apellidos_contacto;
    

    @Column(name="nombre_completo")
    private String nombre_completo_contacto;
    
    @Column(name="cedula")
    private Integer cedula_contacto;
    
    @Column(name="cedula_holder")
    private Integer cedula_holder;
    
    @JoinColumn(name="holder",referencedColumnName="id")
    @ManyToOne(optional=false)
    private Holders holders_contactos;

    // LIST
    @OneToMany(cascade = CascadeType.ALL,mappedBy="contactosId")
    private List<Pedidos> pedidosContactosList;
    

    /* Getter and Setter */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres_contacto() {
        return nombres_contacto;
    }

    public void setNombres_contacto(String nombres_contacto) {
        this.nombres_contacto = nombres_contacto;
    }

    public String getApellidos_contacto() {
        return apellidos_contacto;
    }

    public void setApellidos_contacto(String apellidos_contacto) {
        this.apellidos_contacto = apellidos_contacto;
    }

    public String getNombre_completo_contacto() {
        return nombre_completo_contacto;
    }

    public void setNombre_completo_contacto(String nombre_completo_contacto) {
        this.nombre_completo_contacto = nombre_completo_contacto;
    }

    public Integer getCedula_contacto() {
        return cedula_contacto;
    }

    public void setCedula_contacto(Integer cedula_contacto) {
        this.cedula_contacto = cedula_contacto;
    }

    public Integer getCedula_holder() {
        return cedula_holder;
    }

    public void setCedula_holder(Integer cedula_holder) {
        this.cedula_holder = cedula_holder;
    }

    public Holders getHolders_contactos() {
        return holders_contactos;
    }

    public void setHolders_contactos(Holders holders_contactos) {
        this.holders_contactos = holders_contactos;
    }

    public List<Pedidos> getPedidosContactosList() {
        return pedidosContactosList;
    }

    public void setPedidosContactosList(List<Pedidos> pedidosContactosList) {
        this.pedidosContactosList = pedidosContactosList;
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
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pruebaejb.models.Contactos[ id=" + id + " ]";
    }
    
}
