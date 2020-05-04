package cn.savory.esmanage.contract.response;

public class FieldCountResponse extends BaseResponse {

    private Long totalCount;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
