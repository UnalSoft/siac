/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "Errores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Error.findAll", query = "SELECT e FROM Error e"),
    @NamedQuery(name = "Error.findById", query = "SELECT e FROM Error e WHERE e.id = :id"),
    @NamedQuery(name = "Error.findByInterfaz", query = "SELECT e FROM Error e WHERE e.interfaz = :interfaz"),
    @NamedQuery(name = "Error.findByError", query = "SELECT e FROM Error e WHERE e.error = :error")})
public class Error implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "interfaz")
    private String interfaz;
    @Basic(optional = false)
    @Column(name = "error")
    private String error;
    @JoinColumn(name = "usuariosDNI", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Usuario usuariosDNI;

    public Error() {
    }

    public Error(Integer id) {
        this.id = id;
    }

    public Error(Integer id, String interfaz, String error) {
        this.id = id;
        this.interfaz = interfaz;
        this.error = error;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(String interfaz) {
        this.interfaz = interfaz;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Usuario getUsuariosDNI() {
        return usuariosDNI;
    }

    public void setUsuariosDNI(Usuario usuariosDNI) {
        this.usuariosDNI = usuariosDNI;
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
        if (!(object instanceof Error)) {
            return false;
        }
        Error other = (Error) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Error[ id=" + id + " ]";
    }
    
}
