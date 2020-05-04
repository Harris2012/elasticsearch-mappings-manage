package cn.savory.esmanage.codedom;

import com.google.common.collect.Maps;

import java.util.Map;

public class DataObject extends DataValueOrObject {

    /// <summary>
    /// 每一个Value是一个值
    /// </summary>
    public Map<String, DataValue> dataValueMap;

    /// <summary>
    /// 每个Value是一个Object
    /// </summary>
    public Map<String, DataObject> dataObjectMap;

    /// <summary>
    /// 每个元素是一个数组
    /// </summary>
    public Map<String, DataArray> dataArrayMap;

    public Map<String, DataValue> getDataValueMap() {
        return dataValueMap;
    }

    public void setDataValueMap(Map<String, DataValue> dataValueMap) {
        this.dataValueMap = dataValueMap;
    }

    public Map<String, DataObject> getDataObjectMap() {
        return dataObjectMap;
    }

    public void setDataObjectMap(Map<String, DataObject> dataObjectMap) {
        this.dataObjectMap = dataObjectMap;
    }

    public Map<String, DataArray> getDataArrayMap() {
        return dataArrayMap;
    }

    public void setDataArrayMap(Map<String, DataArray> dataArrayMap) {
        this.dataArrayMap = dataArrayMap;
    }

    public void addDataValue(String key, DataValue dataValue) {
        if (this.dataValueMap == null) {
            this.dataValueMap = Maps.newLinkedHashMap();
        }
        this.dataValueMap.putIfAbsent(key, dataValue);
    }

    public DataValue addDataValue(String key) {
        if (this.dataValueMap == null) {
            this.dataValueMap = Maps.newLinkedHashMap();
        }
        DataValue dataValue = new DataValue();
        this.dataValueMap.putIfAbsent(key, dataValue);
        return dataValue;
    }

    public void addDataObject(String key, DataObject subDataObject) {
        if (this.dataObjectMap == null) {
            this.dataObjectMap = Maps.newLinkedHashMap();
        }

        this.dataObjectMap.putIfAbsent(key, subDataObject);
    }

    public DataObject addDataObject(String key) {
        if (this.dataObjectMap == null) {
            this.dataObjectMap = Maps.newLinkedHashMap();
        }

        DataObject subDataObject = new DataObject();

        this.dataObjectMap.putIfAbsent(key, subDataObject);

        return subDataObject;
    }

    public void addDataArray(String key, DataArray dataArray) {
        if (this.dataArrayMap == null) {
            this.dataArrayMap = Maps.newLinkedHashMap();
        }

        this.dataArrayMap.putIfAbsent(key, dataArray);
    }

    public DataArray addDataArray(String key) {
        if (this.dataArrayMap == null) {
            this.dataArrayMap = Maps.newLinkedHashMap();
        }
        DataArray dataArray = new DataArray();
        this.dataArrayMap.putIfAbsent(key, dataArray);
        return dataArray;
    }
}
