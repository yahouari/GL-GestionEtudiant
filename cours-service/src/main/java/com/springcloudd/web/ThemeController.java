package com.springcloudd.web;

import com.springcloudd.entities.Theme;
import com.springcloudd.service.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThemeController {
    @Autowired
    private IThemeService iThemeService;
    @CrossOrigin("*")
    @GetMapping("/themes")
    public List<Theme> getThemes(){
        return iThemeService.findAll();
    }
}
