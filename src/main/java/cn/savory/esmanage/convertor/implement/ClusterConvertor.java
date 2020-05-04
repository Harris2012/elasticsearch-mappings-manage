package cn.savory.esmanage.convertor.implement;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import cn.savory.esmanage.contract.request.ClusterCreateRequest;
import cn.savory.esmanage.contract.request.ClusterUpdateRequest;
import cn.savory.esmanage.contract.vo.*;
import cn.savory.esmanage.convertor.IClusterConvertor;
import cn.savory.esmanage.repository.entity.*;
import cn.savory.esmanage.utility.StringJoiner;
import cn.savory.esmanage.utility.StringSpliter;

@Component
public class ClusterConvertor implements IClusterConvertor {

    @Override
    public ClusterEntity toEntity(ClusterCreateRequest request) {

        ClusterEntity entity = new ClusterEntity();

        ClusterBasicVo item = request.getItem();

        entity.setName(item.getName());
        entity.setRemark(item.getRemark());
        entity.setDataStatus(1);
        entity.setCreateTime(new Date());
        entity.setLastUpdateTime(new Date());

        return entity;
    }

    @Override
    public ClusterEntity toEntity(ClusterUpdateRequest request) {

        ClusterEntity entity = new ClusterEntity();

        ClusterBasicVo item = request.getItem();

        entity.setId(request.getId());
        entity.setName(item.getName());
        entity.setRemark(item.getRemark());
        entity.setLastUpdateTime(new Date());

        return entity;
    }

    @Override
    public ClusterBasicVo toBasicVo(ClusterEntity entity) {

        ClusterBasicVo vo = new ClusterBasicVo();

        copyToVo(vo, entity);


        return vo;
    }

    @Override
    public List<ClusterBasicVo> toBasicVoList(List<ClusterEntity> entityList) {

        if (entityList == null) {
            return null;
        }

        List<ClusterBasicVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (ClusterEntity entity : entityList) {
            ClusterBasicVo vo = toBasicVo(entity);
            voList.add(vo);
        }

        return voList;
    }

    @Override
    public ClusterExtendedVo toExtendedVo(ClusterEntity entity) {

        ClusterExtendedVo vo = new ClusterExtendedVo();

        copyToVo(vo, entity);


        return vo;
    }

    @Override
    public List<ClusterExtendedVo> toExtendedVoList(List<ClusterEntity> entityList) {

        if (entityList == null) {
            return null;
        }

        List<ClusterExtendedVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (ClusterEntity entity : entityList) {
            ClusterExtendedVo vo = toExtendedVo(entity);
            voList.add(vo);
        }

        return voList;
    }

    /**
     * 将entity转换为vo。不包括来自元数据的属性
     */
    private void copyToVo(ClusterVo vo, ClusterEntity entity) {

        vo.setId(entity.getId());

        vo.setName(entity.getName());
        vo.setRemark(entity.getRemark());
        vo.setCreateTime(entity.getCreateTime());
        vo.setLastUpdateTime(entity.getLastUpdateTime());
    }
}
