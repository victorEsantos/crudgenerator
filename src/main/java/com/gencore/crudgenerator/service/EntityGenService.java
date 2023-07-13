package com.gencore.crudgenerator.service;

import com.gencore.crudgenerator.controller.dto.EntityModel;

import java.util.List;

import static java.util.Objects.isNull;

public class EntityGenService {
    public static String generate(EntityModel entityModel) {

        String entityBase = """
                import javax.persistence.Entity;
                import javax.persistence.GeneratedValue;
                import javax.persistence.GenerationType;
                import javax.persistence.Id;
                                    
                @Entity
                public class ${entidade} {
                                    
                \t@Id
                \t@GeneratedValue(strategy = GenerationType.IDENTITY)
                \tprivate Long id;
                                    
                    ${atributos}
                                    
                    ${gettersSetters}
                                    
                }""";

        entityBase = entityBase.replace("${entidade}", entityModel.getEntityName());
        entityBase = entityBase.replace("${atributos}", buildAtributos(entityModel.getFields()));
        entityBase = entityBase.replace("${gettersSetters}", buildGettersAndSetters(entityModel));

        return entityBase;
    }

    private static String buildGettersAndSetters(EntityModel entityModel) {

        StringBuilder gettersSetters = new StringBuilder();

        for (EntityModel.FieldModel field : entityModel.getFields()) {
            if (isNull(field.getFieldType()) || isNull(field.getFieldName())) continue;

            String fieldName = field.getFieldName();

            gettersSetters.append("\tpublic ").append(field.getFieldType().getDescricao()).append(" get").append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1)).append("() {\n");
            gettersSetters.append("\t\treturn ").append(fieldName).append(";\n");
            gettersSetters.append("\t}\n\n");
            gettersSetters.append("\tpublic void set").append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1)).append("(").append(field.getFieldType().getDescricao()).append(" ").append(fieldName).append(") {\n");
            gettersSetters.append("\t\tthis.").append(fieldName).append(" = ").append(fieldName).append(";\n");
            gettersSetters.append("\t}\n");
        }

        return gettersSetters.toString();
    }

    private static String buildAtributos(List<EntityModel.FieldModel> fields) {
        StringBuilder atributos = new StringBuilder();

        for (EntityModel.FieldModel field : fields) {
            if (isNull(field.getFieldType()) || isNull(field.getFieldName())) continue;

            atributos.append("\tprivate ").append(field.getFieldType().getDescricao()).append(" ").append(field.getFieldName()).append(";\n\n");
        }

        return atributos.toString();
    }
}
