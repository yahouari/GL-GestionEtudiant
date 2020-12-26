package com.springcloudd.service;

import com.springcloudd.entities.Theme;

import java.util.List;

public interface IThemeService {
    public void save(Theme theme);
    public List<Theme> findAll();
    public Theme findByNom(String nom);

}
