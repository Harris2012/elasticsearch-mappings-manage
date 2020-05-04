package cn.savory.esmanage.contract.request;

import cn.savory.esmanage.contract.vo.AliasBasicVo;

public class AliasUpdateRequest {

    private Integer clusterId;

    private Integer documentId;

    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AliasBasicVo getItem() {
        return item;
    }

    public void setItem(AliasBasicVo item) {
        this.item = item;
    }
}
