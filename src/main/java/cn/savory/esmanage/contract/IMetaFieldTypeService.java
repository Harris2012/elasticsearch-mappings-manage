package cn.savory.esmanage.contract;

import cn.savory.esmanage.contract.request.MetaFieldTypeItemsRequest;
import cn.savory.esmanage.contract.response.MetaFieldTypeItemsResponse;

public interface IMetaFieldTypeService {

    MetaFieldTypeItemsResponse items(MetaFieldTypeItemsRequest request);
}
