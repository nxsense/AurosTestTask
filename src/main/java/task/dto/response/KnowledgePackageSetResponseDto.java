package task.dto.response;

import task.entity.KnowledgePackage;

import java.util.List;

public class KnowledgePackageSetResponseDto {
    private long id;
    private String title;
    private List<KnowledgePackage> knowledgePackages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KnowledgePackage> getKnowledgePackages() {
        return knowledgePackages;
    }

    public void setKnowledgePackages(List<KnowledgePackage> knowledgePackages) {
        this.knowledgePackages = knowledgePackages;
    }
}
