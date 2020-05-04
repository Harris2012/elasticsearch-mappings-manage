package cn.savory.esmanage.contract;

import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;

public interface IClusterService {

    ClusterItemsResponse items(ClusterItemsRequest request) throws Exception;

    ClusterCountResponse count(ClusterCountRequest request) throws Exception;

    ClusterItemResponse item(ClusterItemRequest request) throws Exception;

    ClusterCreateResponse create(ClusterCreateRequest request) throws Exception;

    ClusterBasicResponse basic(ClusterBasicRequest request) throws Exception;

    ClusterUpdateResponse update(ClusterUpdateRequest request) throws Exception;

    ClusterDisableResponse disable(ClusterDisableRequest request) throws Exception;

    ClusterEmptyResponse empty(ClusterEmptyRequest request) throws Exception;
}
