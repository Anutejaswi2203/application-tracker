package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    private ApplicationRepository repository;

    @PostMapping
    public Application addApplication(@RequestBody Application application) {
        return repository.save(application);
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return repository.findAll();
    }
    
    @GetMapping("/applications/view")
    public String viewApplications(Model model) {
        model.addAttribute("applications", repository.findAll());
        return "applications";
    }
}