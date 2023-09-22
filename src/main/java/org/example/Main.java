package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Director;
import org.example.entity.Film;
import org.example.repository.DirectorRepository;
import org.example.repository.FilmRepository;
import org.example.repository.impl.DirectorRepositoryImpl;
import org.example.repository.impl.FilmRepositoryImpl;
import org.example.service.DirectorService;
import org.example.service.FilmService;
import org.example.service.impl.DirectorServiceImpl;
import org.example.service.impl.FilmServiceImpl;
import org.example.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager=HibernateUtil.getEntityManagerFactory().createEntityManager();
        FilmRepository filmRepository=new FilmRepositoryImpl(entityManager);
        FilmService filmService=new FilmServiceImpl(filmRepository, entityManager);
        DirectorRepository directorRepository=new DirectorRepositoryImpl(entityManager);
        DirectorService directorService=new DirectorServiceImpl(directorRepository, entityManager);
        Director director=new Director("C","D");
        directorService.register(director);
        Film film=Film.builder()
                .title("A")
                .description("B")
                .director(director)
                .length(12)
                .rate(10)
                .language("EN")
                .build();
        Film film1 = filmService.submitFilm(film);
        System.out.println(film1);

    }
}