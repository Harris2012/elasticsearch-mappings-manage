package cn.savory.esmanage.contract.response;

import java.util.List;

import cn.savory.esmanage.contract.vo.*;

public class FieldEmptyResponse extends BaseResponse {

    private List<MetaFieldTypeVo> fieldType;

    public List<MetaFieldTypeVo> getFieldType() {
        return fieldType;
    }

    public void setFieldType(List<MetaFieldTypeVo> fieldType) {
        this.fieldType = fieldType;
    }
}
