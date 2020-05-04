package cn.savory.esmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.savory.esmanage.contract.IAliasService;
import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;
import cn.savory.esmanage.convertor.IAliasConvertor;
import cn.savory.esmanage.repository.entity.AliasEntity;
import cn.savory.esmanage.repository.IAliasRepository;

@ResponseBody
@RestController
@RequestMapping("/api/alias")
public class AliasService extends BaseService implements IAliasService {

    private final static int PAGE_SIZE = 15;

    @Autowired
    private IAliasRepository aliasRepository;

    @Autowired
    private IAliasConvertor aliasConvertor;

    @Override
    @RequestMapping(path = "items", method = RequestMethod.POST)
    public AliasItemsResponse items(@RequestBody AliasItemsRequest request) throws Exception {

        AliasItemsResponse response = new AliasItemsResponse();

        List<AliasEntity> entityList = aliasRepository.getPagedEntityList(request.getClusterId(), request.getDocumentId(), request.getPageIndex(), PAGE_SIZE);

        response.setItems(aliasConvertor.toExtendedVoList(entityList));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "count", method = RequestMethod.POST)
    public AliasCountResponse count(@RequestBody AliasCountRequest request) throws Exception {

        AliasCountResponse response = new AliasCountResponse();

        Long count = aliasRepository.getCount(request.getClusterId(), request.getDocumentId());

        response.setTotalCount(count);

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "item", method = RequestMethod.POST)
    public AliasItemResponse item(@RequestBody AliasItemRequest request) throws Exception {

        AliasItemResponse response = new AliasItemResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        AliasEntity entity = aliasRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(aliasConvertor.toExtendedVo(entity));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "create", method = RequestMethod.POST)
    public AliasCreateResponse create(@RequestBody AliasCreateRequest request) throws Exception {

        AliasCreateResponse response = new AliasCreateResponse();

        aliasRepository.create(aliasConvertor.toEntity(request));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "basic", method = RequestMethod.POST)
    public AliasBasicResponse basic(@RequestBody AliasBasicRequest request) throws Exception {

        AliasBasicResponse response = new AliasBasicResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        AliasEntity entity = aliasRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(aliasConvertor.toBasicVo(entity));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "update", method = RequestMethod.POST)
    public AliasUpdateResponse update(@RequestBody AliasUpdateRequest request) throws Exception {

        AliasUpdateResponse response = new AliasUpdateResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        AliasEntity entity = aliasRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        aliasRepository.update(aliasConvertor.toEntity(request));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "disable", method = RequestMethod.POST)
    public AliasDisableResponse disable(@RequestBody AliasDisableRequest request) throws Exception {

        AliasDisableResponse response = new AliasDisableResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        AliasEntity entity = aliasRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        aliasRepository.disableById(request.getId());

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "empty", method = RequestMethod.POST)
    public AliasEmptyResponse empty(@RequestBody AliasEmptyRequest request) throws Exception {
        AliasEmptyResponse response = new AliasEmptyResponse();

        response.setStatus(1);
        return response;
    }
}
