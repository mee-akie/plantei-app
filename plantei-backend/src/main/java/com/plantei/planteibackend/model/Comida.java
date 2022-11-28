package com.plantei.planteibackend.model;

import javax.persistence.*;

@Entity
public class Comida {

    @Id
    @Column(nullable = false)
    private String nome;

    @ManyToOne(targetEntity = Planta.class)
    @JoinColumn(name = "id_planta")
    private Planta planta;

    public Comida() {
    }

    public String getNome() {
        return nome;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

}
