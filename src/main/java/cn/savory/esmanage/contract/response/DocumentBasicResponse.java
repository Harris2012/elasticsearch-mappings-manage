package cn.savory.esmanage.contract.response;

import cn.savory.esmanage.contract.vo.DocumentBasicVo;

public class DocumentBasicResponse extends BaseResponse {

    private DocumentBasicVo item;

    public DocumentBasicVo getItem() {
        return item;
    }

    public void setItem(DocumentBasicVo item) {
        this.item = item;
    }
}
