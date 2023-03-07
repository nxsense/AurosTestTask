package task.services.impl;

import task.dao.KnowledgePackageDao;
import task.entity.KnowledgePackage;
import org.springframework.stereotype.Service;
import task.services.KnowledgePackageService;

import java.util.List;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {

    private final KnowledgePackageDao knowledgePackageDao;

    public KnowledgePackageServiceImpl(KnowledgePackageDao knowledgePackageDao) {
        this.knowledgePackageDao = knowledgePackageDao;
    }

    @Override
    public KnowledgePackage add(KnowledgePackage knowledgePackage) {
        return knowledgePackageDao.add(knowledgePackage);
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return knowledgePackageDao.getAll();
    }

    @Override
    public boolean delete(Long id) {
        return knowledgePackageDao.delete(id);
    }
}
