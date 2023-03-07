package task.dao.impl;

import task.dao.KnowledgePackageDao;
import task.entity.KnowledgePackage;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Repository
public class KnowledgePackageDaoImpl implements KnowledgePackageDao {
    private final String addQuery = "INSERT INTO k_pac (title, description, creation_date) values (?, ?, ?)";
    private final String getAllQuery = "SELECT * FROM k_pac";
    private final String deleteFromKPacKPacSetQuery = "DELETE  FROM k_pac_k_pac_set WHERE k_pac_id = ?";
    private final String deleteFromKPacQuery = "DELETE FROM k_pac WHERE id=?";
    private final JdbcTemplate jdbcTemplate;
    public KnowledgePackageDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public KnowledgePackage add(KnowledgePackage knowledgePackage) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement insertStatement = con.prepareStatement(addQuery,
                    Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, knowledgePackage.getTitle());
            insertStatement.setString(2, knowledgePackage.getDescription());
            insertStatement.setString(3, LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            return insertStatement;
        }, keyHolder);
        knowledgePackage.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return knowledgePackage;
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return jdbcTemplate.query(getAllQuery,
                new BeanPropertyRowMapper<>(KnowledgePackage.class));
    }

    @Override
    public boolean delete(long id) {
        jdbcTemplate.update(deleteFromKPacKPacSetQuery, id);
        return jdbcTemplate.update(deleteFromKPacQuery, id) > 0;
    }
}
