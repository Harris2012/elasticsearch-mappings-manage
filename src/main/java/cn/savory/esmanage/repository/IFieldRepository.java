package cn.savory.esmanage.repository;

import java.util.List;

import cn.savory.esmanage.repository.entity.FieldEntity;

public interface IFieldRepository {

    void create(FieldEntity entity);

    void update(FieldEntity entity);

    FieldEntity getById(Integer id);

    void disableById(Integer id);

    List<FieldEntity> getEntityList(Integer clusterId, Integer documentId);

    List<FieldEntity> getEntityList(Integer clusterId);

    List<FieldEntity> getEntityList();

    Long getCount(Integer clusterId, Integer documentId);

    Long getCount(Integer clusterId);

    Long getCount();

    List<FieldEntity> getPagedEntityList(Integer clusterId, Integer documentId, Integer pageIndex, Integer pageSize);

    List<FieldEntity> getPagedEntityList(Integer clusterId, Integer pageIndex, Integer pageSize);

    List<FieldEntity> getPagedEntityList(Integer pageIndex, Integer pageSize);
}
