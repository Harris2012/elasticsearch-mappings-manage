package cn.savory.esmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.savory.esmanage.contract.IFieldService;
import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;
import cn.savory.esmanage.convertor.IFieldConvertor;
import cn.savory.esmanage.metadata.*;
import cn.savory.esmanage.repository.entity.FieldEntity;
import cn.savory.esmanage.repository.IFieldRepository;

@ResponseBody
@RestController
@RequestMapping("/api/field")
public class FieldService extends BaseService implements IFieldService {

    private final static int PAGE_SIZE = 15;

    @Autowired
    private IFieldRepository fieldRepository;

    @Autowired
    private IFieldConvertor fieldConvertor;

    @Autowired
    private IMetaFieldTypeProvider metaFieldTypeProvider;

    @Override
    @RequestMapping(path = "items", method = RequestMethod.POST)
    public FieldItemsResponse items(@RequestBody FieldItemsRequest request) throws Exception {

        FieldItemsResponse response = new FieldItemsResponse();

        List<FieldEntity> entityList = fieldRepository.getPagedEntityList(request.getClusterId(), request.getDocumentId(), request.getPageIndex(), PAGE_SIZE);

        response.setItems(fieldConvertor.toExtendedVoList(entityList));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "count", method = RequestMethod.POST)
    public FieldCountResponse count(@RequestBody FieldCountRequest request) throws Exception {

        FieldCountResponse response = new FieldCountResponse();

        Long count = fieldRepository.getCount(request.getClusterId(), request.getDocumentId());

        response.setTotalCount(count);

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "item", method = RequestMethod.POST)
    public FieldItemResponse item(@RequestBody FieldItemRequest request) throws Exception {

        FieldItemResponse response = new FieldItemResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        FieldEntity entity = fieldRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(fieldConvertor.toExtendedVo(entity));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "create", method = RequestMethod.POST)
    public FieldCreateResponse create(@RequestBody FieldCreateRequest request) throws Exception {

        FieldCreateResponse response = new FieldCreateResponse();

        fieldRepository.create(fieldConvertor.toEntity(request));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "basic", method = RequestMethod.POST)
    public FieldBasicResponse basic(@RequestBody FieldBasicRequest request) throws Exception {

        FieldBasicResponse response = new FieldBasicResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        FieldEntity entity = fieldRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(fieldConvertor.toBasicVo(entity));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "update", method = RequestMethod.POST)
    public FieldUpdateResponse update(@RequestBody FieldUpdateRequest request) throws Exception {

        FieldUpdateResponse response = new FieldUpdateResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        FieldEntity entity = fieldRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        fieldRepository.update(fieldConvertor.toEntity(request));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "disable", method = RequestMethod.POST)
    public FieldDisableResponse disable(@RequestBody FieldDisableRequest request) throws Exception {

        FieldDisableResponse response = new FieldDisableResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        FieldEntity entity = fieldRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        fieldRepository.disableById(request.getId());

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "empty", method = RequestMethod.POST)
    public FieldEmptyResponse empty(@RequestBody FieldEmptyRequest request) throws Exception {
        FieldEmptyResponse response = new FieldEmptyResponse();

        response.setFieldType(metaFieldTypeProvider.getMetadataList());

        response.setStatus(1);
        return response;
    }
}
