package cn.savory.esmanage.contract.vo;

import java.util.Date;

public abstract class DocumentVo {

    private Integer clusterId;

    private Integer id;

    private String name;

    private String remark;

    private Integer numberOfShards;

    private Integer numberOfReplicas;

    private Integer mappingTotalFieldsLimit;

    private Boolean dynamic;

    private Date createTime;

    private Date lastUpdateTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getNumberOfShards() {
        return numberOfShards;
    }

    public void setNumberOfShards(Integer numberOfShards) {
        this.numberOfShards = numberOfShards;
    }

    public Integer getNumberOfReplicas() {
        return numberOfReplicas;
    }

    public void setNumberOfReplicas(Integer numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public Integer getMappingTotalFieldsLimit() {
        return mappingTotalFieldsLimit;
    }

    public void setMappingTotalFieldsLimit(Integer mappingTotalFieldsLimit) {
        this.mappingTotalFieldsLimit = mappingTotalFieldsLimit;
    }

    public Boolean getDynamic() {
        return dynamic;
    }

    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
