package com.agenda.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.api.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

}
