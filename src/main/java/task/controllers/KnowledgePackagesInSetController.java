package task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import task.mappers.KnowledgePackageDtoMapper;
import task.services.KnowledgePackageSetService;

import java.util.stream.Collectors;

@Controller
public class KnowledgePackagesInSetController {
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackagesInSetController(KnowledgePackageSetService knowledgePackageSetService, KnowledgePackageDtoMapper knowledgePackageDtoMapper) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageDtoMapper = knowledgePackageDtoMapper;
    }

    @GetMapping("/set/{id}")
    public String getById (@PathVariable Long id, Model model){
        model.addAttribute("set", knowledgePackageSetService.getKPacsFromSet(id).stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList()));
        return "pack";
    }
}
