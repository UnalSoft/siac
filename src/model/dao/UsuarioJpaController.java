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
import model.entity.Error;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.dao.exceptions.IllegalOrphanException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.entity.Usuario;

/**
 *
 * @author Felipe
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        if (usuario.getErrorCollection() == null) {
            usuario.setErrorCollection(new ArrayList<Error>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresasNIT = usuario.getEmpresasNIT();
            if (empresasNIT != null) {
                empresasNIT = em.getReference(empresasNIT.getClass(), empresasNIT.getNit());
                usuario.setEmpresasNIT(empresasNIT);
            }
            Collection<Error> attachedErrorCollection = new ArrayList<Error>();
            for (Error errorCollectionErrorToAttach : usuario.getErrorCollection()) {
                errorCollectionErrorToAttach = em.getReference(errorCollectionErrorToAttach.getClass(), errorCollectionErrorToAttach.getId());
                attachedErrorCollection.add(errorCollectionErrorToAttach);
            }
            usuario.setErrorCollection(attachedErrorCollection);
            em.persist(usuario);
            if (empresasNIT != null) {
                empresasNIT.getUsuarioCollection().add(usuario);
                empresasNIT = em.merge(empresasNIT);
            }
            for (Error errorCollectionError : usuario.getErrorCollection()) {
                Usuario oldUsuariosDNIOfErrorCollectionError = errorCollectionError.getUsuariosDNI();
                errorCollectionError.setUsuariosDNI(usuario);
                errorCollectionError = em.merge(errorCollectionError);
                if (oldUsuariosDNIOfErrorCollectionError != null) {
                    oldUsuariosDNIOfErrorCollectionError.getErrorCollection().remove(errorCollectionError);
                    oldUsuariosDNIOfErrorCollectionError = em.merge(oldUsuariosDNIOfErrorCollectionError);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getDni()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getDni());
            Empresa empresasNITOld = persistentUsuario.getEmpresasNIT();
            Empresa empresasNITNew = usuario.getEmpresasNIT();
            Collection<Error> errorCollectionOld = persistentUsuario.getErrorCollection();
            Collection<Error> errorCollectionNew = usuario.getErrorCollection();
            List<String> illegalOrphanMessages = null;
            for (Error errorCollectionOldError : errorCollectionOld) {
                if (!errorCollectionNew.contains(errorCollectionOldError)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Error " + errorCollectionOldError + " since its usuariosDNI field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empresasNITNew != null) {
                empresasNITNew = em.getReference(empresasNITNew.getClass(), empresasNITNew.getNit());
                usuario.setEmpresasNIT(empresasNITNew);
            }
            Collection<Error> attachedErrorCollectionNew = new ArrayList<Error>();
            for (Error errorCollectionNewErrorToAttach : errorCollectionNew) {
                errorCollectionNewErrorToAttach = em.getReference(errorCollectionNewErrorToAttach.getClass(), errorCollectionNewErrorToAttach.getId());
                attachedErrorCollectionNew.add(errorCollectionNewErrorToAttach);
            }
            errorCollectionNew = attachedErrorCollectionNew;
            usuario.setErrorCollection(errorCollectionNew);
            usuario = em.merge(usuario);
            if (empresasNITOld != null && !empresasNITOld.equals(empresasNITNew)) {
                empresasNITOld.getUsuarioCollection().remove(usuario);
                empresasNITOld = em.merge(empresasNITOld);
            }
            if (empresasNITNew != null && !empresasNITNew.equals(empresasNITOld)) {
                empresasNITNew.getUsuarioCollection().add(usuario);
                empresasNITNew = em.merge(empresasNITNew);
            }
            for (Error errorCollectionNewError : errorCollectionNew) {
                if (!errorCollectionOld.contains(errorCollectionNewError)) {
                    Usuario oldUsuariosDNIOfErrorCollectionNewError = errorCollectionNewError.getUsuariosDNI();
                    errorCollectionNewError.setUsuariosDNI(usuario);
                    errorCollectionNewError = em.merge(errorCollectionNewError);
                    if (oldUsuariosDNIOfErrorCollectionNewError != null && !oldUsuariosDNIOfErrorCollectionNewError.equals(usuario)) {
                        oldUsuariosDNIOfErrorCollectionNewError.getErrorCollection().remove(errorCollectionNewError);
                        oldUsuariosDNIOfErrorCollectionNewError = em.merge(oldUsuariosDNIOfErrorCollectionNewError);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuario.getDni();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Error> errorCollectionOrphanCheck = usuario.getErrorCollection();
            for (Error errorCollectionOrphanCheckError : errorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Error " + errorCollectionOrphanCheckError + " in its errorCollection field has a non-nullable usuariosDNI field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empresa empresasNIT = usuario.getEmpresasNIT();
            if (empresasNIT != null) {
                empresasNIT.getUsuarioCollection().remove(usuario);
                empresasNIT = em.merge(empresasNIT);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
