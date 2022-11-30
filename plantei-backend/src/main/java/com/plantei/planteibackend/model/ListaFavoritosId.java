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
