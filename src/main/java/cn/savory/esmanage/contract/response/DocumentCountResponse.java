package cn.savory.esmanage.contract.response;

public class DocumentCountResponse extends BaseResponse {

    private Long totalCount;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
