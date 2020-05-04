package cn.savory.esmanage.repository.mysql.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.savory.esmanage.repository.entity.DocumentEntity;

@Component
public class DocumentMapper extends BaseMapper implements RowMapper<DocumentEntity> {

    @Override
    public DocumentEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        DocumentEntity entity = new DocumentEntity();

        entity.setId(resultSet.getInt("id"));
        entity.setName(resultSet.getString("name"));
        entity.setRemark(resultSet.getString("remark"));
        entity.setNumberOfShards(resultSet.getInt("number_of_shards"));
        entity.setNumberOfReplicas(resultSet.getInt("number_of_replicas"));
        entity.setMappingTotalFieldsLimit(resultSet.getInt("mapping_total_fields_limit"));
        entity.setDynamic(resultSet.getBoolean("dynamic"));
        entity.setDataStatus(resultSet.getInt("data_status"));
        entity.setCreateTime(resultSet.getTimestamp("create_time"));
        entity.setLastUpdateTime(resultSet.getTimestamp("last_update_time"));

        return entity;
    }
}
