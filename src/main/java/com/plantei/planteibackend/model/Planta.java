package com.plantei.planteibackend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "planta")
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false)
    private String nome;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id_planta")
    private DescricaoPlanta descricaoPlanta;

    public Planta() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public DescricaoPlanta getDescricaoPlanta() {
        return descricaoPlanta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricaoPlanta(DescricaoPlanta descricaoPlanta) {
        this.descricaoPlanta = descricaoPlanta;
    }
}
