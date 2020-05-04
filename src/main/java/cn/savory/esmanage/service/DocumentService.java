package cn.savory.esmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.savory.esmanage.contract.IDocumentService;
import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;
import cn.savory.esmanage.convertor.IDocumentConvertor;
import cn.savory.esmanage.repository.entity.DocumentEntity;
import cn.savory.esmanage.repository.IDocumentRepository;

@ResponseBody
@RestController
@RequestMapping("/api/document")
public class DocumentService extends BaseService implements IDocumentService {

    private final static int PAGE_SIZE = 15;

    @Autowired
    private IDocumentRepository documentRepository;

    @Autowired
    private IDocumentConvertor documentConvertor;

    @Override
    @RequestMapping(path = "items", method = RequestMethod.POST)
    public DocumentItemsResponse items(@RequestBody DocumentItemsRequest request) throws Exception {

        DocumentItemsResponse response = new DocumentItemsResponse();

        List<DocumentEntity> entityList = documentRepository.getPagedEntityList(request.getClusterId(), request.getPageIndex(), PAGE_SIZE);

        response.setItems(documentConvertor.toExtendedVoList(entityList));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "count", method = RequestMethod.POST)
    public DocumentCountResponse count(@RequestBody DocumentCountRequest request) throws Exception {

        DocumentCountResponse response = new DocumentCountResponse();

        Long count = documentRepository.getCount(request.getClusterId());

        response.setTotalCount(count);

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "item", method = RequestMethod.POST)
    public DocumentItemResponse item(@RequestBody DocumentItemRequest request) throws Exception {

        DocumentItemResponse response = new DocumentItemResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        DocumentEntity entity = documentRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(documentConvertor.toExtendedVo(entity));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "create", method = RequestMethod.POST)
    public DocumentCreateResponse create(@RequestBody DocumentCreateRequest request) throws Exception {

        DocumentCreateResponse response = new DocumentCreateResponse();

        documentRepository.create(documentConvertor.toEntity(request));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "basic", method = RequestMethod.POST)
    public DocumentBasicResponse basic(@RequestBody DocumentBasicRequest request) throws Exception {

        DocumentBasicResponse response = new DocumentBasicResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        DocumentEntity entity = documentRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        response.setItem(documentConvertor.toBasicVo(entity));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "update", method = RequestMethod.POST)
    public DocumentUpdateResponse update(@RequestBody DocumentUpdateRequest request) throws Exception {

        DocumentUpdateResponse response = new DocumentUpdateResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        DocumentEntity entity = documentRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        documentRepository.update(documentConvertor.toEntity(request));

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "disable", method = RequestMethod.POST)
    public DocumentDisableResponse disable(@RequestBody DocumentDisableRequest request) throws Exception {

        DocumentDisableResponse response = new DocumentDisableResponse();

        if (request.getId() <= 0) {
            response.setStatus(-1);
            return response;
        }

        DocumentEntity entity = documentRepository.getById(request.getId());
        if (entity == null) {
            response.setStatus(404);
            return response;
        }

        documentRepository.disableById(request.getId());

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "empty", method = RequestMethod.POST)
    public DocumentEmptyResponse empty(@RequestBody DocumentEmptyRequest request) throws Exception {
        DocumentEmptyResponse response = new DocumentEmptyResponse();

        response.setStatus(1);
        return response;
    }
}
