package cn.savory.esmanage.repository.mysql;

import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.savory.esmanage.repository.entity.ClusterEntity;
import cn.savory.esmanage.repository.IClusterRepository;
import cn.savory.esmanage.repository.mysql.mapper.ClusterMapper;

@Repository
public class ClusterRepository implements IClusterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClusterMapper clusterMapper;

    @Override
    public void create(ClusterEntity entity) {

        String sql = "insert into `cluster`("
                + "  name,"
                + "  remark,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time"
                + ")"
                + "values("
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?"
                + ");";

        jdbcTemplate.update(sql, new Object[] {
            entity.getName(),
            entity.getRemark(),
            entity.getDataStatus(),
            entity.getCreateTime(),
            entity.getLastUpdateTime()
        });
    }

    @Override
    public void update(ClusterEntity entity) {

        String sql = "update `cluster`"
                + "set"
                + "  name = ?,"
                + "  remark = ?,"
                + "  last_update_time = ?"
                + "where"
                + "  id = ?;";

        jdbcTemplate.update(sql, new Object[] {
            entity.getName(),
            entity.getRemark(),
            entity.getLastUpdateTime(),
            entity.getId()
        });
    }

    @Override
    public ClusterEntity getById(Integer id) {

        String sql = "select"
                + "  id,"
                + "  name,"
                + "  remark,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `cluster` "
                + "where id = ? "
                + "  and data_status = 1";

        return jdbcTemplate.queryForObject(sql, new Object[]{ id }, clusterMapper);
    }

    @Override
    public void disableById(Integer id) {

        String sql = "update `cluster` set data_status = ? where id = ?;";

        jdbcTemplate.update(sql, new Object[]{ 2, id });
    }

    @Override
    public List<ClusterEntity> getEntityList() {

        String sql = "select"
                + "  id,"
                + "  name,"
                + "  remark,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `cluster` "
                + "where data_status = 1";

        List<Object> items = Lists.newArrayList();

        return jdbcTemplate.query(sql, items.toArray(), clusterMapper);
    }

    @Override
    public Long getCount() {

        String sql = "select count(1)"
                + "from `cluster`"
                + "where data_status = 1";

        List<Object> items = Lists.newArrayList();

        return jdbcTemplate.queryForObject(sql, items.toArray(), Long.class);
    }

    @Override
    public List<ClusterEntity> getPagedEntityList(Integer pageIndex, Integer pageSize) {

        String sql = "select"
                + "  id,"
                + "  name,"
                + "  remark,"
                + "  data_status,"
                + "  create_time,"
                + "  last_update_time "
                + "from `cluster` "
                + "where data_status = 1 "
                + "  limit ?,?";

        List<Object> items = Lists.newArrayList();
        items.add((pageIndex - 1) * pageSize);
        items.add(pageSize);

        return jdbcTemplate.query(sql, items.toArray(), clusterMapper);
    }
}
