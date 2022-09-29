package com.plantei.planteibackend.model;

import javax.persistence.*;

@Entity
@Table(name = "descricao_planta")
public class DescricaoPlanta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = true)
    String beneficio;

    @Column(nullable = false)
    String area_recomendada;

    @Column(nullable = false)
    String regiao_ideal;

    @Column(nullable = false)
    int iluminacao_ideal;

    @Column(nullable = false)
    int qtd_agua;

    @Column(nullable = false)
    int freq_regar;

    @Column(nullable = false)
    int tempo_colheita;

    @Column(nullable = false)
    int freq_adubagem;

    @Column(nullable = true)
    String modo_de_plantar;

    @OneToOne(mappedBy = "descricaoPlanta")
    private Planta planta;

    public DescricaoPlanta() {
    }

    public DescricaoPlanta(Planta planta) {
//        this.planta = planta;
        this.area_recomendada = "PEQUENO";
        this.regiao_ideal = "";
        this.iluminacao_ideal = 0;
        this.qtd_agua = 0;
        this.freq_regar = 0;
        this.tempo_colheita = 0;
        this.freq_adubagem = 0;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public String getArea_recomendada() {
        return area_recomendada;
    }

    public String getRegiao_ideal() {
        return regiao_ideal;
    }

    public int getIluminacao_ideal() {
        return iluminacao_ideal;
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
        return modo_de_plantar;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setArea_recomendada(String area_recomendada) {
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

    public void setModo_de_plantar(String modo_de_plantar) {
        this.modo_de_plantar = modo_de_plantar;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}
