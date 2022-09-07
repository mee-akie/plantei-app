package com.plantei.planteibackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String nome;
    @Column
    private String senha;
    @Column
    private String regiao;
    @Column
    private boolean notificacoes;
    @Column
    private String objetivo;
    @Column
    private String area;
    @Column
    private Long iluminacao;

    public Usuario() {
    }

    /**
     * Construtor utilizado para adicionar um novo usuario no banco de dados.
     *
     * @param email        Email do usuario que sera utilizado no momento do Login no app.
     * @param nome         Nome completo do novo usuario.
     * @param senha        Senha do novo usuario que sera utilizado no momento do Login no app.
     * @param regiao       Regiao da residencia do usuario.
     * @param notificacoes Opcao de ativacao/desativacao das notificacoes do app.
     * @param objetivo     Objetivo principal de uso do app pelo usuario.
     * @param area         Tamanho do local que o usuario tem disponivel para suas plantacoes.
     * @param iluminacao   Iluminacao do local disponivel para o usuario cultivar suas plantacoes.
     */
    public Usuario(Long id, @NotNull String email, @NotNull String nome, @NotNull String senha, @NotNull String regiao, @NotNull boolean notificacoes, @NotNull String objetivo, @NotNull String area, @NotNull Long iluminacao) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.regiao = regiao;
        this.notificacoes = notificacoes;
        this.objetivo = objetivo;
        this.area = area;
        this.iluminacao = iluminacao;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getRegiao() {
        return regiao;
    }

    public boolean getNotificacoes() {
        return notificacoes;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getArea() {
        return area;
    }

    public Long getIluminacao() {
        return iluminacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setNotificacoes(boolean notificacoes) {
        this.notificacoes = notificacoes;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setIluminacao(Long iluminacao) {
        this.iluminacao = iluminacao;
    }

}
