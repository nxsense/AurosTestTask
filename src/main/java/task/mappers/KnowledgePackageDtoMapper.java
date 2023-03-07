package task.mappers;

import task.dto.request.KnowledgePackageRequestDto;
import task.dto.response.KnowledgePackageResponseDto;
import task.entity.KnowledgePackage;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageDtoMapper {
    public KnowledgePackage toEntity(KnowledgePackageRequestDto dto){
        KnowledgePackage entity = new KnowledgePackage();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        return entity;
    }
    public KnowledgePackageResponseDto toDto(KnowledgePackage knowledgePackage){
        KnowledgePackageResponseDto dto = new KnowledgePackageResponseDto();
        dto.setId(knowledgePackage.getId());
        dto.setTitle(knowledgePackage.getTitle());
        dto.setDescription(knowledgePackage.getDescription());
        dto.setCreationDate(knowledgePackage.getCreationDate());
        return dto;
    }
}
