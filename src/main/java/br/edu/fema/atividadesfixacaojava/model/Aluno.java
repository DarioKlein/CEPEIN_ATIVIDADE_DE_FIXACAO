package br.edu.fema.atividadesfixacaojava.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Aluno {
    private Long id;
    private String nomeCompleto;
    private String dataNascimento;
    private LocalDateTime dataHoraCadastro;
    private Boolean possuiAlgumTipoDeBeneficio;
    private Curso curso;

    public Aluno(){

    }

    public Aluno(Long id, String nomeCompleto, String dataNascimento, LocalDateTime dataHoraCadastro, Boolean possuiAlgumTipoDeBeneficio, Curso curso) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.dataHoraCadastro = dataHoraCadastro;
        this.possuiAlgumTipoDeBeneficio = possuiAlgumTipoDeBeneficio;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Boolean getPossuiAlgumTipoDeBeneficio() {
        return possuiAlgumTipoDeBeneficio;
    }

    public void setPossuiAlgumTipoDeBeneficio(Boolean possuiAlgumTipoDeBeneficio) {
        this.possuiAlgumTipoDeBeneficio = possuiAlgumTipoDeBeneficio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aluno: {" +
                "\n \tid = " + id +
                "\n \tnomeCompleto = " + nomeCompleto +
                "\n \tdataNascimento = " + dataNascimento +
                "\n \tdataHoraCadastro = " + dataHoraCadastro +
                "\n \tpossuiAlgumTipoDeBeneficio = " + possuiAlgumTipoDeBeneficio +
                "\n \tcurso = " + (curso != null ? curso.toString() : null) +
                "\n}";
    }
}
