package com.agenda.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.api.model.Agenda;
import com.agenda.api.repositories.AgendaRepository;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda salvar(Agenda agenda) {
        return this.agendaRepository.save(agenda);
    }

    public List<Agenda> listar() {
        return this.agendaRepository.findAll();
    }
}
