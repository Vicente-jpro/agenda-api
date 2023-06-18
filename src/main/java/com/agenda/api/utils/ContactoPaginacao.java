package com.agenda.api.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.agenda.api.model.Contacto;

@Component
public class ContactoPaginacao {

    public Page<Contacto> getPaginacao(List<Contacto> listaContacto, Pageable pageable) {

        int start = (int) (pageable.getOffset() > listaContacto.size() ? listaContacto.size()
                : pageable.getOffset());
        int end = (int) ((start + pageable.getPageSize()) > listaContacto.size()
                ? listaContacto.size()
                : (start + pageable.getPageSize()));

        Page<Contacto> rolesPageList = new PageImpl<>(listaContacto.subList(start, end), pageable,
                listaContacto.size());
        return rolesPageList;

    }
}