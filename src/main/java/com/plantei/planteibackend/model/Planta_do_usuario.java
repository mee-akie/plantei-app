package com.plantei.planteibackend.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Planta_do_usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_planta_do_usuario")
    private Long id;
	@Column(nullable = false)
	private String nome;
	@Temporal(TemporalType.DATE)
	private Calendar idade_planta;
	@Temporal(TemporalType.TIMESTAMP)
	private Date tempo_sem_regar;
	@Column(nullable = false)
	private String tipo_vaso;
	//idPlanta Foreign Key;
	//idUsuario Foreign Key;

	public Planta_do_usuario() {
    }
	
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public Calendar getIdade_planta() {
    	return idade_planta;
    }
    
    public Date getTempo_sem_regar() {
    	return tempo_sem_regar;
    }
    
    public String getTipo_vaso() {
    	return tipo_vaso;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIdade_planta(Calendar idade_planta) {
    	this.idade_planta = idade_planta;
    }
    
    public void setTempo_sem_regar(Date tempo_sem_regar) {
    	this.tempo_sem_regar = tempo_sem_regar;
    }
    
    public void setTipo_vaso(String tipo_vaso) {
    	this.tipo_vaso = tipo_vaso;
    }
}
