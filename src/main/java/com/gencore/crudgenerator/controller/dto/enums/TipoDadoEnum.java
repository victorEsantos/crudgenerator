package com.gencore.crudgenerator.controller.dto.enums;

public enum TipoDadoEnum {
    STRING("String"),
    INTEGER("Integer"),
    INT("int"),
    BOOLEAN("Boolean"),
    BOL("boolean");

    private String descricao;

    TipoDadoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
