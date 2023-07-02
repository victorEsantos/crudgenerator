package com.gencore.crudgenerator.controller.dto;


import com.gencore.crudgenerator.controller.dto.enums.TipoDadoEnum;
import lombok.Data;

import java.util.List;

@Data
public class EntityModel {

    private String entityName;
    private List<FieldModel> fields;

    @Data
    public static class FieldModel {

        private String fieldName;
        private TipoDadoEnum fieldType;

    }

}
