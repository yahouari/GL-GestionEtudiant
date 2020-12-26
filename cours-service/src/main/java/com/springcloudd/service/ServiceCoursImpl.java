package com.springcloudd.service;


import com.springcloudd.dao.CoursRepository;
import com.springcloudd.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServiceCoursImpl implements ICoursService{
    @Autowired
    private CoursRepository coursRepository;
    @Override
    public void save(Cours cours) {
        coursRepository.save(cours);
    }

    @Override
    public List<Cours> findCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours findById(Long id) {
        return coursRepository.findById(id).get();
    }
    public Cours findByInscriptionsExists(Long id){return coursRepository.findByInscriptionsIsContaining(id); }

    @Override
    public List<Cours> findByFormateur(String username) {
        List<Cours> coursList=new ArrayList<>();
        System.out.println(coursRepository.findAll());
        coursRepository.findAll().forEach(cours->{
            cours.getFormateurList().forEach(formateur->{
                System.out.println("For each : "+formateur);
                System.out.println(username);
                if(formateur.equals(username))
                {
                    System.out.println("Add cours : "+formateur);
                    coursList.add(cours);
                }
            });
        });
        System.out.println(coursList);
        return coursList;
    }
}
