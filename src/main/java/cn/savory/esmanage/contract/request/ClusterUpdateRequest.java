package cn.savory.esmanage.contract.request;

import cn.savory.esmanage.contract.vo.ClusterBasicVo;

public class ClusterUpdateRequest {

    private Integer id;

    private ClusterBasicVo item;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClusterBasicVo getItem() {
        return item;
    }

    public void setItem(ClusterBasicVo item) {
        this.item = item;
    }
}
