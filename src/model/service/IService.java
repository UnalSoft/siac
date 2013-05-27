/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.InvalidAttributeException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.dao.exceptions.RequiredAttributeException;

/**
 *
 * @author Zergio
 */
public interface IService<VO, ID extends Serializable> {

    void create(VO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException;

    VO find(ID id) throws EntityNotFoundException, InsufficientPermissionsException;

    void update(VO vo) throws NonexistentEntityException, RequiredAttributeException, InvalidAttributeException, InsufficientPermissionsException;

    void delete(ID id) throws NonexistentEntityException, InsufficientPermissionsException;

    List<VO> getList();
}
