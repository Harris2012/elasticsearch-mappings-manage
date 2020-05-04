package cn.savory.esmanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.savory.esmanage.contract.IMetaFieldTypeService;
import cn.savory.esmanage.contract.request.MetaFieldTypeItemsRequest;
import cn.savory.esmanage.contract.response.MetaFieldTypeItemsResponse;
import cn.savory.esmanage.metadata.IMetaFieldTypeProvider;

@ResponseBody
@RestController
@RequestMapping("/api/meta-field-type")
public class MetaFieldTypeService extends BaseService implements IMetaFieldTypeService {

    @Autowired
    private IMetaFieldTypeProvider metaFieldTypeProvider;

    public MetaFieldTypeService(IMetaFieldTypeProvider metaFieldTypeProvider) {
        this.metaFieldTypeProvider = metaFieldTypeProvider;
    }

    @Override
    @RequestMapping(path = "items", method = RequestMethod.POST)
    public MetaFieldTypeItemsResponse items(MetaFieldTypeItemsRequest request) {

        MetaFieldTypeItemsResponse response = new MetaFieldTypeItemsResponse();

        response.setItems(metaFieldTypeProvider.getMetadataList());

        response.setStatus(1);
        return response;
    }
}
