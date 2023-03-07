package task.services.impl;

import task.dao.KnowledgePackageSetDao;
import task.entity.KnowledgePackage;
import task.entity.KnowledgePackageSet;
import org.springframework.stereotype.Service;
import task.services.KnowledgePackageSetService;

import java.util.List;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private final KnowledgePackageSetDao knowledgePackageSetDao;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetDao knowledgePackageSetDao) {
        this.knowledgePackageSetDao = knowledgePackageSetDao;
    }


    @Override
    public KnowledgePackageSet add(KnowledgePackageSet set) {
        return knowledgePackageSetDao.add(set);
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        return knowledgePackageSetDao.getAll();
    }

    @Override
    public boolean delete(Long id) {
        return knowledgePackageSetDao.delete(id);
    }

    @Override
    public List<KnowledgePackage> getKPacsFromSet(Long id) {
        return knowledgePackageSetDao.getAllKnowledgePackagesInSet(id);
    }

    @Override
    public void addKPacToSet(Long setId, Long pacId) {
        knowledgePackageSetDao.addKnowledgePackageToSet(setId, pacId);
    }

    @Override
    public KnowledgePackageSet getById(Long id) {
        KnowledgePackageSet knowledgePackageSet = knowledgePackageSetDao.getById(id);
        knowledgePackageSet.setKnowledgePackages(knowledgePackageSetDao.getAllKnowledgePackagesInSet(id));
        return knowledgePackageSet;
    }
}
