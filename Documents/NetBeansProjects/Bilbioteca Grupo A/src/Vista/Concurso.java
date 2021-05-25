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
@Table(name = "concurso", catalog = "biblioteca", schema = "")
@NamedQueries({
    @NamedQuery(name = "Concurso.findAll", query = "SELECT c FROM Concurso c")
    , @NamedQuery(name = "Concurso.findByIdEvento", query = "SELECT c FROM Concurso c WHERE c.idEvento = :idEvento")
    , @NamedQuery(name = "Concurso.findByTipo", query = "SELECT c FROM Concurso c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Concurso.findByPremio", query = "SELECT c FROM Concurso c WHERE c.premio = :premio")})
public class Concurso implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEvento")
    private Integer idEvento;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "premio")
    private String premio;

    public Concurso() {
    }

    public Concurso(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Concurso(Integer idEvento, String tipo, String premio) {
        this.idEvento = idEvento;
        this.tipo = tipo;
        this.premio = premio;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        Integer oldIdEvento = this.idEvento;
        this.idEvento = idEvento;
        changeSupport.firePropertyChange("idEvento", oldIdEvento, idEvento);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        String oldPremio = this.premio;
        this.premio = premio;
        changeSupport.firePropertyChange("premio", oldPremio, premio);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concurso)) {
            return false;
        }
        Concurso other = (Concurso) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Concurso[ idEvento=" + idEvento + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
