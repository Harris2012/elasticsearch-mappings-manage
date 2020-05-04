package cn.savory.esmanage.repository;

import java.util.List;

import cn.savory.esmanage.repository.entity.ClusterEntity;

public interface IClusterRepository {

    void create(ClusterEntity entity);

    void update(ClusterEntity entity);

    ClusterEntity getById(Integer id);

    void disableById(Integer id);

    List<ClusterEntity> getEntityList();

    Long getCount();

    List<ClusterEntity> getPagedEntityList(Integer pageIndex, Integer pageSize);
}
