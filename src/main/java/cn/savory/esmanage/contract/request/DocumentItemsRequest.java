package cn.savory.esmanage.contract.request;

public class DocumentItemsRequest extends DocumentCountRequest {

    private Integer pageIndex;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}
