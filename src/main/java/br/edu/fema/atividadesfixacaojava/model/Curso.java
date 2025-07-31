package br.edu.fema.atividadesfixacaojava.model;

import br.edu.fema.atividadesfixacaojava.enums.Periodo;

import java.util.Objects;

public class Curso {

    private Long id;

    private String descricao;
    private String sigla;
    private String serie;

    private Integer turma;
    private Periodo periodo;

    public Curso(){

    }

    public Curso(Long id,String descricao, String sigla, String serie, Integer turma, Periodo periodo) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
        this.serie = serie;
        this.turma = turma;
        this.periodo = periodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getTurma() {
        return turma;
    }

    public void setTurma(Integer turma) {
        this.turma = turma;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso curso)) return false;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Curso: [" +
                "\n \t\t\tid = " + id +
                "\n \t\t\tdescricao = " + descricao  +
                "\n \t\t\tsigla = " + sigla  +
                "\n \t\t\tserie = " + serie  +
                "\n \t\t\tturma = " + turma +
                "\n \t\t\tperiodo = " + periodo +
                "\n \t\t]";
    }
}
