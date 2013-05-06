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
import model.vo.EmpresaVO;
import model.vo.UsuarioVO;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "Empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByNit", query = "SELECT e FROM Empresa e WHERE e.nit = :nit"),
    @NamedQuery(name = "Empresa.findByNombre", query = "SELECT e FROM Empresa e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empresa.findByNivel", query = "SELECT e FROM Empresa e WHERE e.nivel = :nivel"),
    @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresa.findByTelefono", query = "SELECT e FROM Empresa e WHERE e.telefono = :telefono")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nit")
    private Integer nit;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nivel")
    @Enumerated(EnumType.STRING)
    private Nivel nivel;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresasNIT")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresasnit")
    private Collection<Empresa> empresaCollection;
    @JoinColumn(name = "Empresas_nit", referencedColumnName = "nit")
    @ManyToOne(optional = false)
    private Empresa empresasnit;

    public Empresa() {
    }

    public Empresa(Integer nit) {
        this.nit = nit;
    }

    public Empresa(Integer nit, String nombre, Nivel nivel) {
        this.nit = nit;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
    }

    public Empresa getEmpresasnit() {
        return empresasnit;
    }

    public void setEmpresasnit(Empresa empresasnit) {
        this.empresasnit = empresasnit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Empresa[ nit=" + nit + " ]";
    }

    public EmpresaVO toVO() {
        EmpresaVO empresa = new EmpresaVO();

        empresa.setDireccion(getDireccion());
        empresa.setNit(getNit());
        empresa.setNivel(getNivel());
        empresa.setNombre(getNombre());
        empresa.setTelefono(getTelefono());

        if (getEmpresasnit() != null) {
            empresa.setEmpresasnit(getEmpresasnit().getNit());
        }
        
        ArrayList<EmpresaVO> listEmpresaVO = new ArrayList<EmpresaVO>();
        for (Empresa entity : getEmpresaCollection()) {
            listEmpresaVO.add(entity.toVO());
        }
        
        empresa.setEmpresaList(listEmpresaVO);
        
        ArrayList<UsuarioVO> listUsuarioVO = new ArrayList<UsuarioVO>();
        for (Usuario entity : getUsuarioCollection()) {
            listUsuarioVO.add(entity.toVO());
        }
        
        empresa.setUsuarioList(listUsuarioVO);

        return empresa;
    }
}
