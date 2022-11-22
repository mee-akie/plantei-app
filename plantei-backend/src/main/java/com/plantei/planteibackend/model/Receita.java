package com.plantei.planteibackend.model;

import javax.persistence.Column;

public class Receita {
	//idPlanta foreign key
	//idComida foreign key
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String ingredientes;
	@Column(nullable = false)
	private int tempo_preparo;
	@Column(nullable = false)
	private String modo_preparo;

    public String getNome() {
        return nome;
    }
    
    public String getIngredientes() {
        return ingredientes;
    }
    
    public int getTempo_preparo() {
        return tempo_preparo;
    }
    public String getModo_preparo() {
        return modo_preparo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public void setTempo_preparo(int tempo_preparo) {
        this.tempo_preparo = tempo_preparo;
    }
    
    public void setModo_preparo(String modo_preparo) {
        this.modo_preparo = modo_preparo;
    }
}
