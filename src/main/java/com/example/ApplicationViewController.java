package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationViewController {

    @Autowired
    private ApplicationRepository repository;

    @GetMapping("/applications/view")
    public String viewApplications(Model model) {
        // Retrieve all applications from the database
        model.addAttribute("applications", repository.findAll());
        // Return the name of the Thymeleaf template to render
        return "applications";
    }
}