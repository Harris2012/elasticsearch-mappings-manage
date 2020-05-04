package cn.savory.esmanage.contract.response;

import cn.savory.esmanage.contract.vo.FieldBasicVo;

public class FieldBasicResponse extends BaseResponse {

    private FieldBasicVo item;

    public FieldBasicVo getItem() {
        return item;
    }

    public void setItem(FieldBasicVo item) {
        this.item = item;
    }
}
