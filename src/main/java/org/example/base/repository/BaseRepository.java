package org.example.base.repository;

import org.example.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository <E extends BaseEntity<ID>, ID extends Serializable> {
    E save(E entity);
    E update(E entity);
    Optional<E> loadById(ID id);
    List<E> loadAll();
    void remove(E entity);
}
