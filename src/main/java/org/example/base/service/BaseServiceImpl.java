package org.example.base.service;

import jakarta.persistence.EntityManager;
import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;
    protected final EntityManager entityManager;

    public BaseServiceImpl(R repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public E save(E entity) {
            entityManager.getTransaction().begin();
            repository.save(entity);
            entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public E update(E entity) {
        entityManager.getTransaction().begin();
        repository.update(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Optional<E> loadById(ID id) {
        return Optional.empty();
    }

    @Override
    public List<E> loadAll() {
        return null;
    }

    @Override
    public void remove(E entity) {
        entityManager.getTransaction().begin();
        repository.remove(entity);
        entityManager.getTransaction().commit();

    }
}
