/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author diegu
 */
@Entity
@Table(name = "estanteria", catalog = "biblioteca", schema = "")
@NamedQueries({
    @NamedQuery(name = "Estanteria.findAll", query = "SELECT e FROM Estanteria e"),
    @NamedQuery(name = "Estanteria.findById", query = "SELECT e FROM Estanteria e WHERE e.id = :id"),
    @NamedQuery(name = "Estanteria.findByCodigo", query = "SELECT e FROM Estanteria e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Estanteria.findByUbicacion", query = "SELECT e FROM Estanteria e WHERE e.ubicacion = :ubicacion"),
    @NamedQuery(name = "Estanteria.findByCompleto", query = "SELECT e FROM Estanteria e WHERE e.completo = :completo")})
public class Estanteria implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo")
    private Character codigo;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @Column(name = "completo")
    private boolean completo;

    public Estanteria() {
    }

    public Estanteria(Integer id) {
        this.id = id;
    }

    public Estanteria(Integer id, Character codigo, boolean completo) {
        this.id = id;
        this.codigo = codigo;
        this.completo = completo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Character getCodigo() {
        return codigo;
    }

    public void setCodigo(Character codigo) {
        Character oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        String oldUbicacion = this.ubicacion;
        this.ubicacion = ubicacion;
        changeSupport.firePropertyChange("ubicacion", oldUbicacion, ubicacion);
    }

    public boolean getCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        boolean oldCompleto = this.completo;
        this.completo = completo;
        changeSupport.firePropertyChange("completo", oldCompleto, completo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estanteria)) {
            return false;
        }
        Estanteria other = (Estanteria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Estanteria[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
