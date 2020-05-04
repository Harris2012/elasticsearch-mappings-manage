package cn.savory.esmanage.metadata;

import java.util.List;
import java.util.Map;

import cn.savory.esmanage.contract.vo.MetaFieldTypeVo;

/**
 * BuiltIn
 */
public interface IMetaFieldTypeProvider {

    /**
     * 获取元数据列表
     */
    List<MetaFieldTypeVo> getMetadataList();

    /**
     * 获取被标记为已经选择的
     */
    MetaFieldTypeVo toMetadata(String key);

    /**
     * 获取被标记为已经选择的
     */
    List<MetaFieldTypeVo> toMetadataList(List<String> keys);

    /**
     * 获取被标记为已经选择的
     */
    Map<String, MetaFieldTypeVo> toMetadataMap(List<String> keys);
}
