package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Director;
import org.example.repository.DirectorRepository;

public class DirectorRepositoryImpl extends BaseRepositoryImpl<Director,Long> implements DirectorRepository {

private final EntityManager entityManager;
    public DirectorRepositoryImpl( EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Class<Director> getEntityClass() {
        return Director.class;
    }
}
