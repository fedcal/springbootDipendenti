package com.dipendenti.service;

import com.dipendenti.model.Dipendente;

import java.util.List;

public interface DipendenteService {
    List<Dipendente> getAllDipendenti();
    void addDipendenti(Dipendente dipendente);
    Dipendente getDipendenteById(long id);
    void deleteDipendenteById(long id);
}
