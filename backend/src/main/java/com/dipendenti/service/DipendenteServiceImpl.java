package com.dipendenti.service;

import com.dipendenti.model.Dipendente;
import com.dipendenti.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Dipendente getDipendenteById(long id) {
        Optional<Dipendente> optional= dipendenteRepository.findById(id);
        Dipendente dipendente= null;
        if(optional.isPresent()){
            dipendente=optional.get();
        }else{
            throw new RuntimeException("Dipendente non trovato");
        }
        return dipendente;
    }

    @Override
    public void deleteDipendenteById(long id) {
        this.dipendenteRepository.deleteById(id);
    }
}
