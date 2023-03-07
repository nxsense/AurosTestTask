package task.dao;

import task.entity.KnowledgePackage;
import task.entity.KnowledgePackageSet;

import java.util.List;

public interface KnowledgePackageSetDao {
    KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet);
    List<KnowledgePackageSet> getAll();
    boolean delete(long id);
    List<KnowledgePackage> getAllKnowledgePackagesInSet(long id);
    void addKnowledgePackageToSet(long setId, long packageId);
}
