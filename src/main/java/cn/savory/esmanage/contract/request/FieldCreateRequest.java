package cn.savory.esmanage.contract.request;

import cn.savory.esmanage.contract.vo.FieldBasicVo;

public class FieldCreateRequest {

    private Integer clusterId;

    private Integer documentId;

    private FieldBasicVo item;

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public FieldBasicVo getItem() {
        return item;
    }

    public void setItem(FieldBasicVo item) {
        this.item = item;
    }
}
