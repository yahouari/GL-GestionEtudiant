package com.springcloudd.service;


import com.springcloudd.entities.Cours;

import java.util.List;

public interface ICoursService {
    public void save(Cours cours);
    public List<Cours> findCourses();
    public Cours findById(Long id);
    Cours findByInscriptionsExists(Long id);
    public List<Cours> findByFormateur(String username);
}
