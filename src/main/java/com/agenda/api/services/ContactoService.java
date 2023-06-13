package com.agenda.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.api.model.Contacto;
import com.agenda.api.repositories.ContactoRepository;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public Contacto salvar(Contacto contacto) {
        return this.contactoRepository.save(contacto);
    }

    public List<Contacto> listar() {
        return this.contactoRepository.findAll();
    }
}
