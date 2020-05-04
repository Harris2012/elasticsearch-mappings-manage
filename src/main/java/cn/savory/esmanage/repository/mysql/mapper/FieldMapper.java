package cn.savory.esmanage.repository.mysql.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.savory.esmanage.repository.entity.FieldEntity;

@Component
public class FieldMapper extends BaseMapper implements RowMapper<FieldEntity> {

    @Override
    public FieldEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        FieldEntity entity = new FieldEntity();

        entity.setId(resultSet.getInt("id"));
        entity.setName(resultSet.getString("name"));
        entity.setFieldType(resultSet.getString("field_type"));
        entity.setRemark(resultSet.getString("remark"));
        entity.setNullValue(resultSet.getString("null_value"));
        entity.setCopyTo(resultSet.getString("copy_to"));
        entity.setDataStatus(resultSet.getInt("data_status"));
        entity.setCreateTime(resultSet.getTimestamp("create_time"));
        entity.setLastUpdateTime(resultSet.getTimestamp("last_update_time"));

        return entity;
    }
}
