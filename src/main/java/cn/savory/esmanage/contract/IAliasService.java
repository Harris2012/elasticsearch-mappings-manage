package cn.savory.esmanage.contract;

import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;

public interface IAliasService {

    AliasItemsResponse items(AliasItemsRequest request) throws Exception;

    AliasCountResponse count(AliasCountRequest request) throws Exception;

    AliasItemResponse item(AliasItemRequest request) throws Exception;

    AliasCreateResponse create(AliasCreateRequest request) throws Exception;

    AliasBasicResponse basic(AliasBasicRequest request) throws Exception;

    AliasUpdateResponse update(AliasUpdateRequest request) throws Exception;

    AliasDisableResponse disable(AliasDisableRequest request) throws Exception;

    AliasEmptyResponse empty(AliasEmptyRequest request) throws Exception;
}
