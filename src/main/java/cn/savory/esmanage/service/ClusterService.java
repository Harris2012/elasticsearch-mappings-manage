package cn.savory.esmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.savory.esmanage.contract.IClusterService;
import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;
import cn.savory.esmanage.convertor.IClusterConvertor;
import cn.savory.esmanage.repository.entity.ClusterEntity;
import cn.savory.esmanage.repository.IClusterRepository;

@ResponseBody
@RestController
@RequestMapping("/api/cluster")
public class ClusterService extends BaseService implements IClusterService {

    private final static int PAGE_SIZE = 15;

    @Autowired
    private IClusterRepository clusterRepository;

    @Autowired
    private IClusterConvertor clusterConvertor;

    @Override
    @RequestMapping(path = "items", method = RequestMethod.POST)
    public ClusterItemsResponse items(@RequestBody ClusterItemsRequest request) throws Exception {

        ClusterItemsResponse response = new ClusterItemsResponse();

        List<ClusterEntity> entityList = clusterRepository.getPagedEntityList(request.getPageIndex(), PAGE_SIZE);

        response.setItems(clusterConvertor.toExtendedVoList(entityList));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "count", method = RequestMethod.POST)
    public ClusterCountResponse count(@RequestBody ClusterCountRequest request) throws Exception {

        ClusterCountResponse response = new ClusterCountResponse();

        Long count = clusterRepository.getCount();

        response.setTotalCount(count);

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "item", method = RequestMethod.POST)
    public ClusterItemResponse item(@RequestBody ClusterItemRequest request) throws Exception {

        ClusterItemResponse response = new ClusterItemResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        ClusterEntity entity = clusterRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(clusterConvertor.toExtendedVo(entity));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "create", method = RequestMethod.POST)
    public ClusterCreateResponse create(@RequestBody ClusterCreateRequest request) throws Exception {

        ClusterCreateResponse response = new ClusterCreateResponse();

        clusterRepository.create(clusterConvertor.toEntity(request));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "basic", method = RequestMethod.POST)
    public ClusterBasicResponse basic(@RequestBody ClusterBasicRequest request) throws Exception {

        ClusterBasicResponse response = new ClusterBasicResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        ClusterEntity entity = clusterRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(clusterConvertor.toBasicVo(entity));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "update", method = RequestMethod.POST)
    public ClusterUpdateResponse update(@RequestBody ClusterUpdateRequest request) throws Exception {

        ClusterUpdateResponse response = new ClusterUpdateResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        ClusterEntity entity = clusterRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        clusterRepository.update(clusterConvertor.toEntity(request));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "disable", method = RequestMethod.POST)
    public ClusterDisableResponse disable(@RequestBody ClusterDisableRequest request) throws Exception {

        ClusterDisableResponse response = new ClusterDisableResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        ClusterEntity entity = clusterRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        clusterRepository.disableById(request.getId());

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "empty", method = RequestMethod.POST)
    public ClusterEmptyResponse empty(@RequestBody ClusterEmptyRequest request) throws Exception {
        ClusterEmptyResponse response = new ClusterEmptyResponse();

        response.setStatus(1);
        return response;
    }
}
