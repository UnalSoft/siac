/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.io.Serializable;

/**
 *
 * @author Zergio
 */
public class ErrorVO implements IValueObject, Serializable {
    
    private static final long serialVersionUID = 1L;

    //Atributos nativos
    private Integer id;
    private String interfaz;
    private String error;
    //Atributo Externo
    private Long usuariosDNI;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the interfaz
     */
    public String getInterfaz() {
        return interfaz;
    }

    /**
     * @param interfaz the interfaz to set
     */
    public void setInterfaz(String interfaz) {
        this.interfaz = interfaz;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the usuariosDNI
     */
    public Long getUsuariosDNI() {
        return usuariosDNI;
    }

    /**
     * @param usuariosDNI the usuariosDNI to set
     */
    public void setUsuariosDNI(Long usuariosDNI) {
        this.usuariosDNI = usuariosDNI;
    }
}
