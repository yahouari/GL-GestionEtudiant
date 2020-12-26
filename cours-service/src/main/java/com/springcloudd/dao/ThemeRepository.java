package com.springcloudd.dao;

import com.springcloudd.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme,String> {
}
