package com.gencore.crudgenerator.service;

import com.gencore.crudgenerator.controller.dto.EntityModel;

public class ControllerGenService {

    public static final String CONTROLLER_HEADER = """
            import org.springframework.web.bind.annotation.*;
                                       
               @RestController
               public class PessoaController {
               
                private final PessoaService pessoaService;
               
                public PessoaController(PessoaService pessoaService) {
                    this.pessoaService = pessoaService;
                }
               
                // API endpoints
                // ...
               
               }
            """;
    public static String generateControllerCode(EntityModel entityModel) {
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder.append("import org.springframework.web.bind.annotation.*;\n\n");
        codeBuilder.append("@RestController\n");
        codeBuilder.append("public class ").append(entityModel.getEntityName()).append("Controller {\n\n");
        codeBuilder.append("\tprivate final ").append(entityModel.getEntityName()).append("Service ").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service;\n\n");
        codeBuilder.append("\tpublic ").append(entityModel.getEntityName()).append("Controller(").append(entityModel.getEntityName()).append("Service ").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service) {\n");
        codeBuilder.append("\t\tthis.").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service = ").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service;\n");
        codeBuilder.append("\t}\n\n");
        codeBuilder.append("\t// API endpoints\n");
        codeBuilder.append("\t// ...\n\n");


        //get all
        codeBuilder.append("\t@GetMapping(\"/").append(entityModel.getEntityName().toLowerCase()).append("\")\n");
        codeBuilder.append("\tpublic List<").append(entityModel.getEntityName()).append("> readAll() {\n");
        codeBuilder.append("\t\treturn ").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service.readAll();\n");
        codeBuilder.append("\t}\n\n");


        //get by id
        codeBuilder.append("\t@GetMapping(\"/").append(entityModel.getEntityName().toLowerCase()).append("/{id}\")\n");
        codeBuilder.append("\tpublic ").append(entityModel.getEntityName()).append(" readById(@PathVariable Long id) {\n");
        codeBuilder.append("\t\treturn ").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service.readById(id);\n");
        codeBuilder.append("\t}\n\n");


        //create
        codeBuilder.append("\t@PostMapping(\"/").append(entityModel.getEntityName().toLowerCase()).append("\")\n");
        codeBuilder.append("\tpublic ").append(entityModel.getEntityName()).append(" create(@RequestBody ").append(entityModel.getEntityName()).append(" ").append(lowercaseFirstLetter(entityModel.getEntityName())).append(") {\n");
        codeBuilder.append("\t\treturn ").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service.create(").append(lowercaseFirstLetter(entityModel.getEntityName())).append(");\n");
        codeBuilder.append("\t}\n\n");


        //update
        codeBuilder.append("\t@PutMapping(\"/").append(entityModel.getEntityName().toLowerCase()).append("/{id}\")\n");
        codeBuilder.append("\tpublic ").append(entityModel.getEntityName()).append(" update(@PathVariable Long id, @RequestBody ").append(entityModel.getEntityName()).append(" ").append(lowercaseFirstLetter(entityModel.getEntityName())).append(") {\n");
        codeBuilder.append("\t\treturn ").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service.update(id, ").append(lowercaseFirstLetter(entityModel.getEntityName())).append(");\n");
        codeBuilder.append("\t}\n\n");


        //delete
        codeBuilder.append("\t@DeleteMapping(\"/").append(entityModel.getEntityName().toLowerCase()).append("/{id}\")\n");
        codeBuilder.append("\tpublic void delete(@PathVariable Long id) {\n");
        codeBuilder.append("\t\t").append(lowercaseFirstLetter(entityModel.getEntityName())).append("Service.delete(id);\n");
        codeBuilder.append("\t}\n\n");



        codeBuilder.append("}");
        return codeBuilder.toString();
    }

    private static String lowercaseFirstLetter(String text) {
        if(text == null || text.isEmpty())
            return text;
        return Character.toLowerCase(text.charAt(0)) + text.substring(1);
    }
}

