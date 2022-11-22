package com.plantei.planteibackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ListaFavoritosId.class)
public class ListaFavoritos {

    @Id
    private Long id_usuario;

    @Id
    private Long id_planta;

    public ListaFavoritos() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public Long getId_planta() {
        return id_planta;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_planta(Long id_planta) {
        this.id_planta = id_planta;
    }
}
