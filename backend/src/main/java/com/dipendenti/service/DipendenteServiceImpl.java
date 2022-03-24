package com.dipendenti.service;

import com.dipendenti.model.Dipendente;
import com.dipendenti.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteServiceImpl implements DipendenteService{
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Override
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    @Override
    public void addDipendenti(Dipendente dipendente) {
        this.dipendenteRepository.save(dipendente);
    }
}
