package task.mappers;

import task.dto.request.KnowledgePackageSetRequestDto;
import task.dto.response.KnowledgePackageSetResponseDto;
import task.entity.KnowledgePackageSet;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageSetDtoMapper {

    public KnowledgePackageSet toEntity (KnowledgePackageSetRequestDto dto){
        KnowledgePackageSet entity = new KnowledgePackageSet();
        entity.setTitle(dto.getTitle());
        return entity;
    }
    public KnowledgePackageSetResponseDto toDto(KnowledgePackageSet knowledgePackageSet){
        KnowledgePackageSetResponseDto dto = new KnowledgePackageSetResponseDto();
        dto.setId(knowledgePackageSet.getId());
        dto.setTitle(knowledgePackageSet.getTitle());
        return dto;
    }
}
