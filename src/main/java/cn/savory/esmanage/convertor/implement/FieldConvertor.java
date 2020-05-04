package cn.savory.esmanage.convertor.implement;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.savory.esmanage.contract.request.FieldCreateRequest;
import cn.savory.esmanage.contract.request.FieldUpdateRequest;
import cn.savory.esmanage.contract.vo.*;
import cn.savory.esmanage.convertor.IFieldConvertor;
import cn.savory.esmanage.metadata.*;
import cn.savory.esmanage.repository.entity.*;
import cn.savory.esmanage.utility.StringJoiner;
import cn.savory.esmanage.utility.StringSpliter;

@Component
public class FieldConvertor implements IFieldConvertor {

    @Autowired
    private IMetaFieldTypeProvider metaFieldTypeProvider;

    @Override
    public FieldEntity toEntity(FieldCreateRequest request) {

        FieldEntity entity = new FieldEntity();

        FieldBasicVo item = request.getItem();

        entity.setClusterId(request.getClusterId());
        entity.setDocumentId(request.getDocumentId());
        entity.setName(item.getName());
        entity.setFieldType(item.getFieldType());
        entity.setRemark(item.getRemark());
        entity.setNullValue(item.getNullValue());
        entity.setCopyTo(item.getCopyTo());
        entity.setDataStatus(1);
        entity.setCreateTime(new Date());
        entity.setLastUpdateTime(new Date());

        return entity;
    }

    @Override
    public FieldEntity toEntity(FieldUpdateRequest request) {

        FieldEntity entity = new FieldEntity();

        FieldBasicVo item = request.getItem();

        entity.setClusterId(request.getClusterId());
        entity.setDocumentId(request.getDocumentId());
        entity.setId(request.getId());
        entity.setName(item.getName());
        entity.setFieldType(item.getFieldType());
        entity.setRemark(item.getRemark());
        entity.setNullValue(item.getNullValue());
        entity.setCopyTo(item.getCopyTo());
        entity.setLastUpdateTime(new Date());

        return entity;
    }

    @Override
    public FieldBasicVo toBasicVo(FieldEntity entity) {

        FieldBasicVo vo = new FieldBasicVo();

        copyToVo(vo, entity);

        vo.setFieldType(entity.getFieldType());

        return vo;
    }

    @Override
    public List<FieldBasicVo> toBasicVoList(List<FieldEntity> entityList) {

        if (entityList == null) {
            return null;
        }

        List<FieldBasicVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (FieldEntity entity : entityList) {
            FieldBasicVo vo = toBasicVo(entity);
            voList.add(vo);
        }

        return voList;
    }

    @Override
    public FieldExtendedVo toExtendedVo(FieldEntity entity) {

        FieldExtendedVo vo = new FieldExtendedVo();

        copyToVo(vo, entity);

        vo.setFieldType(metaFieldTypeProvider.toMetadata(entity.getFieldType()));

        return vo;
    }

    @Override
    public List<FieldExtendedVo> toExtendedVoList(List<FieldEntity> entityList) {

        if (entityList == null) {
            return null;
        }

        List<FieldExtendedVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (FieldEntity entity : entityList) {
            FieldExtendedVo vo = toExtendedVo(entity);
            voList.add(vo);
        }

        return voList;
    }

    /**
     * 将entity转换为vo。不包括来自元数据的属性
     */
    private void copyToVo(FieldVo vo, FieldEntity entity) {

        vo.setId(entity.getId());

        vo.setName(entity.getName());
        vo.setRemark(entity.getRemark());
        vo.setNullValue(entity.getNullValue());
        vo.setCopyTo(entity.getCopyTo());
        vo.setCreateTime(entity.getCreateTime());
        vo.setLastUpdateTime(entity.getLastUpdateTime());
    }
}
