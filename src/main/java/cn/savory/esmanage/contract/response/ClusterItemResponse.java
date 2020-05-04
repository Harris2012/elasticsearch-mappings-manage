package cn.savory.esmanage.contract.response;

import cn.savory.esmanage.contract.vo.ClusterExtendedVo;

public class ClusterItemResponse extends BaseResponse {

    private ClusterExtendedVo item;

    public ClusterExtendedVo getItem() {
        return item;
    }

    public void setItem(ClusterExtendedVo item) {
        this.item = item;
    }
}
