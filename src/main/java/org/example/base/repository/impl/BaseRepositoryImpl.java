package org.example.base.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable>
        implements BaseRepository<E, ID> {
    protected final EntityManager entityManager;
    public BaseRepositoryImpl(EntityManager entityManager1) {
        this.entityManager = entityManager1;
    }

    @Override
    public E save(E entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        }
        return null;
    }

    @Override
    public E update(E entity) {
        if (entity.getId() != null) {
            entityManager.merge(entity);
            return entity;
        }
        return null;
    }

    @Override
    public Optional<E> loadById(ID id) {

        return Optional.ofNullable(entityManager.find(getEntityClass(), id));

    }

    @Override
    public List<E> loadAll() {
        // select from table name,type of output
        return entityManager.createQuery(" FROM  " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public void remove(E entity) {
        if (entity.getId() != null) {
            entityManager.remove(entity);
        }
        else System.out.println("this entity is not found");
    }

    public abstract Class<E> getEntityClass();
}
