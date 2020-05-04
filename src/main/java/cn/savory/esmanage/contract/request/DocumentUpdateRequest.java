package cn.savory.esmanage.contract.request;

import cn.savory.esmanage.contract.vo.DocumentBasicVo;

public class DocumentUpdateRequest {

    private Integer clusterId;

    private Integer id;

    private DocumentBasicVo item;

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentBasicVo getItem() {
        return item;
    }

    public void setItem(DocumentBasicVo item) {
        this.item = item;
    }
}
