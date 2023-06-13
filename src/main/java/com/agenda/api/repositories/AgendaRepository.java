package com.agenda.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.api.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

}
