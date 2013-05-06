/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.vo.ErrorVO;
import model.vo.UsuarioVO;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByDni", query = "SELECT u FROM Usuario u WHERE u.dni = :dni"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByNombreDeUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreDeUsuario = :nombreDeUsuario"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private Long dni;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nombreDeUsuario")
    private String nombreDeUsuario;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @JoinColumn(name = "empresasNIT", referencedColumnName = "nit")
    @ManyToOne(optional = false)
    private Empresa empresasNIT;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosDNI")
    private Collection<Error> errorCollection;

    public Usuario() {
    }

    public Usuario(Long dni) {
        this.dni = dni;
    }

    public Usuario(Long dni, String nombre, String nombreDeUsuario, String clave, String correo, Rol rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.nombreDeUsuario = nombreDeUsuario;
        this.clave = clave;
        this.correo = correo;
        this.rol = rol;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empresa getEmpresasNIT() {
        return empresasNIT;
    }

    public void setEmpresasNIT(Empresa empresasNIT) {
        this.empresasNIT = empresasNIT;
    }

    @XmlTransient
    public Collection<Error> getErrorCollection() {
        return errorCollection;
    }

    public void setErrorCollection(Collection<Error> errorCollection) {
        this.errorCollection = errorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Usuario[ dni=" + dni + " ]";
    }

    public UsuarioVO toVO() {

        UsuarioVO usuario = new UsuarioVO();

        usuario.setClave(getClave());
        usuario.setCorreo(getCorreo());
        usuario.setDni(getDni());
        usuario.setNombre(getNombre());
        usuario.setNombreDeUsuario(getNombreDeUsuario());
        usuario.setRol(getRol());

        if (getEmpresasNIT() != null) {
            usuario.setEmpresasNIT(getEmpresasNIT().getNit());
        }

        ArrayList<ErrorVO> listErrorVO = new ArrayList<ErrorVO>();
        for (Error entity : getErrorCollection()) {
            listErrorVO.add(entity.toVO());
        }
        
        usuario.setErrorList(listErrorVO);
        
        return usuario;
    }
}
