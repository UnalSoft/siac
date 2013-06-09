/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.io.Serializable;
import java.util.List;
import model.entity.Rol;

/**
 *
 * @author Zergio
 */
public class UsuarioVO implements IValueObject, Serializable {
    
    private static final long serialVersionUID = 1L;

    //Atributos Nativos
    private Long dni;
    private String nombre;
    private String nombreDeUsuario;
    private String clave;
    private String correo;
    private Rol rol;
    //Atributo Externo
    private Integer empresasNIT;
    //Colecciones de VOS
    private List<ErrorVO> errorList;

    /**
     * @return the dni
     */
    public Long getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(Long dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nombreDeUsuario
     */
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    /**
     * @param nombreDeUsuario the nombreDeUsuario to set
     */
    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @return the empresasNIT
     */
    public Integer getEmpresasNIT() {
        return empresasNIT;
    }

    /**
     * @param empresasNIT the empresasNIT to set
     */
    public void setEmpresasNIT(Integer empresasNIT) {
        this.empresasNIT = empresasNIT;
    }

    /**
     * @return the errorList
     */
    public List<ErrorVO> getErrorList() {
        return errorList;
    }

    /**
     * @param errorList the errorList to set
     */
    public void setErrorList(List<ErrorVO> errorList) {
        this.errorList = errorList;
    }
}
