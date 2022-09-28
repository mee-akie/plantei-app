package com.plantei.planteibackend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Plantacao {
    @Column(nullable = false)
    private String nome;
    //idUsuario Foreign Key
    //idPlanta_do_Usuario Foreign Key
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
