/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Zergio
 */
public interface IService<VO> {

    void create(VO vo, EntityManager em);

    VO find(Object id, EntityManager em);

    void update(VO vo, EntityManager em);

    void delete(Object id, EntityManager em);

    List<VO> getList(EntityManager em);
}
