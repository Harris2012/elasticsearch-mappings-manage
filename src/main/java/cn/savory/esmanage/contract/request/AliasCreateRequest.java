package cn.savory.esmanage.contract.request;

import cn.savory.esmanage.contract.vo.AliasBasicVo;

public class AliasCreateRequest {

    private Integer clusterId;

    private Integer documentId;

    private AliasBasicVo item;

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

    public AliasBasicVo getItem() {
        return item;
    }

    public void setItem(AliasBasicVo item) {
        this.item = item;
    }
}
