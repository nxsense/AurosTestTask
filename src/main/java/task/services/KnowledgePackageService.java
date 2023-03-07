package task.services;

import task.entity.KnowledgePackage;

import java.util.List;

public interface KnowledgePackageService {
    KnowledgePackage add(KnowledgePackage knowledgePackage);
    List<KnowledgePackage> getAll();
    boolean delete(Long id);
}
