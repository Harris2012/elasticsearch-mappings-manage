package cn.savory.esmanage.contract;

import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;

public interface IDocumentService {

    DocumentItemsResponse items(DocumentItemsRequest request) throws Exception;

    DocumentCountResponse count(DocumentCountRequest request) throws Exception;

    DocumentItemResponse item(DocumentItemRequest request) throws Exception;

    DocumentCreateResponse create(DocumentCreateRequest request) throws Exception;

    DocumentBasicResponse basic(DocumentBasicRequest request) throws Exception;

    DocumentUpdateResponse update(DocumentUpdateRequest request) throws Exception;

    DocumentDisableResponse disable(DocumentDisableRequest request) throws Exception;

    DocumentEmptyResponse empty(DocumentEmptyRequest request) throws Exception;
}
