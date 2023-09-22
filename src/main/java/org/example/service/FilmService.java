package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.Director;
import org.example.entity.Film;

import java.util.List;

public interface FilmService extends BaseService<Film,Long> {
    Film submitFilm(Film film);
    List<Film> producedByDirector(Director x);
    List<Film>  getScoreMoreThanPoints(int rate);
    Film getMaxLengthOfFilm();
    Director getDirector(Film film);
}
