package cn.savory.esmanage.repository.mysql;

import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.savory.esmanage.repository.entity.AliasEntity;
import cn.savory.esmanage.repository.IAliasRepository;
import cn.savory.esmanage.repository.mysql.mapper.AliasMapper;

@Repository
public class AliasRepository implements IAliasRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AliasMapper aliasMapper;

    @Override
    public void create(AliasEntity entity) {

        String sql = "insert into `alias`("
                + "  cluster_id,"
                + "  document_id,"
                + "  name,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time"
                + ")"
                + "values("
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?"
                + ");";

        jdbcTemplate.update(sql, new Object[] {
            entity.getClusterId(),
            entity.getDocumentId(),
            entity.getName(),
            entity.getDataStatus(),
            entity.getCreateTime(),
            entity.getLastUpdateTime()
        });
    }

    @Override
    public void update(AliasEntity entity) {

        String sql = "update `alias`"
                + "set"
                + "  cluster_id = ?,"
                + "  document_id = ?,"
                + "  name = ?,"
                + "  last_update_time = ?"
                + "where"
                + "  id = ?;";

        jdbcTemplate.update(sql, new Object[] {
            entity.getClusterId(),
            entity.getDocumentId(),
            entity.getName(),
            entity.getLastUpdateTime(),
            entity.getId()
        });
    }

    @Override
    public AliasEntity getById(Integer id) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `alias` "
                + "where id = ? "
                + "  and data_status = 1";

        return jdbcTemplate.queryForObject(sql, new Object[]{ id }, aliasMapper);
    }

    @Override
    public void disableById(Integer id) {

        String sql = "update `alias` set data_status = ? where id = ?;";

        jdbcTemplate.update(sql, new Object[]{ 2, id });
    }

    @Override
    public List<AliasEntity> getEntityList(Integer clusterId, Integer documentId) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `alias` "
                + "where data_status = 1"
                + "  and cluster_id = ?"
                + "  and document_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);
        items.add(documentId);

        return jdbcTemplate.query(sql, items.toArray(), aliasMapper);
    }

    @Override
    public List<AliasEntity> getEntityList(Integer clusterId) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `alias` "
                + "where data_status = 1"
                + "  and cluster_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);

        return jdbcTemplate.query(sql, items.toArray(), aliasMapper);
    }

    @Override
    public List<AliasEntity> getEntityList() {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `alias` "
                + "where data_status = 1";

        List<Object> items = Lists.newArrayList();

        return jdbcTemplate.query(sql, items.toArray(), aliasMapper);
    }

    @Override
    public Long getCount(Integer clusterId, Integer documentId) {

        String sql = "select count(1)"
                + "from `alias`"
                + "where data_status = 1"
                + "  and cluster_id = ?"
                + "  and document_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);
        items.add(documentId);

        return jdbcTemplate.queryForObject(sql, items.toArray(), Long.class);
    }

    @Override
    public Long getCount(Integer clusterId) {

        String sql = "select count(1)"
                + "from `alias`"
                + "where data_status = 1"
                + "  and cluster_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);

        return jdbcTemplate.queryForObject(sql, items.toArray(), Long.class);
    }

    @Override
    public Long getCount() {

        String sql = "select count(1)"
                + "from `alias`"
                + "where data_status = 1";

        List<Object> items = Lists.newArrayList();

        return jdbcTemplate.queryForObject(sql, items.toArray(), Long.class);
    }

    @Override
    public List<AliasEntity> getPagedEntityList(Integer clusterId, Integer documentId, Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `alias` "
                + "where data_status = 1 "
                + "  and cluster_id = ?"
                + "  and document_id = ?"
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);
        items.add(documentId);
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), aliasMapper);
    }

    @Override
    public List<AliasEntity> getPagedEntityList(Integer clusterId, Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `alias` "
                + "where data_status = 1 "
                + "  and cluster_id = ?"
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), aliasMapper);
    }

    @Override
    public List<AliasEntity> getPagedEntityList(Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `alias` "
                + "where data_status = 1 "
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), aliasMapper);
    }
}
