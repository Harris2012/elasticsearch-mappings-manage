package cn.savory.esmanage.repository.mysql.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public abstract class BaseMapper {

    protected static Integer getInteger(ResultSet resultSet, String columnLabel) throws SQLException {

        Object value = resultSet.getObject(columnLabel);
        if (value == null) {
            return null;
        }

        return (Integer) value;
    }

    protected static Long getLong(ResultSet resultSet, String columnLabel) throws SQLException {

        Object value = resultSet.getObject(columnLabel);
        if (value == null) {
            return null;
        }

        return (Long) value;
    }

    protected static Boolean getBoolean(ResultSet resultSet, String columnLabel) throws SQLException {

        Object value = resultSet.getObject(columnLabel);
        if (value == null) {
            return null;
        }

        return (Boolean) value;
    }

    protected static Timestamp getTimestamp(ResultSet resultSet, String columnLabel) throws SQLException {

        Object value = resultSet.getObject(columnLabel);
        if (value == null) {
            return null;
        }

        return (Timestamp) value;
    }
}
