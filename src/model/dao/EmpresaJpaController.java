/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.entity.Empresa;
import model.entity.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.dao.exceptions.IllegalOrphanException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;

/**
 *
 * @author Felipe
 */
public class EmpresaJpaController implements Serializable {

    public EmpresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresa empresa) throws PreexistingEntityException, Exception {
        if (empresa.getUsuarioCollection() == null) {
            empresa.setUsuarioCollection(new ArrayList<Usuario>());
        }
        if (empresa.getEmpresaCollection() == null) {
            empresa.setEmpresaCollection(new ArrayList<Empresa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresasnit = empresa.getEmpresasnit();
            if (empresasnit != null) {
                empresasnit = em.getReference(empresasnit.getClass(), empresasnit.getNit());
                empresa.setEmpresasnit(empresasnit);
            }
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : empresa.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getDni());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            empresa.setUsuarioCollection(attachedUsuarioCollection);
            Collection<Empresa> attachedEmpresaCollection = new ArrayList<Empresa>();
            for (Empresa empresaCollectionEmpresaToAttach : empresa.getEmpresaCollection()) {
                empresaCollectionEmpresaToAttach = em.getReference(empresaCollectionEmpresaToAttach.getClass(), empresaCollectionEmpresaToAttach.getNit());
                attachedEmpresaCollection.add(empresaCollectionEmpresaToAttach);
            }
            empresa.setEmpresaCollection(attachedEmpresaCollection);
            em.persist(empresa);
            if (empresasnit != null) {
                empresasnit.getEmpresaCollection().add(empresa);
                empresasnit = em.merge(empresasnit);
            }
            for (Usuario usuarioCollectionUsuario : empresa.getUsuarioCollection()) {
                Empresa oldEmpresasNITOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getEmpresasNIT();
                usuarioCollectionUsuario.setEmpresasNIT(empresa);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldEmpresasNITOfUsuarioCollectionUsuario != null) {
                    oldEmpresasNITOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldEmpresasNITOfUsuarioCollectionUsuario = em.merge(oldEmpresasNITOfUsuarioCollectionUsuario);
                }
            }
            for (Empresa empresaCollectionEmpresa : empresa.getEmpresaCollection()) {
                Empresa oldEmpresasnitOfEmpresaCollectionEmpresa = empresaCollectionEmpresa.getEmpresasnit();
                empresaCollectionEmpresa.setEmpresasnit(empresa);
                empresaCollectionEmpresa = em.merge(empresaCollectionEmpresa);
                if (oldEmpresasnitOfEmpresaCollectionEmpresa != null) {
                    oldEmpresasnitOfEmpresaCollectionEmpresa.getEmpresaCollection().remove(empresaCollectionEmpresa);
                    oldEmpresasnitOfEmpresaCollectionEmpresa = em.merge(oldEmpresasnitOfEmpresaCollectionEmpresa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresa(empresa.getNit()) != null) {
                throw new PreexistingEntityException("Empresa " + empresa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresa empresa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa persistentEmpresa = em.find(Empresa.class, empresa.getNit());
            Empresa empresasnitOld = persistentEmpresa.getEmpresasnit();
            Empresa empresasnitNew = empresa.getEmpresasnit();
            Collection<Usuario> usuarioCollectionOld = persistentEmpresa.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = empresa.getUsuarioCollection();
            Collection<Empresa> empresaCollectionOld = persistentEmpresa.getEmpresaCollection();
            Collection<Empresa> empresaCollectionNew = empresa.getEmpresaCollection();
            List<String> illegalOrphanMessages = null;
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usuario " + usuarioCollectionOldUsuario + " since its empresasNIT field is not nullable.");
                }
            }
            for (Empresa empresaCollectionOldEmpresa : empresaCollectionOld) {
                if (!empresaCollectionNew.contains(empresaCollectionOldEmpresa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empresa " + empresaCollectionOldEmpresa + " since its empresasnit field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empresasnitNew != null) {
                empresasnitNew = em.getReference(empresasnitNew.getClass(), empresasnitNew.getNit());
                empresa.setEmpresasnit(empresasnitNew);
            }
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getDni());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            empresa.setUsuarioCollection(usuarioCollectionNew);
            Collection<Empresa> attachedEmpresaCollectionNew = new ArrayList<Empresa>();
            for (Empresa empresaCollectionNewEmpresaToAttach : empresaCollectionNew) {
                empresaCollectionNewEmpresaToAttach = em.getReference(empresaCollectionNewEmpresaToAttach.getClass(), empresaCollectionNewEmpresaToAttach.getNit());
                attachedEmpresaCollectionNew.add(empresaCollectionNewEmpresaToAttach);
            }
            empresaCollectionNew = attachedEmpresaCollectionNew;
            empresa.setEmpresaCollection(empresaCollectionNew);
            empresa = em.merge(empresa);
            if (empresasnitOld != null && !empresasnitOld.equals(empresasnitNew)) {
                empresasnitOld.getEmpresaCollection().remove(empresa);
                empresasnitOld = em.merge(empresasnitOld);
            }
            if (empresasnitNew != null && !empresasnitNew.equals(empresasnitOld)) {
                empresasnitNew.getEmpresaCollection().add(empresa);
                empresasnitNew = em.merge(empresasnitNew);
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Empresa oldEmpresasNITOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getEmpresasNIT();
                    usuarioCollectionNewUsuario.setEmpresasNIT(empresa);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldEmpresasNITOfUsuarioCollectionNewUsuario != null && !oldEmpresasNITOfUsuarioCollectionNewUsuario.equals(empresa)) {
                        oldEmpresasNITOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldEmpresasNITOfUsuarioCollectionNewUsuario = em.merge(oldEmpresasNITOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            for (Empresa empresaCollectionNewEmpresa : empresaCollectionNew) {
                if (!empresaCollectionOld.contains(empresaCollectionNewEmpresa)) {
                    Empresa oldEmpresasnitOfEmpresaCollectionNewEmpresa = empresaCollectionNewEmpresa.getEmpresasnit();
                    empresaCollectionNewEmpresa.setEmpresasnit(empresa);
                    empresaCollectionNewEmpresa = em.merge(empresaCollectionNewEmpresa);
                    if (oldEmpresasnitOfEmpresaCollectionNewEmpresa != null && !oldEmpresasnitOfEmpresaCollectionNewEmpresa.equals(empresa)) {
                        oldEmpresasnitOfEmpresaCollectionNewEmpresa.getEmpresaCollection().remove(empresaCollectionNewEmpresa);
                        oldEmpresasnitOfEmpresaCollectionNewEmpresa = em.merge(oldEmpresasnitOfEmpresaCollectionNewEmpresa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empresa.getNit();
                if (findEmpresa(id) == null) {
                    throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresa;
            try {
                empresa = em.getReference(Empresa.class, id);
                empresa.getNit();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Usuario> usuarioCollectionOrphanCheck = empresa.getUsuarioCollection();
            for (Usuario usuarioCollectionOrphanCheckUsuario : usuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Usuario " + usuarioCollectionOrphanCheckUsuario + " in its usuarioCollection field has a non-nullable empresasNIT field.");
            }
            Collection<Empresa> empresaCollectionOrphanCheck = empresa.getEmpresaCollection();
            for (Empresa empresaCollectionOrphanCheckEmpresa : empresaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Empresa " + empresaCollectionOrphanCheckEmpresa + " in its empresaCollection field has a non-nullable empresasnit field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empresa empresasnit = empresa.getEmpresasnit();
            if (empresasnit != null) {
                empresasnit.getEmpresaCollection().remove(empresa);
                empresasnit = em.merge(empresasnit);
            }
            em.remove(empresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresa> findEmpresaEntities() {
        return findEmpresaEntities(true, -1, -1);
    }

    public List<Empresa> findEmpresaEntities(int maxResults, int firstResult) {
        return findEmpresaEntities(false, maxResults, firstResult);
    }

    private List<Empresa> findEmpresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Empresa findEmpresa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresa> rt = cq.from(Empresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
