package org.example.repositories;

import org.example.Manager;
import org.example.entities.ArtistEntity;

import javax.persistence.EntityManager;
import java.util.List;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

public class ArtistRepository {

    private EntityManagerFactory emf;

    public ArtistRepository() {
        this.emf = Manager.getEntityManagerFactory();
    }

    public void create(ArtistEntity artist) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(artist);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public ArtistEntity findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(ArtistEntity.class, id);
        } finally {
            em.close();
        }
    }

    public List<ArtistEntity> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Artist.findByName");
            query.setParameter("name", "%" + name + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

