package cn.savory.esmanage.contract.response;

import cn.savory.esmanage.contract.vo.AliasBasicVo;

public class AliasBasicResponse extends BaseResponse {

    private AliasBasicVo item;

    public AliasBasicVo getItem() {
        return item;
    }

    public void setItem(AliasBasicVo item) {
        this.item = item;
    }
}
