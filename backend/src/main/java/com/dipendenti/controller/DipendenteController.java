package com.dipendenti.controller;


import com.dipendenti.model.Dipendente;
import com.dipendenti.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("listaDipenedti",dipendenteService.getAllDipendenti());
        return "index";
    }
    @GetMapping("/nuovoDipendente")
    public String addFormImpiegato(Model model){
        Dipendente dipendente= new Dipendente();
        model.addAttribute("dipendente",dipendente);
        return "nuovoDipendente";
    }
    @PostMapping("/salvaDipendente")
    public String salvaImpiegato(@ModelAttribute("impiegato")Dipendente dipendente){
        dipendenteService.addDipendenti(dipendente);
        return "redirect:/";
    }
}
