package org.example.service.impl;

import jakarta.persistence.EntityManager;
import org.example.base.service.BaseServiceImpl;
import org.example.entity.Director;
import org.example.repository.DirectorRepository;
import org.example.service.DirectorService;

public class DirectorServiceImpl extends BaseServiceImpl<Director,Long, DirectorRepository> implements DirectorService {
   private final EntityManager entityManager;
    public DirectorServiceImpl(DirectorRepository repository, EntityManager entityManager) {
        super(repository, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Director register(Director director) {
        return repository.save(director);
    }
}
