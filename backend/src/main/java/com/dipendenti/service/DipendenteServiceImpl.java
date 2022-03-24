package com.dipendenti.service;

import com.dipendenti.model.Dipendente;
import com.dipendenti.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DipendenteServiceImpl implements DipendenteService{
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Override
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }
}
