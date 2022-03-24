package com.dipendenti.controller;


import com.dipendenti.model.Dipendente;
import com.dipendenti.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        //Deve essere uguale al nome del template che bisogna reindirizzare
        return "nuovoDipendente";
    }
    @PostMapping("/salvaDipendente")
    public String salvaImpiegato(@ModelAttribute("impiegato")Dipendente dipendente){
        dipendenteService.addDipendenti(dipendente);
        return "redirect:/";
    }
    //l'id dell'utente viene accodato all'url e passato alla funzione tramite l'annotazione
    @GetMapping("/formUpdate/{id}")
    public String formUpdate(@PathVariable(value="id") long id, Model model){
        Dipendente dipendente= dipendenteService.getDipendenteById(id);
        model.addAttribute("dipendente",dipendente);
        return "formUpdate";
    }
    @GetMapping("/deleteDipendente/{id}")
    public String deleteDipendente(@PathVariable(value="id")long id, Model model){

        dipendenteService.deleteDipendenteById(id);
        return "redirect:/";
    }
}
