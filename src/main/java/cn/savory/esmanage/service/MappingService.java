package cn.savory.esmanage.service;

import cn.savory.esmanage.contract.IMappingService;
import cn.savory.esmanage.contract.request.MappingCommitRequest;
import cn.savory.esmanage.contract.request.MappingPreviewRequest;
import cn.savory.esmanage.contract.response.MappingCommitResponse;
import cn.savory.esmanage.contract.response.MappingPreviewResponse;
import cn.savory.esmanage.convertor.IClusterConvertor;
import cn.savory.esmanage.convertor.IDocumentConvertor;
import cn.savory.esmanage.convertor.IFieldConvertor;
import cn.savory.esmanage.esmapping.*;
import cn.savory.esmanage.proxy.GitlabProxy;
import cn.savory.esmanage.repository.IAliasRepository;
import cn.savory.esmanage.repository.IClusterRepository;
import cn.savory.esmanage.repository.IDocumentRepository;
import cn.savory.esmanage.repository.IFieldRepository;
import cn.savory.esmanage.repository.entity.AliasEntity;
import cn.savory.esmanage.repository.entity.ClusterEntity;
import cn.savory.esmanage.repository.entity.DocumentEntity;
import cn.savory.esmanage.repository.entity.FieldEntity;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@ResponseBody
@RestController
@RequestMapping("/api/mapping")
public class MappingService implements IMappingService {

    @Autowired
    private IClusterRepository clusterRepository;

    @Autowired
    private IDocumentRepository documentRepository;

    @Autowired
    private IFieldRepository fieldRepository;

    @Autowired
    private IAliasRepository aliasRepository;

    @Autowired
    private GitlabProxy gitlabProxy;

    @Override
    @RequestMapping(path = "preview", method = RequestMethod.POST)
    public MappingPreviewResponse preview(@RequestBody MappingPreviewRequest request) throws Exception {
        MappingPreviewResponse response = new MappingPreviewResponse();

        ClusterEntity clusterEntity = clusterRepository.getById(request.getClusterId());
        DocumentEntity documentEntity = documentRepository.getById(request.getDocumentId());
        List<FieldEntity> fieldEntityList = fieldRepository.getEntityList(request.getClusterId(), request.getDocumentId());
        List<AliasEntity> aliasEntityList = aliasRepository.getEntityList(request.getClusterId(), request.getDocumentId());

        MappingsFile mappingsFile = toMappingFile(documentEntity, fieldEntityList, aliasEntityList);

        String content = new MappingsEngine().generate(mappingsFile);
        response.setContent(content);

        response.setStatus(1);
        return response;
    }

    @Override
    @RequestMapping(path = "commit", method = RequestMethod.POST)
    public MappingCommitResponse commit(@RequestBody MappingCommitRequest request) throws Exception {
        MappingCommitResponse response = new MappingCommitResponse();

        ClusterEntity clusterEntity = clusterRepository.getById(request.getClusterId());
        DocumentEntity documentEntity = documentRepository.getById(request.getDocumentId());
        List<FieldEntity> fieldEntityList = fieldRepository.getEntityList(request.getClusterId(), request.getDocumentId());
        List<AliasEntity> aliasEntityList = aliasRepository.getEntityList(request.getClusterId(), request.getDocumentId());

        MappingsFile mappingsFile = toMappingFile(documentEntity, fieldEntityList, aliasEntityList);

        String content = new MappingsEngine().generate(mappingsFile);

        String message = null;
        String fileName = String.join("%2F", clusterEntity.getName(), documentEntity.getName() + ".json");
        String oldContent = gitlabProxy.getContent(fileName);
        if (oldContent == null) {
            message = gitlabProxy.create(fileName, content);
        } else if (oldContent.equalsIgnoreCase(content)) {
            message = "无任何改动";
        } else {
            message = gitlabProxy.update(fileName, content);
        }

        if (message == null) {
            response.setStatus(1);
        } else {
            response.setMessage(message);
        }

        return response;
    }

    private MappingsFile toMappingFile(DocumentEntity documentEntity, List<FieldEntity> fieldEntityList, List<AliasEntity> aliasEntityList) {
        MappingsFile mappingsFile = new MappingsFile();

        if (aliasEntityList != null && !aliasEntityList.isEmpty()) {
            mappingsFile.setAliases(aliasEntityList.stream().map(AliasEntity::getName).collect(Collectors.toList()));
        }

        Settings settings = toSettings(documentEntity);
        mappingsFile.setSettings(settings);

        Document document = toDocument(documentEntity, fieldEntityList);
        mappingsFile.setDocument(document);

        return mappingsFile;
    }

    private Settings toSettings(DocumentEntity documentEntity) {
        Settings settings = new Settings();

        settings.setNumberOfShards(documentEntity.getNumberOfShards());
        settings.setNumberOfReplicas(documentEntity.getNumberOfReplicas());
        settings.setMappingTotalFieldsLimit(documentEntity.getMappingTotalFieldsLimit());

        return settings;
    }

    private Document toDocument(DocumentEntity documentEntity, List<FieldEntity> fieldEntityList) {
        Document document = new Document();

        document.setDynamic(documentEntity.getDynamic());

        document.setFields(toFieldList(fieldEntityList));

        return document;
    }

    private List<Field> toFieldList(List<FieldEntity> fieldEntityList) {

        List<Field> returnValue = Lists.newArrayListWithCapacity(fieldEntityList.size());

        for (FieldEntity fieldEntity : fieldEntityList) {
            Field field = new Field();
            field.setFieldName(fieldEntity.getName());
            field.setFieldType(fieldEntity.getFieldType());

            returnValue.add(field);
        }

        return returnValue;
    }
}
