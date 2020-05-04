package cn.savory.esmanage.contract.request;

public class ClusterItemsRequest extends ClusterCountRequest {

    private Integer pageIndex;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}
