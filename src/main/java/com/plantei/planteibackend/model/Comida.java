package com.plantei.planteibackend.model;

import javax.persistence.Column;

public class Comida {
	@Column(nullable = false)
	private String nome;
	//idPlanta Foreign Key

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
