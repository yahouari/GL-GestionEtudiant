package com.springcloudd.service;

import com.springcloudd.dao.ThemeRepository;
import com.springcloudd.entities.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ThemeSerciceImp implements IThemeService {
    @Autowired
    private ThemeRepository themeRepository;
    @Override
    public void save(Theme theme) {

        themeRepository.save(theme);

    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme findByNom(String nom) {
        return themeRepository.findById(nom).orElse(null);
    }
}
