package cn.savory.esmanage.repository.mysql;

import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.savory.esmanage.repository.entity.DocumentEntity;
import cn.savory.esmanage.repository.IDocumentRepository;
import cn.savory.esmanage.repository.mysql.mapper.DocumentMapper;

@Repository
public class DocumentRepository implements IDocumentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public void create(DocumentEntity entity) {

        String sql = "insert into `document`("
                + "  cluster_id,"
                + "  name,"
                + "  remark,"
                + "  number_of_shards,"
                + "  number_of_replicas,"
                + "  mapping_total_fields_limit,"
                + "  dynamic,"
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
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?"
                + ");";

        jdbcTemplate.update(sql, new Object[] {
            entity.getClusterId(),
            entity.getName(),
            entity.getRemark(),
            entity.getNumberOfShards(),
            entity.getNumberOfReplicas(),
            entity.getMappingTotalFieldsLimit(),
            entity.getDynamic(),
            entity.getDataStatus(),
            entity.getCreateTime(),
            entity.getLastUpdateTime()
        });
    }

    @Override
    public void update(DocumentEntity entity) {

        String sql = "update `document`"
                + "set"
                + "  cluster_id = ?,"
                + "  name = ?,"
                + "  remark = ?,"
                + "  number_of_shards = ?,"
                + "  number_of_replicas = ?,"
                + "  mapping_total_fields_limit = ?,"
                + "  dynamic = ?,"
                + "  last_update_time = ?"
                + "where"
                + "  id = ?;";

        jdbcTemplate.update(sql, new Object[] {
            entity.getClusterId(),
            entity.getName(),
            entity.getRemark(),
            entity.getNumberOfShards(),
            entity.getNumberOfReplicas(),
            entity.getMappingTotalFieldsLimit(),
            entity.getDynamic(),
            entity.getLastUpdateTime(),
            entity.getId()
        });
    }

    @Override
    public DocumentEntity getById(Integer id) {

        String sql = "select"
                + "  cluster_id,"
                + "  id,"
                + "  name,"
                + "  remark,"
                + "  number_of_shards,"
                + "  number_of_replicas,"
                + "  mapping_total_fields_limit,"
                + "  dynamic,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `document` "
                + "where id = ? "
                + "  and data_status = 1";

        return jdbcTemplate.queryForObject(sql, new Object[]{ id }, documentMapper);
    }

    @Override
    public void disableById(Integer id) {

        String sql = "update `document` set data_status = ? where id = ?;";

        jdbcTemplate.update(sql, new Object[]{ 2, id });
    }

    @Override
    public List<DocumentEntity> getEntityList(Integer clusterId) {

        String sql = "select"
                + "  cluster_id,"
                + "  id,"
                + "  name,"
                + "  remark,"
                + "  number_of_shards,"
                + "  number_of_replicas,"
                + "  mapping_total_fields_limit,"
                + "  dynamic,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `document` "
                + "where data_status = 1"
                + "  and cluster_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);

        return jdbcTemplate.query(sql, items.toArray(), documentMapper);
    }

    @Override
    public List<DocumentEntity> getEntityList() {

        String sql = "select"
                + "  cluster_id,"
                + "  id,"
                + "  name,"
                + "  remark,"
                + "  number_of_shards,"
                + "  number_of_replicas,"
                + "  mapping_total_fields_limit,"
                + "  dynamic,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `document` "
                + "where data_status = 1";

        List<Object> items = Lists.newArrayList();

        return jdbcTemplate.query(sql, items.toArray(), documentMapper);
    }

    @Override
    public Long getCount(Integer clusterId) {

        String sql = "select count(1)"
                + "from `document`"
                + "where data_status = 1"
                + "  and cluster_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);

        return jdbcTemplate.queryForObject(sql, items.toArray(), Long.class);
    }

    @Override
    public Long getCount() {

        String sql = "select count(1)"
                + "from `document`"
                + "where data_status = 1";

        List<Object> items = Lists.newArrayList();

        return jdbcTemplate.queryForObject(sql, items.toArray(), Long.class);
    }

    @Override
    public List<DocumentEntity> getPagedEntityList(Integer clusterId, Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  cluster_id,"
                + "  id,"
                + "  name,"
                + "  remark,"
                + "  number_of_shards,"
                + "  number_of_replicas,"
                + "  mapping_total_fields_limit,"
                + "  dynamic,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `document` "
                + "where data_status = 1 "
                + "  and cluster_id = ?"
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), documentMapper);
    }

    @Override
    public List<DocumentEntity> getPagedEntityList(Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  cluster_id,"
                + "  id,"
                + "  name,"
                + "  remark,"
                + "  number_of_shards,"
                + "  number_of_replicas,"
                + "  mapping_total_fields_limit,"
                + "  dynamic,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `document` "
                + "where data_status = 1 "
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), documentMapper);
    }
}
