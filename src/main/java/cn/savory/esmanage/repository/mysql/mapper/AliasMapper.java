package cn.savory.esmanage.repository.mysql.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.savory.esmanage.repository.entity.AliasEntity;

@Component
public class AliasMapper extends BaseMapper implements RowMapper<AliasEntity> {

    @Override
    public AliasEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        AliasEntity entity = new AliasEntity();

        entity.setId(resultSet.getInt("id"));
        entity.setName(resultSet.getString("name"));
        entity.setDataStatus(resultSet.getInt("data_status"));
        entity.setCreateTime(resultSet.getTimestamp("create_time"));
        entity.setLastUpdateTime(resultSet.getTimestamp("last_update_time"));

        return entity;
    }
}
