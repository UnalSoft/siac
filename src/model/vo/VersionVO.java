/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class VersionVO implements IValueObject, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //Atributos Nativos
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    
}
