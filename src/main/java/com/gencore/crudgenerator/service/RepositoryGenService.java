package com.gencore.crudgenerator.service;


import com.gencore.crudgenerator.controller.dto.EntityModel;

public class RepositoryGenService {
    public static String generate(EntityModel entityModel) {
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder.append("import org.springframework.data.jpa.repository.JpaRepository;\n");
        codeBuilder.append("import org.springframework.stereotype.Repository;\n\n");
        codeBuilder.append("@Repository\n");
        codeBuilder.append("public interface ").append(entityModel.getEntityName()).append("Repository extends JpaRepository<").append(entityModel.getEntityName()).append(", Long> {\n\n");
        codeBuilder.append("\t// Additional methods\n");
        codeBuilder.append("\t// ...\n\n");
        codeBuilder.append("}");
        return codeBuilder.toString();
    }
}
