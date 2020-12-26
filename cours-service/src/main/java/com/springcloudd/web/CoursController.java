package com.springcloudd.web;

import com.springcloudd.entities.Cours;
import com.springcloudd.entities.Difficulte;
import com.springcloudd.service.ICoursService;
import com.springcloudd.service.IThemeService;
import com.springcloudd.service.InscriptionService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CoursController {
    @Autowired
    private ICoursService iCoursService;
    @Autowired
    private IThemeService iThemeService;
    @Autowired
    private InscriptionService inscriptionService;
    @CrossOrigin(origins = "*")
    @GetMapping("/courses")
    public List<Cours> findCourses() {
        return iCoursService.findCourses();
    }

    @GetMapping("/courses/{id}")
    public Cours findCoursById(@PathVariable Long id) {
        return iCoursService.findById(id);
    }

    @CrossOrigin("*")
    @PostMapping("/saveCourse")
    public int save(@RequestBody CoursForm coursForm) {
        Cours cours = new Cours();
        cours.setDescription(coursForm.getDescription());
        cours.setNom(coursForm.getNom());
        cours.setNombreDePlace(coursForm.getNombreDePlace());
        cours.setPhoto(coursForm.getPhoto());
        cours.setDifficulte(getDifficulte(coursForm.getDifficulte()));
        cours.getFormateurList().add(coursForm.getFormateur());
        cours.setTheme(iThemeService.findByNom(coursForm.getTheme()));
        iCoursService.save(cours);
        return Response.SC_OK;
    }
@CrossOrigin("*")
@GetMapping("/coursesFormateur/{id}")
public List<Cours> getCourses(@PathVariable("id") String userame)
{
    System.out.println(userame);
    System.out.println(iCoursService.findByFormateur(userame));

    return iCoursService.findByFormateur(userame);
}
    @CrossOrigin("*")
    @PostMapping("/saveCoursInscr/{id1}:{id2}")
    public Cours saveInscriptionToCours(@PathVariable("id1") Long idCours, @PathVariable("id2") Long idInscription) {
        Cours cours = iCoursService.findById(idCours);
        System.out.println(idCours);
        System.out.println(cours);
        cours.getInscriptions().add(idInscription);
        iCoursService.save(cours);
        return cours;
    }

    @CrossOrigin("*")
    //@PostMapping("/ajouterCours")
    @GetMapping("cours/{id}")
    public Cours getCours(@PathVariable Long id) {
        return iCoursService.findByInscriptionsExists(id);
    }

    public Difficulte getDifficulte(int x) {
        if (x == 1) {
            return Difficulte.FACILE;
        }
        if (x == 2) {
            return Difficulte.MOYEN;
        }
        if (x == 3) {
            return Difficulte.DIFFICILE;
        }
        return null;
    }
    @CrossOrigin("*")
    @GetMapping("/coursesInscriptions/{id}")
    public List<CoursInscr> getCoursesInscr(@PathVariable("id") String username)
    {
        List<CoursInscr> coursInscrs=new ArrayList<>();
        iCoursService.findByFormateur(username).forEach(cours -> {
            CoursInscr coursInscr=new CoursInscr();
            coursInscr.setCours(cours);
            cours.getInscriptions().forEach(i->{
                coursInscr.getEtudiant().add(inscriptionService.getnameEtudiant(i));
            });
            coursInscrs.add(coursInscr);
        });

        return coursInscrs;
    }
}

@Data @NoArgsConstructor
class CoursForm{
private String nom;
private  String description;
private int nombreDePlace;
private  int difficulte;
private byte[] photo;
private String theme;
private String formateur;

}
@Data
@NoArgsConstructor
class CoursInscr
{
    private Cours cours;
    private List<String> etudiant=new ArrayList<>();
}
