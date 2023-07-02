package com.gencore.crudgenerator.service;


import com.gencore.crudgenerator.controller.dto.EntityModel;

public class ServiceGenService {
    public static String generate(EntityModel entityModel) {
        //gerador de service para create read update e delete
        StringBuilder codeBuilder = new StringBuilder();


        codeBuilder.append("@Service\n");
        codeBuilder.append("public class ").append(entityModel.getEntityName()).append("Service {\n\n");
        codeBuilder.append("\t@Autowired\n");
        codeBuilder.append("\tprivate ").append(entityModel.getEntityName()).append("Repository ").append(entityModel.getEntityName().toLowerCase()).append("Repository;\n\n");

        //create
        codeBuilder.append("\tpublic ").append(entityModel.getEntityName()).append(" create(").append(entityModel.getEntityName()).append(" ").append(entityModel.getEntityName().toLowerCase()).append(") {\n");
        codeBuilder.append("\t\treturn ").append(entityModel.getEntityName().toLowerCase()).append("Repository.save(").append(entityModel.getEntityName().toLowerCase()).append(");\n");
        codeBuilder.append("\t}\n\n");


        //get all
        codeBuilder.append("\tpublic List<").append(entityModel.getEntityName()).append("> readAll() {\n");
        codeBuilder.append("\t\treturn ").append(entityModel.getEntityName().toLowerCase()).append("Repository.findAll();\n");
        codeBuilder.append("\t}\n\n");


        //get by id
        codeBuilder.append("\tpublic ").append(entityModel.getEntityName()).append(" readById(Long id) {\n");
        codeBuilder.append("\t\treturn ").append(entityModel.getEntityName().toLowerCase()).append("Repository.findById(id).orElse(null);\n");
        codeBuilder.append("\t}\n\n");


        //update
        codeBuilder.append("\tpublic ").append(entityModel.getEntityName()).append(" update(").append(entityModel.getEntityName()).append(" ").append(entityModel.getEntityName().toLowerCase()).append(") {\n");
        codeBuilder.append("\t\treturn ").append(entityModel.getEntityName().toLowerCase()).append("Repository.save(").append(entityModel.getEntityName().toLowerCase()).append(");\n");
        codeBuilder.append("\t}\n\n");


        //delete by id
        codeBuilder.append("\tpublic void delete(Long id) {\n");
        codeBuilder.append("\t\t").append(entityModel.getEntityName().toLowerCase()).append("Repository.deleteById(id);\n");
        codeBuilder.append("\t}\n\n");

        codeBuilder.append("}");

        return codeBuilder.toString();



    }
}
