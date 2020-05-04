package cn.savory.esmanage.convertor;

import java.util.List;

import cn.savory.esmanage.contract.request.ClusterCreateRequest;
import cn.savory.esmanage.contract.request.ClusterUpdateRequest;
import cn.savory.esmanage.contract.vo.ClusterBasicVo;
import cn.savory.esmanage.contract.vo.ClusterExtendedVo;
import cn.savory.esmanage.repository.entity.ClusterEntity;

public interface IClusterConvertor {

    /**
     * request => entity
     */
    ClusterEntity toEntity(ClusterCreateRequest request);

    /**
     * request => entity
     */
    ClusterEntity toEntity(ClusterUpdateRequest request);

    /**
     * entity => basicVo
     */
    ClusterBasicVo toBasicVo(ClusterEntity entity);

    /**
     * entityList => basicVoList
     */
    List<ClusterBasicVo> toBasicVoList(List<ClusterEntity> entityList);

    /**
     * entity => extendedVo
     */
    ClusterExtendedVo toExtendedVo(ClusterEntity entity);

    /**
     * entityList => extendedVoList
     */
    List<ClusterExtendedVo> toExtendedVoList(List<ClusterEntity> entityList);
}
