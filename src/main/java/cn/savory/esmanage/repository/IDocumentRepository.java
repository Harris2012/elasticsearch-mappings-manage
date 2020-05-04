package cn.savory.esmanage.repository;

import java.util.List;

import cn.savory.esmanage.repository.entity.DocumentEntity;

public interface IDocumentRepository {

    void create(DocumentEntity entity);

    void update(DocumentEntity entity);

    DocumentEntity getById(Integer id);

    void disableById(Integer id);

    List<DocumentEntity> getEntityList(Integer clusterId);

    List<DocumentEntity> getEntityList();

    Long getCount(Integer clusterId);

    Long getCount();

    List<DocumentEntity> getPagedEntityList(Integer clusterId, Integer pageIndex, Integer pageSize);

    List<DocumentEntity> getPagedEntityList(Integer pageIndex, Integer pageSize);
}
