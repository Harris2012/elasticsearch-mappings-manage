package cn.savory.esmanage.esmapping;

public class Settings {

    private Integer numberOfShards;

    private Integer numberOfReplicas;

    private Integer mappingTotalFieldsLimit;

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
}
