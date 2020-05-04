package cn.savory.esmanage.repository.mysql.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.savory.esmanage.repository.entity.ClusterEntity;

@Component
public class ClusterMapper extends BaseMapper implements RowMapper<ClusterEntity> {

    @Override
    public ClusterEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        ClusterEntity entity = new ClusterEntity();

        entity.setId(resultSet.getInt("id"));
        entity.setName(resultSet.getString("name"));
        entity.setRemark(resultSet.getString("remark"));
        entity.setDataStatus(resultSet.getInt("data_status"));
        entity.setCreateTime(resultSet.getTimestamp("create_time"));
        entity.setLastUpdateTime(resultSet.getTimestamp("last_update_time"));

        return entity;
    }
}
