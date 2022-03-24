package com.dipendenti.repository;

import com.dipendenti.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {
}
