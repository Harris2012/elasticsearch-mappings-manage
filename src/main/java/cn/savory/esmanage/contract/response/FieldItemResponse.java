package cn.savory.esmanage.contract.response;

import cn.savory.esmanage.contract.vo.FieldExtendedVo;

public class FieldItemResponse extends BaseResponse {

    private FieldExtendedVo item;

    public FieldExtendedVo getItem() {
        return item;
    }

    public void setItem(FieldExtendedVo item) {
        this.item = item;
    }
}
