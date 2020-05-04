package cn.savory.esmanage.metadata.implement;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import cn.savory.esmanage.constant.MetaFieldTypeName;
import cn.savory.esmanage.contract.vo.MetaFieldTypeVo;
import cn.savory.esmanage.metadata.IMetaFieldTypeProvider;

/**
 * BuiltIn
 */
@Service
public class MetaFieldTypeProvider implements IMetaFieldTypeProvider {

    private Map<String, MetaFieldTypeVo> map = Maps.newLinkedHashMap();

    public MetaFieldTypeProvider() {
        map.putIfAbsent(MetaFieldTypeName.INTEGER, new MetaFieldTypeVo(MetaFieldTypeName.INTEGER, "integer"));
        map.putIfAbsent(MetaFieldTypeName.LONG, new MetaFieldTypeVo(MetaFieldTypeName.LONG, "long"));
        map.putIfAbsent(MetaFieldTypeName.TEXT, new MetaFieldTypeVo(MetaFieldTypeName.TEXT, "text"));
        map.putIfAbsent(MetaFieldTypeName.KEYWORD, new MetaFieldTypeVo(MetaFieldTypeName.KEYWORD, "keyword"));
        map.putIfAbsent(MetaFieldTypeName.BYTE, new MetaFieldTypeVo(MetaFieldTypeName.BYTE, "byte"));
        map.putIfAbsent(MetaFieldTypeName.SHORT, new MetaFieldTypeVo(MetaFieldTypeName.SHORT, "short"));
        map.putIfAbsent(MetaFieldTypeName.DOUBLE, new MetaFieldTypeVo(MetaFieldTypeName.DOUBLE, "double"));
        map.putIfAbsent(MetaFieldTypeName.BOOLEAN, new MetaFieldTypeVo(MetaFieldTypeName.BOOLEAN, "boolean"));
        map.putIfAbsent(MetaFieldTypeName.DATE, new MetaFieldTypeVo(MetaFieldTypeName.DATE, "date"));
        map.putIfAbsent(MetaFieldTypeName.RANGE, new MetaFieldTypeVo(MetaFieldTypeName.RANGE, "range"));
        map.putIfAbsent(MetaFieldTypeName.BINARY, new MetaFieldTypeVo(MetaFieldTypeName.BINARY, "binary"));
        map.putIfAbsent(MetaFieldTypeName.FLOAT, new MetaFieldTypeVo(MetaFieldTypeName.FLOAT, "float"));
    }

    @Override
    public List<MetaFieldTypeVo> getMetadataList() {
        return Lists.newArrayList(map.values());
    }

    @Override
    public MetaFieldTypeVo toMetadata(String key) {
        return map.get(key);
    }

    @Override
    public List<MetaFieldTypeVo> toMetadataList(List<String> keys) {
        if (keys == null || keys.isEmpty()) {
            return null;
        }
        List<MetaFieldTypeVo> voList = Lists.newArrayListWithCapacity(keys.size());
        for (String key : keys) {
            MetaFieldTypeVo vo = map.get(key);
            if (vo == null) {
                continue;
            }
            voList.add(vo);
        }

        return voList;
    }

    @Override
    public Map<String, MetaFieldTypeVo> toMetadataMap(List<String> keys) {
        if (keys == null || keys.isEmpty()) {
            return null;
        }
        Map<String, MetaFieldTypeVo> voList = Maps.newLinkedHashMapWithExpectedSize(keys.size());
        for (String key : keys) {
            MetaFieldTypeVo vo = map.get(key);
            if (vo == null) {
                continue;
            }
            voList.putIfAbsent(key, vo);
        }

        return voList;
    }
}
