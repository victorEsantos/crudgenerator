package com.gencore.crudgenerator.service;


import com.gencore.crudgenerator.controller.dto.EntityModel;

public class EntityGenService {
    public static String generate(EntityModel entityModel) {
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder.append("import javax.persistence.Entity;\n");
        codeBuilder.append("import javax.persistence.GeneratedValue;\n");
        codeBuilder.append("import javax.persistence.GenerationType;\n");
        codeBuilder.append("import javax.persistence.Id;\n\n");
        codeBuilder.append("@Entity\n");
        codeBuilder.append("public class ").append(entityModel.getEntityName()).append(" {\n\n");
        codeBuilder.append("\t@Id\n");
        codeBuilder.append("\t@GeneratedValue(strategy = GenerationType.IDENTITY)\n");
        codeBuilder.append("\tprivate Long id;\n");

        for (EntityModel.FieldModel field : entityModel.getFields()) {
            if(field.getFieldType() == null) continue;
            codeBuilder.append("\tprivate ").append(field.getFieldType().getDescricao()).append(" ").append(field.getFieldName()).append(";\n");
        }

        codeBuilder.append("\n");
        codeBuilder.append("\t// Getters and Setters\n");

        for (EntityModel.FieldModel field : entityModel.getFields()) {
            if(field.getFieldType() == null) continue;
            codeBuilder.append("\tpublic ").append(field.getFieldType().getDescricao()).append(" get").append(field.getFieldName().substring(0, 1).toUpperCase()).append(field.getFieldName().substring(1)).append("() {\n");
            codeBuilder.append("\t\treturn ").append(field.getFieldName()).append(";\n");
            codeBuilder.append("\t}\n\n");
            codeBuilder.append("\tpublic void set").append(field.getFieldName().substring(0, 1).toUpperCase()).append(field.getFieldName().substring(1)).append("(").append(field.getFieldType().getDescricao()).append(" ").append(field.getFieldName()).append(") {\n");
            codeBuilder.append("\t\tthis.").append(field.getFieldName()).append(" = ").append(field.getFieldName()).append(";\n");
            codeBuilder.append("\t}\n\n");
        }


        codeBuilder.append("\t// ...\n\n");
        codeBuilder.append("}");
        return codeBuilder.toString();
    }
}
