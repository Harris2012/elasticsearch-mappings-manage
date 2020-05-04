package cn.savory.esmanage.convertor.implement;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import cn.savory.esmanage.contract.request.AliasCreateRequest;
import cn.savory.esmanage.contract.request.AliasUpdateRequest;
import cn.savory.esmanage.contract.vo.*;
import cn.savory.esmanage.convertor.IAliasConvertor;
import cn.savory.esmanage.repository.entity.*;
import cn.savory.esmanage.utility.StringJoiner;
import cn.savory.esmanage.utility.StringSpliter;

@Component
public class AliasConvertor implements IAliasConvertor {

    @Override
    public AliasEntity toEntity(AliasCreateRequest request) {

        AliasEntity entity = new AliasEntity();

        AliasBasicVo item = request.getItem();

        entity.setClusterId(request.getClusterId());
        entity.setDocumentId(request.getDocumentId());
        entity.setName(item.getName());
        entity.setDataStatus(1);
        entity.setCreateTime(new Date());
        entity.setLastUpdateTime(new Date());

        return entity;
    }

    @Override
    public AliasEntity toEntity(AliasUpdateRequest request) {

        AliasEntity entity = new AliasEntity();

        AliasBasicVo item = request.getItem();

        entity.setClusterId(request.getClusterId());
        entity.setDocumentId(request.getDocumentId());
        entity.setId(request.getId());
        entity.setName(item.getName());
        entity.setLastUpdateTime(new Date());

        return entity;
    }

    @Override
    public AliasBasicVo toBasicVo(AliasEntity entity) {

        AliasBasicVo vo = new AliasBasicVo();

        copyToVo(vo, entity);


        return vo;
    }

    @Override
    public List<AliasBasicVo> toBasicVoList(List<AliasEntity> entityList) {

        if (entityList == null) {
            return null;
        }

        List<AliasBasicVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (AliasEntity entity : entityList) {
            AliasBasicVo vo = toBasicVo(entity);
            voList.add(vo);
        }

        return voList;
    }

    @Override
    public AliasExtendedVo toExtendedVo(AliasEntity entity) {

        AliasExtendedVo vo = new AliasExtendedVo();

        copyToVo(vo, entity);


        return vo;
    }

    @Override
    public List<AliasExtendedVo> toExtendedVoList(List<AliasEntity> entityList) {

        if (entityList == null) {
            return null;
        }

        List<AliasExtendedVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (AliasEntity entity : entityList) {
            AliasExtendedVo vo = toExtendedVo(entity);
            voList.add(vo);
        }

        return voList;
    }

    /**
     * 将entity转换为vo。不包括来自元数据的属性
     */
    private void copyToVo(AliasVo vo, AliasEntity entity) {

        vo.setId(entity.getId());

        vo.setName(entity.getName());
        vo.setCreateTime(entity.getCreateTime());
        vo.setLastUpdateTime(entity.getLastUpdateTime());
    }
}
