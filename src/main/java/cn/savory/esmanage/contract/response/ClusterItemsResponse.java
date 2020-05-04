package cn.savory.esmanage.contract.response;

import java.util.List;

import cn.savory.esmanage.contract.vo.ClusterExtendedVo;

public class ClusterItemsResponse extends BaseResponse {

    private List<ClusterExtendedVo> items;

    public List<ClusterExtendedVo> getItems() {
        return items;
    }

    public void setItems(List<ClusterExtendedVo> items) {
        this.items = items;
    }
}
