package com.agenda.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.api.exceptions.ContactoException;
import com.agenda.api.model.Contacto;
import com.agenda.api.repositories.ContactoRepository;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public Contacto salvar(Contacto contacto) {
        return this.contactoRepository.save(contacto);
    }

    public Contacto atualizar(Contacto contacto, Integer idContacto) {
        Contacto contactoSalvo = this.findById(idContacto);
        contacto.setId(contactoSalvo.getId());
        return this.salvar(contacto);
    }

    public Contacto findById(Integer idContacto) {
        return this.contactoRepository
                .findById(idContacto)
                .orElseThrow(() -> new ContactoException("Contacto não encontrado. "
                        + "Id Invalido :" + idContacto));
    }

    public List<Contacto> listar() {
        return this.contactoRepository.findAll();
    }

    public void eliminar(Integer idContacto) {
        this.contactoRepository.deleteById(idContacto);
    }
}
