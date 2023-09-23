package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Director;
import org.example.entity.Film;
import org.example.repository.FilmRepository;

import java.util.List;

public class FilmRepositoryImpl extends BaseRepositoryImpl<Film,Long> implements FilmRepository {
  private final EntityManager entityManager;
    public FilmRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Class<Film> getEntityClass() {
        return Film.class;
    }


    @Override
    public List<Film> producedByDirector(Director x) {
      return   entityManager.createQuery("FROM Film film where film.director=? ",Film.class).setParameter(1,x).getResultList();
       // entityManager.createQuery("FROM Film film where film.director=:director  ",Film.class).setParameter("director",x).getResultList();

    }

    @Override
    public List<Film> getScoreMoreThanPoints(int rate) {
        return null;
    }

    @Override
    public Film getMaxLengthOfFilm() {
        return null;
    }

    @Override
    public Director getDirector(Film film) {
        return entityManager.createQuery("from Director d where d=:director", Director.class)
                .setParameter("director",film.getDirector()).getSingleResult();
    }

    @Override
    public List<Film> searchFilm(Film film) {
        CriteriaBuilder createCriteria=entityManager.getCriteriaBuilder();
        CriteriaQuery<Film> query = createCriteria.createQuery(Film.class);
        Root<Film> from = query.from(Film.class);
        Predicate predicate = createCriteria.equal(from.get("name"), "a");
        query.select(from).where(predicate);
         return entityManager.createQuery(query).getResultList();

    }
}
