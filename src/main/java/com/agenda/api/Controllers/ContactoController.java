package com.agenda.api.Controllers;

import java.util.List;

import javax.servlet.http.Part;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.agenda.api.model.Contacto;
import com.agenda.api.services.ContactoService;
import com.agenda.api.utils.ContactoPaginacao;

@RestController
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @Autowired
    private ContactoPaginacao contactoPaginacao;

    @PostMapping
    public Contacto salvar(@RequestBody @Valid Contacto Contacto) {
        return this.contactoService.salvar(Contacto);
    }

    @PatchMapping("/{id}")
    public Contacto atualizar(
            @RequestBody @Valid Contacto Contacto,
            @PathVariable("id") Integer idContacto) {
        return this.contactoService.atualizar(Contacto, idContacto);//
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer idContacto) {
        this.contactoService.eliminar(idContacto);
    }

    @GetMapping("/{id}")
    public Contacto getCliente(@PathVariable("id") Integer idContacto) {
        return this.contactoService.findById(idContacto);
    }

    @GetMapping
    public Page<Contacto> listar(
            @PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        this.contactoPaginacao = new ContactoPaginacao();
        List<Contacto> contactos = this.contactoService.listar();
        Page<Contacto> contactosPaginado = this.contactoPaginacao.getPaginacao(contactos, pageable);

        return contactosPaginado;
    }

    @PutMapping("/{id}/foto")
    public byte[] salvarFoto(
            @PathVariable("id") Integer idContaco,
            @RequestParam("foto") Part arquivo) {
        return this.contactoService.salvarFoto(idContaco, arquivo);
    }
}
