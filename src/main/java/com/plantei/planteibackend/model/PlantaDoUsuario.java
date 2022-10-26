package com.plantei.planteibackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class PlantaDoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date idade_planta;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp tempo_sem_regar;

    @Column(nullable = false)
    private String tipo_vaso;

    @ManyToOne(targetEntity = Planta.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_planta")
    private Planta planta;

    @ManyToOne(targetEntity = Usuario.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public PlantaDoUsuario() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getIdade_planta() {
        return idade_planta;
    }

    public Timestamp getTempo_sem_regar() {
        return tempo_sem_regar;
    }

    public String getTipo_vaso() {
        return tipo_vaso;
    }

    public Planta getPlanta() {
        return planta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade_planta(Date idade_planta) {
        this.idade_planta = idade_planta;
    }

    public void setTempo_sem_regar(Timestamp tempo_sem_regar) {
        this.tempo_sem_regar = tempo_sem_regar;
    }

    public void setTipo_vaso(String tipo_vaso) {
        this.tipo_vaso = tipo_vaso;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
