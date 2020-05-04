package cn.savory.esmanage.contract.response;

import java.util.List;

import cn.savory.esmanage.contract.vo.AliasExtendedVo;

public class AliasItemsResponse extends BaseResponse {

    private List<AliasExtendedVo> items;

    public List<AliasExtendedVo> getItems() {
        return items;
    }

    public void setItems(List<AliasExtendedVo> items) {
        this.items = items;
    }
}
