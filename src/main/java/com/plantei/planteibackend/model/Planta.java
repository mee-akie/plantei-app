package com.plantei.planteibackend.model;

import javax.persistence.*;

@Entity
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_planta")
    private Long id;
    @Column(nullable = false)
    private String nome;

    public Planta() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
