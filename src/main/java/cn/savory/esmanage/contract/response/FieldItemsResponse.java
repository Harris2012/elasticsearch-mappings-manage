package cn.savory.esmanage.contract.response;

import java.util.List;

import cn.savory.esmanage.contract.vo.FieldExtendedVo;

public class FieldItemsResponse extends BaseResponse {

    private List<FieldExtendedVo> items;

    public List<FieldExtendedVo> getItems() {
        return items;
    }

    public void setItems(List<FieldExtendedVo> items) {
        this.items = items;
    }
}
