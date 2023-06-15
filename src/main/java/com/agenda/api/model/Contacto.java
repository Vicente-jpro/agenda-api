package com.agenda.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "Contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Campo nome não pode estar vazio.")
    private String nome;

    @Column(name = "email")
    @NotEmpty(message = "Campo email não pode estar vazio.")
    private String email;

    @Column(name = "favorito")
    @NotEmpty(message = "Campo favorito não pode estar vazio.")
    private boolean favorito;
}
