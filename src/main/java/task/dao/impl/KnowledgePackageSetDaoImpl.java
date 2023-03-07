package task.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import task.dao.KnowledgePackageSetDao;
import task.entity.KnowledgePackage;
import task.entity.KnowledgePackageSet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class KnowledgePackageSetDaoImpl implements KnowledgePackageSetDao {
    private final JdbcTemplate jdbcTemplate;
    private final String addKPacSetQuery = "INSERT INTO k_pac_set (title) VALUES(?)";
    private final String getAllQuery = "SELECT * FROM k_pac_set";
    private final String deleteFromKPacKPacSetQuery = "DELETE  FROM k_pac_k_pac_set WHERE k_pac_set_id = ?";
    private final String deleteFromKPacSetQuery = "DELETE FROM k_pac_set WHERE id=?";
    private final String getKPacsInSetQuery = "SELECT * FROM k_pac RIGHT JOIN k_pac_k_pac_set on k_pac.id = k_pac_k_pac_set.k_pac_id WHERE k_pac_k_pac_set.k_pac_set_id = ?";
    private final String addKpacToSet = "INSERT INTO k_pac_k_pac_set (k_pac_set_id, k_pac_id) values (?, ?)";
    public KnowledgePackageSetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement insertStatement = con.prepareStatement(addKPacSetQuery,
                    Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, knowledgePackageSet.getTitle());
            return insertStatement;
        }, keyHolder);
        knowledgePackageSet.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return knowledgePackageSet;
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        List<KnowledgePackageSet> list = jdbcTemplate.queryForList(getAllQuery, KnowledgePackageSet.class);
        list.forEach(e -> e.setKnowledgePackages(e.getKnowledgePackages()));
        return list;
    }

    @Override
    public boolean delete(long id) {
        jdbcTemplate.update(deleteFromKPacKPacSetQuery, id);
        return jdbcTemplate.update(deleteFromKPacSetQuery, id) > 0;
    }

    @Override
    public List<KnowledgePackage> getAllKnowledgePackagesInSet(long id) {
        return jdbcTemplate.query(getKPacsInSetQuery, new Object[]{id},
                new BeanPropertyRowMapper<>(KnowledgePackage.class));
    }

    @Override
    public void addKnowledgePackageToSet(long setId, long packageId) {
        jdbcTemplate.update(addKpacToSet, setId, packageId);
    }

    @Override
    public KnowledgePackageSet getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM k_pac_set WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<KnowledgePackageSet>());
    }
}
