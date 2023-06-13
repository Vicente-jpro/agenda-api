package com.agenda.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenda.api.model.Agenda;
import com.agenda.api.services.AgendaService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public Agenda salvar(@RequestBody Agenda agenda) {
        return this.agendaService.salvar(agenda);
    }
}
