package com.plantei.planteibackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ListaFavoritos {
	
    //idUsuario
    //idPlanta_do_Usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @ManyToOne(targetEntity = PlantaDoUsuario.class)
    @JoinColumn(name = "id_planta")
    private Planta planta;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    public Long getId() {
        return id;
    }
    public Planta getPlanta() {
        return planta;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
