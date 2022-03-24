package com.dipendenti.controller;


import com.dipendenti.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("listaDipenedti",dipendenteService.getAllDipendenti());
        return "index";
    }
}
