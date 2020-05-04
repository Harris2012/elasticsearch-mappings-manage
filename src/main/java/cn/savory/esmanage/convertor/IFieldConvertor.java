package cn.savory.esmanage.convertor;

import java.util.List;

import cn.savory.esmanage.contract.request.FieldCreateRequest;
import cn.savory.esmanage.contract.request.FieldUpdateRequest;
import cn.savory.esmanage.contract.vo.FieldBasicVo;
import cn.savory.esmanage.contract.vo.FieldExtendedVo;
import cn.savory.esmanage.repository.entity.FieldEntity;

public interface IFieldConvertor {

    /**
     * request => entity
     */
    FieldEntity toEntity(FieldCreateRequest request);

    /**
     * request => entity
     */
    FieldEntity toEntity(FieldUpdateRequest request);

    /**
     * entity => basicVo
     */
    FieldBasicVo toBasicVo(FieldEntity entity);

    /**
     * entityList => basicVoList
     */
    List<FieldBasicVo> toBasicVoList(List<FieldEntity> entityList);

    /**
     * entity => extendedVo
     */
    FieldExtendedVo toExtendedVo(FieldEntity entity);

    /**
     * entityList => extendedVoList
     */
    List<FieldExtendedVo> toExtendedVoList(List<FieldEntity> entityList);
}
