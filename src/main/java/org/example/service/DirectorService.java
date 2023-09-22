package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.Director;

public interface DirectorService extends BaseService<Director,Long> {
    Director register(Director director);
}
