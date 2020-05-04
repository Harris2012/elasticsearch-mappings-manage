package cn.savory.esmanage.repository.mysql;

import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.savory.esmanage.repository.entity.FieldEntity;
import cn.savory.esmanage.repository.IFieldRepository;
import cn.savory.esmanage.repository.mysql.mapper.FieldMapper;

@Repository
public class FieldRepository implements IFieldRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FieldMapper fieldMapper;

    @Override
    public void create(FieldEntity entity) {

        String sql = "insert into `field`("
                + "  cluster_id,"
                + "  document_id,"
                + "  name,"
                + "  field_type,"
                + "  remark,"
                + "  null_value,"
                + "  copy_to,"
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
            entity.getDocumentId(),
            entity.getName(),
            entity.getFieldType(),
            entity.getRemark(),
            entity.getNullValue(),
            entity.getCopyTo(),
            entity.getDataStatus(),
            entity.getCreateTime(),
            entity.getLastUpdateTime()
        });
    }

    @Override
    public void update(FieldEntity entity) {

        String sql = "update `field`"
                + "set"
                + "  cluster_id = ?,"
                + "  document_id = ?,"
                + "  name = ?,"
                + "  field_type = ?,"
                + "  remark = ?,"
                + "  null_value = ?,"
                + "  copy_to = ?,"
                + "  last_update_time = ?"
                + "where"
                + "  id = ?;";

        jdbcTemplate.update(sql, new Object[] {
            entity.getClusterId(),
            entity.getDocumentId(),
            entity.getName(),
            entity.getFieldType(),
            entity.getRemark(),
            entity.getNullValue(),
            entity.getCopyTo(),
            entity.getLastUpdateTime(),
            entity.getId()
        });
    }

    @Override
    public FieldEntity getById(Integer id) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  field_type,"
                + "  remark,"
                + "  null_value,"
                + "  copy_to,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `field` "
                + "where id = ? "
                + "  and data_status = 1";

        return jdbcTemplate.queryForObject(sql, new Object[]{ id }, fieldMapper);
    }

    @Override
    public void disableById(Integer id) {

        String sql = "update `field` set data_status = ? where id = ?;";

        jdbcTemplate.update(sql, new Object[]{ 2, id });
    }

    @Override
    public List<FieldEntity> getEntityList(Integer clusterId, Integer documentId) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  field_type,"
                + "  remark,"
                + "  null_value,"
                + "  copy_to,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `field` "
                + "where data_status = 1"
                + "  and cluster_id = ?"
                + "  and document_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);
        items.add(documentId);

        return jdbcTemplate.query(sql, items.toArray(), fieldMapper);
    }

    @Override
    public List<FieldEntity> getEntityList(Integer clusterId) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  field_type,"
                + "  remark,"
                + "  null_value,"
                + "  copy_to,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `field` "
                + "where data_status = 1"
                + "  and cluster_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);

        return jdbcTemplate.query(sql, items.toArray(), fieldMapper);
    }

    @Override
    public List<FieldEntity> getEntityList() {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  field_type,"
                + "  remark,"
                + "  null_value,"
                + "  copy_to,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `field` "
                + "where data_status = 1";

        List<Object> items = Lists.newArrayList();

        return jdbcTemplate.query(sql, items.toArray(), fieldMapper);
    }

    @Override
    public Long getCount(Integer clusterId, Integer documentId) {

        String sql = "select count(1)"
                + "from `field`"
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
                + "from `field`"
                + "where data_status = 1"
                + "  and cluster_id = ?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);

        return jdbcTemplate.queryForObject(sql, items.toArray(), Long.class);
    }

    @Override
    public Long getCount() {

        String sql = "select count(1)"
                + "from `field`"
                + "where data_status = 1";

        List<Object> items = Lists.newArrayList();

        return jdbcTemplate.queryForObject(sql, items.toArray(), Long.class);
    }

    @Override
    public List<FieldEntity> getPagedEntityList(Integer clusterId, Integer documentId, Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  field_type,"
                + "  remark,"
                + "  null_value,"
                + "  copy_to,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `field` "
                + "where data_status = 1 "
                + "  and cluster_id = ?"
                + "  and document_id = ?"
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);
        items.add(documentId);
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), fieldMapper);
    }

    @Override
    public List<FieldEntity> getPagedEntityList(Integer clusterId, Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  field_type,"
                + "  remark,"
                + "  null_value,"
                + "  copy_to,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `field` "
                + "where data_status = 1 "
                + "  and cluster_id = ?"
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add(clusterId);
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), fieldMapper);
    }

    @Override
    public List<FieldEntity> getPagedEntityList(Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  cluster_id,"
                + "  document_id,"
                + "  id,"
                + "  name,"
                + "  field_type,"
                + "  remark,"
                + "  null_value,"
                + "  copy_to,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `field` "
                + "where data_status = 1 "
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), fieldMapper);
    }
}
