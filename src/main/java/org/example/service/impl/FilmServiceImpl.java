package org.example.service.impl;

import jakarta.persistence.EntityManager;
import org.example.base.service.BaseServiceImpl;
import org.example.entity.Director;
import org.example.entity.Film;
import org.example.repository.FilmRepository;
import org.example.service.FilmService;

import java.util.List;

public class FilmServiceImpl extends BaseServiceImpl<Film,Long, FilmRepository> implements FilmService {
private final EntityManager entityManager;
    public FilmServiceImpl(FilmRepository repository, EntityManager entityManager) {
        super(repository, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Film submitFilm(Film film) {
        entityManager.getTransaction().begin();
         repository.save(film);
         entityManager.getTransaction().commit();
         return film;
    }

    @Override
    public List<Film> producedByDirector(Director x) {
        return repository.producedByDirector(x);
    }

    @Override
    public List<Film> getScoreMoreThanPoints(int rate) {
        return repository.getScoreMoreThanPoints(rate);
    }

    @Override
    public Film getMaxLengthOfFilm() {
        return repository.getMaxLengthOfFilm();
    }

    @Override
    public Director getDirector(Film film) {
        return repository.getDirector(film);
    }
}
