package cn.savory.esmanage.repository;

import java.util.List;

import cn.savory.esmanage.repository.entity.AliasEntity;

public interface IAliasRepository {

    void create(AliasEntity entity);

    void update(AliasEntity entity);

    AliasEntity getById(Integer id);

    void disableById(Integer id);

    List<AliasEntity> getEntityList(Integer clusterId, Integer documentId);

    List<AliasEntity> getEntityList(Integer clusterId);

    List<AliasEntity> getEntityList();

    Long getCount(Integer clusterId, Integer documentId);

    Long getCount(Integer clusterId);

    Long getCount();

    List<AliasEntity> getPagedEntityList(Integer clusterId, Integer documentId, Integer pageIndex, Integer pageSize);

    List<AliasEntity> getPagedEntityList(Integer clusterId, Integer pageIndex, Integer pageSize);

    List<AliasEntity> getPagedEntityList(Integer pageIndex, Integer pageSize);
}
