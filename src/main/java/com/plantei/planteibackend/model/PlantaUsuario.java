package com.plantei.planteibackend.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.sql.Date;

@Entity
public class PlantaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_planta_do_usuario")
    private Long id;
    @Column(nullable = false)
    private Date idadePlanta;
    @Column(nullable = false)
    private Timestamp tempoSemRegar;
    @Column(nullable = false)
    private String tipoVaso;
    @Column(nullable = false)
    private Long idPlanta;
    @Column(nullable = false)
    private Long idUsuario;

    public PlantaUsuario() {
    }

    public Long getId() {
        return id;
    }

    public Date getIdadePlanta() {
        return idadePlanta;
    }

    public Timestamp getTempoSemRegar() {
        return tempoSemRegar;
    }

    public String getTipoVaso() {
        return tipoVaso;
    }

    public Long getIdPlanta() {
        return idPlanta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdadePlanta(Date idadePlanta) {
        this.idadePlanta = idadePlanta;
    }

    public void setTempoSemRegar(Timestamp tempoSemRegar) {
        this.tempoSemRegar = tempoSemRegar;
    }

    public void setTipoVaso(String tipoVaso) {
        this.tipoVaso = tipoVaso;
    }

    public void setIdPlanta(Long idPlanta) {
        this.idPlanta = idPlanta;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

}
