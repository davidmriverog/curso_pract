package com.pruebaejb.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="holders")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name="Holders.findAll",query="SELECT r FROM Holders r")
})
public class Holders implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;
    
    @Column(name="nombre")
    private String nombre_holder;
    

    /* Getter and Setter */
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_holder() {
        return nombre_holder;
    }

    public void setNombre_holder(String nombre_holder) {
        this.nombre_holder = nombre_holder;
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
        if (!(object instanceof Holders)) {
            return false;
        }
        Holders other = (Holders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pruebaejb.models.Holders[ id=" + id + " ]";
    }
    
}
