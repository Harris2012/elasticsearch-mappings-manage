package cn.savory.esmanage.convertor;

import java.util.List;

import cn.savory.esmanage.contract.request.AliasCreateRequest;
import cn.savory.esmanage.contract.request.AliasUpdateRequest;
import cn.savory.esmanage.contract.vo.AliasBasicVo;
import cn.savory.esmanage.contract.vo.AliasExtendedVo;
import cn.savory.esmanage.repository.entity.AliasEntity;

public interface IAliasConvertor {

    /**
     * request => entity
     */
    AliasEntity toEntity(AliasCreateRequest request);

    /**
     * request => entity
     */
    AliasEntity toEntity(AliasUpdateRequest request);

    /**
     * entity => basicVo
     */
    AliasBasicVo toBasicVo(AliasEntity entity);

    /**
     * entityList => basicVoList
     */
    List<AliasBasicVo> toBasicVoList(List<AliasEntity> entityList);

    /**
     * entity => extendedVo
     */
    AliasExtendedVo toExtendedVo(AliasEntity entity);

    /**
     * entityList => extendedVoList
     */
    List<AliasExtendedVo> toExtendedVoList(List<AliasEntity> entityList);
}
