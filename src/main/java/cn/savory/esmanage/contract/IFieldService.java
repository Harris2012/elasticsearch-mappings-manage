package cn.savory.esmanage.contract;

import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;

public interface IFieldService {

    FieldItemsResponse items(FieldItemsRequest request) throws Exception;

    FieldCountResponse count(FieldCountRequest request) throws Exception;

    FieldItemResponse item(FieldItemRequest request) throws Exception;

    FieldCreateResponse create(FieldCreateRequest request) throws Exception;

    FieldBasicResponse basic(FieldBasicRequest request) throws Exception;

    FieldUpdateResponse update(FieldUpdateRequest request) throws Exception;

    FieldDisableResponse disable(FieldDisableRequest request) throws Exception;

    FieldEmptyResponse empty(FieldEmptyRequest request) throws Exception;
}
