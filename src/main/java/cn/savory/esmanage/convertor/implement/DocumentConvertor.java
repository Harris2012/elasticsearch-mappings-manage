package cn.savory.esmanage.convertor.implement;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import cn.savory.esmanage.contract.request.DocumentCreateRequest;
import cn.savory.esmanage.contract.request.DocumentUpdateRequest;
import cn.savory.esmanage.contract.vo.*;
import cn.savory.esmanage.convertor.IDocumentConvertor;
import cn.savory.esmanage.repository.entity.*;
import cn.savory.esmanage.utility.StringJoiner;
import cn.savory.esmanage.utility.StringSpliter;

@Component
public class DocumentConvertor implements IDocumentConvertor {

    @Override
    public DocumentEntity toEntity(DocumentCreateRequest request) {

        DocumentEntity entity = new DocumentEntity();

        DocumentBasicVo item = request.getItem();

        entity.setClusterId(request.getClusterId());
        entity.setName(item.getName());
        entity.setRemark(item.getRemark());
        entity.setNumberOfShards(item.getNumberOfShards());
        entity.setNumberOfReplicas(item.getNumberOfReplicas());
        entity.setMappingTotalFieldsLimit(item.getMappingTotalFieldsLimit());
        entity.setDynamic(item.getDynamic());
        entity.setDataStatus(1);
        entity.setCreateTime(new Date());
        entity.setLastUpdateTime(new Date());

        return entity;
    }

    @Override
    public DocumentEntity toEntity(DocumentUpdateRequest request) {

        DocumentEntity entity = new DocumentEntity();

        DocumentBasicVo item = request.getItem();

        entity.setClusterId(request.getClusterId());
        entity.setId(request.getId());
        entity.setName(item.getName());
        entity.setRemark(item.getRemark());
        entity.setNumberOfShards(item.getNumberOfShards());
        entity.setNumberOfReplicas(item.getNumberOfReplicas());
        entity.setMappingTotalFieldsLimit(item.getMappingTotalFieldsLimit());
        entity.setDynamic(item.getDynamic());
        entity.setLastUpdateTime(new Date());

        return entity;
    }

    @Override
    public DocumentBasicVo toBasicVo(DocumentEntity entity) {

        DocumentBasicVo vo = new DocumentBasicVo();

        copyToVo(vo, entity);


        return vo;
    }

    @Override
    public List<DocumentBasicVo> toBasicVoList(List<DocumentEntity> entityList) {

        if (entityList == null) {
            return null;
        }

        List<DocumentBasicVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (DocumentEntity entity : entityList) {
            DocumentBasicVo vo = toBasicVo(entity);
            voList.add(vo);
        }

        return voList;
    }

    @Override
    public DocumentExtendedVo toExtendedVo(DocumentEntity entity) {

        DocumentExtendedVo vo = new DocumentExtendedVo();

        copyToVo(vo, entity);


        return vo;
    }

    @Override
    public List<DocumentExtendedVo> toExtendedVoList(List<DocumentEntity> entityList) {

        if (entityList == null) {
            return null;
        }

        List<DocumentExtendedVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (DocumentEntity entity : entityList) {
            DocumentExtendedVo vo = toExtendedVo(entity);
            voList.add(vo);
        }

        return voList;
    }

    /**
     * 将entity转换为vo。不包括来自元数据的属性
     */
    private void copyToVo(DocumentVo vo, DocumentEntity entity) {

        vo.setId(entity.getId());

        vo.setName(entity.getName());
        vo.setRemark(entity.getRemark());
        vo.setNumberOfShards(entity.getNumberOfShards());
        vo.setNumberOfReplicas(entity.getNumberOfReplicas());
        vo.setMappingTotalFieldsLimit(entity.getMappingTotalFieldsLimit());
        vo.setDynamic(entity.getDynamic());
        vo.setCreateTime(entity.getCreateTime());
        vo.setLastUpdateTime(entity.getLastUpdateTime());
    }
}
