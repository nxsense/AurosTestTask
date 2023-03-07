package task.dao;

import task.entity.KnowledgePackage;

import java.util.List;

public interface KnowledgePackageDao {
    KnowledgePackage add(KnowledgePackage knowledgePackage);
    List<KnowledgePackage> getAll();
    boolean delete(long id);
}
