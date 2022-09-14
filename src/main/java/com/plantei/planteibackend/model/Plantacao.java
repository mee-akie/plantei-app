package com.plantei.planteibackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Plantacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlantacao;
    @Column
    private Long idUsuario;
    @Column
    private Long idPlanta;
    @Column
    private char tipoVaso;
    @Column
    private Date idade_planta;
    @Column
    private DateTimeZone tempo_sem_regar;

    public Usuario() {
    }

    /**
     * Construtor utilizado para adicionar um novo usuario no banco de dados.
     *
     * @param idPlantacao       Armazena a primary key dessa tabela Plantacao
     * @param idUsuario        Armazena a primary key da tabela Usuario. Assim, conseguimos identificar quais tuplas de dados pertencem a qual usuário.
     * @param idPlanta       Armazena a primary key da tabela Planta. Identificando, assim, qual planta  foi plantada pelo usuário.
     * @param tipoVaso      Armazena o tipo de vaso que a planta foi plantada. Opções disponíveis:
     * @param idade_planta Armazena a idade (data em que foi plantada - data atual) da planta.
     * @param tempo_sem_regar    Armazena a última vez que a planta foi regada (data e hora).
     */
    public Usuario(Long idPlantacao, @NotNull Long idUsuario, @NotNull Long idPlanta, @NotNull char tipoVaso, @NotNull Date idade_planta, @NotNull DateTimeZone tempo_sem_regar) {
        this.idPlantacao = idPlantacao;
        this.idUsuario = idUsuario;
        this.idPlanta = idPlanta;
        this.tipoVaso = tipoVaso;
        this.idade_planta = idade_planta;
        this.tempo_sem_regar = tempo_sem_regar;
    }

    public Long getIdPlantacao() {
        return idPlantacao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdPlanta() {
        return idPlanta;
    }

    public char getTipoVaso() {
        return senha;
    }

    public Date getIdade_planta() {
        return idade_planta;
    }

    public DateTimeZone getTempo_sem_regar() {
        return tempo_sem_regar;
    }

    public void setIdPlantacao(Long IdPlantacao) {
        this.IdPlantacao = IdPlantacao;
    }

    public void setIdUsuario(Long IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public void setidPlanta(Long idPlanta) {
        this.nome = nome;
    }

    public void setTipoVaso(char TipoVaso) {
        this.TipoVaso = TipoVaso;
    }

    public void setIdade_planta(Date Idade_planta) {
        this.Idade_planta = Idade_planta;
    }

    public void setTempo_sem_regar(DateTimeZone Tempo_sem_regar) {
        this.Tempo_sem_regar = Tempo_sem_regar;
    }

}
