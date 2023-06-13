package com.Contacto.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.api.model.Contacto;
import com.agenda.api.services.ContactoService;

@RestController
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @PostMapping
    public Contacto salvar(@RequestBody Contacto Contacto) {
        return this.contactoService.salvar(Contacto);
    }

    @GetMapping
    public List<Contacto> listar() {
        return this.contactoService.listar();
    }
}
