package br.edu.fema.atividadesfixacaojava.enums;

public enum Periodo {

    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno");

    private String descricao;

    Periodo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
