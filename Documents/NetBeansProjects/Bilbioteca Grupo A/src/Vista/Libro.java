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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Vicente Urrutia
 */
@Entity
@Table(name = "libro", catalog = "biblioteca", schema = "")
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByIdElemento", query = "SELECT l FROM Libro l WHERE l.idElemento = :idElemento")
    , @NamedQuery(name = "Libro.findByNombre", query = "SELECT l FROM Libro l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Libro.findByEditorial", query = "SELECT l FROM Libro l WHERE l.editorial = :editorial")
    , @NamedQuery(name = "Libro.findByAutor", query = "SELECT l FROM Libro l WHERE l.autor = :autor")
    , @NamedQuery(name = "Libro.findByNPaginas", query = "SELECT l FROM Libro l WHERE l.nPaginas = :nPaginas")
    , @NamedQuery(name = "Libro.findByIdEventoLectura", query = "SELECT l FROM Libro l WHERE l.idEventoLectura = :idEventoLectura")})
public class Libro implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idElemento")
    private Integer idElemento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "editorial")
    private String editorial;
    @Basic(optional = false)
    @Column(name = "autor")
    private String autor;
    @Column(name = "nPaginas")
    private Integer nPaginas;
    @Column(name = "idEventoLectura")
    private Integer idEventoLectura;

    public Libro() {
    }

    public Libro(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public Libro(Integer idElemento, String nombre, String editorial, String autor) {
        this.idElemento = idElemento;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        Integer oldIdElemento = this.idElemento;
        this.idElemento = idElemento;
        changeSupport.firePropertyChange("idElemento", oldIdElemento, idElemento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        String oldEditorial = this.editorial;
        this.editorial = editorial;
        changeSupport.firePropertyChange("editorial", oldEditorial, editorial);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        String oldAutor = this.autor;
        this.autor = autor;
        changeSupport.firePropertyChange("autor", oldAutor, autor);
    }

    public Integer getNPaginas() {
        return nPaginas;
    }

    public void setNPaginas(Integer nPaginas) {
        Integer oldNPaginas = this.nPaginas;
        this.nPaginas = nPaginas;
        changeSupport.firePropertyChange("NPaginas", oldNPaginas, nPaginas);
    }

    public Integer getIdEventoLectura() {
        return idEventoLectura;
    }

    public void setIdEventoLectura(Integer idEventoLectura) {
        Integer oldIdEventoLectura = this.idEventoLectura;
        this.idEventoLectura = idEventoLectura;
        changeSupport.firePropertyChange("idEventoLectura", oldIdEventoLectura, idEventoLectura);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idElemento != null ? idElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idElemento == null && other.idElemento != null) || (this.idElemento != null && !this.idElemento.equals(other.idElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Libro[ idElemento=" + idElemento + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
