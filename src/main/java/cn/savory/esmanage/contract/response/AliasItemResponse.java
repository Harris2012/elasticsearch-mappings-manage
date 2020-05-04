package cn.savory.esmanage.contract.response;

import cn.savory.esmanage.contract.vo.AliasExtendedVo;

public class AliasItemResponse extends BaseResponse {

    private AliasExtendedVo item;

    public AliasExtendedVo getItem() {
        return item;
    }

    public void setItem(AliasExtendedVo item) {
        this.item = item;
    }
}
