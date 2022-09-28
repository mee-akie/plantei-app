package com.plantei.planteibackend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Descricao_planta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Descricao_planta")
    private Long id;
	@Column(nullable = false)
	private String beneficios;
	@Column(nullable = false)
	private char area_recomendada;
	@Column(nullable = false)
	private String regiao_ideal;
	@Column(nullable = false)
	private int iluminacao_ideal;
	@Column(nullable = false)
	private int qtd_agua;
	@Column(nullable = false)
	private int freq_regar;
	@Column(nullable = false)
	private int tempo_colheita;
	@Column(nullable = false)
	private int freq_adubagem;
	@Column(nullable = false)
	private String Modo_de_plantar;
	//idPlanta Foreign Key
	
    public String getBeneficios() {
        return beneficios;
    }
    
    public char getArea_recomendada() {
        return area_recomendada;
    }
    
    public int getIluminacao_ideal() {
        return iluminacao_ideal;
    }
    
    public String getRegiao_ideal() {
        return regiao_ideal;
    }
    
    public int getQtd_agua() {
        return qtd_agua;
    }
    
    public int getFreq_regar() {
        return freq_regar;
    }
    
    public int getTempo_colheita() {
        return tempo_colheita;
    }

    public int getFreq_adubagem() {
        return freq_adubagem;
    }
    
    public String getModo_de_plantar() {
        return Modo_de_plantar;
    }
    
    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
    

    public void setArea_recomendada(char area_recomendada) {
        this.area_recomendada = area_recomendada;
    }
    

    public void setRegiao_ideal(String regiao_ideal) {
        this.regiao_ideal = regiao_ideal;
    }

    public void setIluminacao_ideal(int iluminacao_ideal) {
        this.iluminacao_ideal = iluminacao_ideal;
    }

    public void setQtd_agua(int qtd_agua) {
        this.qtd_agua = qtd_agua;
    }

    public void setFreq_regar(int freq_regar) {
        this.freq_regar = freq_regar;
    }
    
    public void setTempo_colheita(int tempo_colheita) {
        this.tempo_colheita = tempo_colheita;
    }

    public void setFreq_adubagem(int freq_adubagem) {
        this.freq_adubagem = freq_adubagem;
    }
    
    public void setModo_de_plantar(String Modo_de_plantar) {
        this.Modo_de_plantar = Modo_de_plantar;
    }
}
