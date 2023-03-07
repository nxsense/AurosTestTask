package task.services;

import task.entity.KnowledgePackage;
import task.entity.KnowledgePackageSet;

import java.util.List;

public interface KnowledgePackageSetService {
    KnowledgePackageSet add(KnowledgePackageSet set);
    List<KnowledgePackageSet> getAll();
    boolean delete (Long id);
    List<KnowledgePackage> getKPacsFromSet(Long id);
    void addKPacToSet(Long setId, Long pacId);
    KnowledgePackageSet getById(Long id);
}
