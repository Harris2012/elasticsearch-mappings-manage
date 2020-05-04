package cn.savory.esmanage.contract.request;

import cn.savory.esmanage.contract.vo.DocumentBasicVo;

public class DocumentCreateRequest {

    private Integer clusterId;

    private DocumentBasicVo item;

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public DocumentBasicVo getItem() {
        return item;
    }

    public void setItem(DocumentBasicVo item) {
        this.item = item;
    }
}
