package cn.savory.esmanage.contract.response;

import cn.savory.esmanage.contract.vo.DocumentExtendedVo;

public class DocumentItemResponse extends BaseResponse {

    private DocumentExtendedVo item;

    public DocumentExtendedVo getItem() {
        return item;
    }

    public void setItem(DocumentExtendedVo item) {
        this.item = item;
    }
}
