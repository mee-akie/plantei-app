package com.plantei.planteibackend.model;

import javax.persistence.*;

@Entity
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private Long idDescricaoPlanta;

    public Planta() {
    }

    public Planta(String nome, Long idDescricaoPlanta) {
        this.nome = nome;
        this.idDescricaoPlanta = idDescricaoPlanta;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdDescricaoPlanta() {
        return idDescricaoPlanta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdDescricaoPlanta(Long idDescricaoPlanta) {
        this.idDescricaoPlanta = idDescricaoPlanta;
    }
}
