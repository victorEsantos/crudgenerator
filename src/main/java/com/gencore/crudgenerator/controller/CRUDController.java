package com.gencore.crudgenerator.controller;

import com.gencore.crudgenerator.controller.dto.EntityModel;
import com.gencore.crudgenerator.controller.dto.enums.TipoDadoEnum;
import com.gencore.crudgenerator.service.ControllerGenService;
import com.gencore.crudgenerator.service.EntityGenService;
import com.gencore.crudgenerator.service.RepositoryGenService;
import com.gencore.crudgenerator.service.ServiceGenService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CRUDController {

    //health check
    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/crud")
    public String crudForm(Model model) {
        model.addAttribute("entity", new EntityModel());
        model.addAttribute("tipoDadoEnumValues", TipoDadoEnum.values());

        return "crud";
    }

    @PostMapping("/crud")
    public void generateCRUD(@ModelAttribute EntityModel entityModel, Model model) {
        String entityCode = EntityGenService.generate(entityModel);
        String serviceCode = ServiceGenService.generate(entityModel);
        String repositoryCode = RepositoryGenService.generate(entityModel);
        String controllerCode = ControllerGenService.generateControllerCode(entityModel);

        model.addAttribute("entityCode", entityCode);
        model.addAttribute("serviceCode", serviceCode);
        model.addAttribute("repositoryCode", repositoryCode);
        model.addAttribute("controllerCode", controllerCode);
    }



}
