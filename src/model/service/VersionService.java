/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import javax.persistence.EntityNotFoundException;
import model.dao.DAOFactory;
import model.entity.Version;
import model.vo.VersionVO;

/**
 *
 * @author Felipe
 */
public class VersionService {

    public VersionService() {
    }
        
    private static VersionService instance;
    
    public static synchronized VersionService getInstance() {
        if (instance == null) {
            instance = new VersionService();
        }
        return instance;
    }
    
    public VersionVO getVersion() throws EntityNotFoundException {
        //TODO obtener la version del programa 
        Version version = DAOFactory.getInstance().getVersionDAO().getList();
        if (version != null) {
            return version.toVO();
        } else {
            return null;
        }
    }
}
