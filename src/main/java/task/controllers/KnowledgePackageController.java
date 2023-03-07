package task.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import task.dto.request.KnowledgePackageRequestDto;
import task.mappers.KnowledgePackageDtoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import task.services.KnowledgePackageService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/kpacs")
public class KnowledgePackageController {
    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackageController(KnowledgePackageService knowledgePackageService, KnowledgePackageDtoMapper knowledgePackageDtoMapper) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageDtoMapper = knowledgePackageDtoMapper;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("set", knowledgePackageService.getAll().stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList()));
        return "kpac";
    }

    @PostMapping("/add")
    public String addKPac(KnowledgePackageRequestDto requestDto){
        knowledgePackageService.add(knowledgePackageDtoMapper.toEntity(requestDto));
        return "redirect: /kpacs";
    }

    @GetMapping("/add")
    public String add(){
        return "addKPac";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        knowledgePackageService.delete(id);
        return "redirect: /kpacs";
    }
}
