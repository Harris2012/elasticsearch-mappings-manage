package cn.savory.esmanage.contract.response;

import java.util.List;

import cn.savory.esmanage.contract.vo.DocumentExtendedVo;

public class DocumentItemsResponse extends BaseResponse {

    private List<DocumentExtendedVo> items;

    public List<DocumentExtendedVo> getItems() {
        return items;
    }

    public void setItems(List<DocumentExtendedVo> items) {
        this.items = items;
    }
}
