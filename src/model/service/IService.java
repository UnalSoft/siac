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
public interface IService<Entity> {

    void create(Entity vo, EntityManager em);

    Entity find(Object id, EntityManager em);

    void update(Entity vo, EntityManager em);

    void delete(Object id, EntityManager em);

    List<Entity> getList(EntityManager em);
}
