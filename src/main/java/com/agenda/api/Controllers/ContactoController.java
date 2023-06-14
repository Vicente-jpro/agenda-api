package com.agenda.api.Controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @PatchMapping("/{id}")
    public Contacto salvar(
            @RequestBody Contacto Contacto,
            @PathParam("id") Integer idContacto) {
        return this.contactoService.salvar(Contacto);
    }

    @DeleteMapping("/{id}")
    public Contacto salvar(@PathParam("id") Integer idContacto) {
        return this.contactoService.
    }

    @GetMapping
    public List<Contacto> listar() {
        return this.contactoService.listar();
    }
}
