package com.agenda.api.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;
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
        if (contactoSalvo != null) {
            contacto.setId(idContacto);
        }
        contacto = this.salvar(contacto);
        return contacto;
    }

    public byte[] salvarFoto(Integer idContacto, Part arquivo) {
        Contacto contacto = this.findById(idContacto);
        try {

            InputStream is = arquivo.getInputStream();
            byte[] bytes = new byte[(int) arquivo.getSize()];
            IOUtils.readFully(is, bytes);
            contacto.setFoto(bytes);
            this.salvar(contacto);
            is.close();

            return bytes;
        } catch (IOException e) {
            return null;
        }

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
