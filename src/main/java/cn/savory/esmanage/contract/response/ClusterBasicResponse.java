package cn.savory.esmanage.contract.response;

import cn.savory.esmanage.contract.vo.ClusterBasicVo;

public class ClusterBasicResponse extends BaseResponse {

    private ClusterBasicVo item;

    public ClusterBasicVo getItem() {
        return item;
    }

    public void setItem(ClusterBasicVo item) {
        this.item = item;
    }
}
