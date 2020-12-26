package com.springcloudd;

import com.springcloudd.dao.CoursRepository;
import com.springcloudd.entities.Cours;
import com.springcloudd.entities.Difficulte;
import com.springcloudd.entities.Theme;
import com.springcloudd.service.ICoursService;
import com.springcloudd.service.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;

@EnableFeignClients
@SpringBootApplication
public class CoursServiceApplication implements CommandLineRunner {
    @Autowired
    private ICoursService coursService;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private IThemeService iThemeService;

    public static void main(String[] args) {
        SpringApplication.run(CoursServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        coursRepository.deleteAll();

        Theme theme1 = new Theme("AI", null);
        Theme theme2 = new Theme("Programmation", null);

        iThemeService.save(theme1);
        iThemeService.save(theme2);
        iThemeService.save(new Theme("Programmation", null));
        /*Cours cours = new Cours(null, "Bon cours", "Machine Learning", Difficulte.DIFFICILE, 15, "Rien", new ArrayList<>(), new ArrayList<>(), theme1, null, null);
        coursService.save(cours);
        Cours cours3 = new Cours(null, "Bon cours1", "Programmation en C", Difficulte.FACILE, 17, "Rien", new ArrayList<>(), new ArrayList<>(), theme2, null, null);
        coursService.save(cours3);
        Cours cours2 = new Cours(null, "Bon cours2", "Programmation en java", Difficulte.MOYEN, 18, "Rien", new ArrayList<>(), new ArrayList<>(), theme2, null, null);
        coursService.save(cours2);
        Cours cours4 = new Cours(null, "Bon cours3", "Intelligence Artificielle", Difficulte.FACILE, 19, "Rien", new ArrayList<>(), new ArrayList<>(), theme1, null, null);
        coursService.save(cours4);
        Cours cours5 = new Cours(null, "Bon cours3", "Intelligence Artificielle", Difficulte.FACILE, 19, "Rien", new ArrayList<>(), new ArrayList<>(), theme1, null, null);
        coursService.save(cours5);*/
    }

}
