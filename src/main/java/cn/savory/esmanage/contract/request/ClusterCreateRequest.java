package cn.savory.esmanage.contract.request;

import cn.savory.esmanage.contract.vo.ClusterBasicVo;

public class ClusterCreateRequest {

    private ClusterBasicVo item;

    public ClusterBasicVo getItem() {
        return item;
    }

    public void setItem(ClusterBasicVo item) {
        this.item = item;
    }
}
