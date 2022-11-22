package com.plantei.planteibackend.model;

import java.io.Serializable;

public class ListaFavoritosId implements Serializable {
    private Long id_usuario;

    private Long id_planta;

    public ListaFavoritosId(Long id_usuario, Long id_planta) {
        this.id_usuario = id_usuario;
        this.id_planta = id_planta;
    }

    public ListaFavoritosId() {

    }
}
