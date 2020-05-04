package cn.savory.esmanage.contract.response;

import java.util.List;

import cn.savory.esmanage.contract.vo.MetaFieldTypeVo;

public class MetaFieldTypeItemsResponse extends BaseResponse {

    private List<MetaFieldTypeVo> items;

    public List<MetaFieldTypeVo> getItems() {
        return items;
    }

    public void setItems(List<MetaFieldTypeVo> items) {
        this.items = items;
    }
}
