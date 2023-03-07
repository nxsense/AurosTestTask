package task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import task.dto.request.KPacKPacSetRequestDto;
import task.dto.request.KnowledgePackageSetRequestDto;
import task.mappers.KnowledgePackageDtoMapper;
import task.mappers.KnowledgePackageSetDtoMapper;
import task.services.KnowledgePackageService;
import task.services.KnowledgePackageSetService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/sets")
public class KnowledgePackageSetController {
    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageSetDtoMapper knowledgePackageSetDtoMapper;
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackageSetController(KnowledgePackageService knowledgePackageService, KnowledgePackageSetService knowledgePackageSetService, KnowledgePackageSetDtoMapper knowledgePackageSetDtoMapper, KnowledgePackageDtoMapper knowledgePackageDtoMapper) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageSetDtoMapper = knowledgePackageSetDtoMapper;
        this.knowledgePackageDtoMapper = knowledgePackageDtoMapper;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("sets", knowledgePackageSetService.getAll().stream()
                .map(knowledgePackageSetDtoMapper::toDto)
                .collect(Collectors.toList()));
        return "kPacSet";
    }

    @GetMapping("/kpacs/add")
    public String addKPac(){
        return "addKPacToSet";
    }

    @PostMapping("/kpacs/add")
    public void addKPacToSet(KPacKPacSetRequestDto dto){
        knowledgePackageSetService.addKPacToSet(dto.getkPacSetId(), dto.getkPacId());
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        knowledgePackageSetService.delete(id);
        return "redirect : /sets";
    }

    @GetMapping("/add")
    public String addSetF(){
        return "addSet";
    }

    @PostMapping("/add")
    public void addSet(KnowledgePackageSetRequestDto requestDto){
        knowledgePackageSetService.add(knowledgePackageSetDtoMapper.toEntity(requestDto));
    }
}
