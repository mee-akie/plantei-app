package com.plantei.planteibackend.model;

import javax.persistence.*;

@Entity
public class Comida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

	@Column(nullable = false)
	private String nome;

    @ManyToOne(targetEntity = Planta.class)
    @JoinColumn(name = "id_planta")
    private Planta planta;

    public Comida() {
    }

    public Long getId() {
        return id;
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
