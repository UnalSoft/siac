/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.List;
import model.entity.Nivel;

/**
 *
 * @author Zergio
 */
public class EmpresaVO implements IValueObject {
    //Atributos nativos

    private Integer nit;
    private String nombre;
    private Nivel nivel;
    private String direccion;
    private String telefono;
    //Atributo externo
    private Integer empresasnit;
    //Colecciones
    private List<UsuarioVO> usuarioList;
    private List<EmpresaVO> empresaList;

    /**
     * @return the nit
     */
    public Integer getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(Integer nit) {
        this.nit = nit;
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
     * @return the nivel
     */
    public Nivel getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the empresasnit
     */
    public Integer getEmpresasnit() {
        return empresasnit;
    }

    /**
     * @param empresasnit the empresasnit to set
     */
    public void setEmpresasnit(Integer empresasnit) {
        this.empresasnit = empresasnit;
    }

    /**
     * @return the usuarioList
     */
    public List<UsuarioVO> getUsuarioList() {
        return usuarioList;
    }

    /**
     * @param usuarioList the usuarioList to set
     */
    public void setUsuarioList(List<UsuarioVO> usuarioList) {
        this.usuarioList = usuarioList;
    }

    /**
     * @return the empresaList
     */
    public List<EmpresaVO> getEmpresaList() {
        return empresaList;
    }

    /**
     * @param empresaList the empresaList to set
     */
    public void setEmpresaList(List<EmpresaVO> empresaList) {
        this.empresaList = empresaList;
    }
}
