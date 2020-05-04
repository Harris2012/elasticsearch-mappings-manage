package cn.savory.esmanage.convertor;

import java.util.List;

import cn.savory.esmanage.contract.request.DocumentCreateRequest;
import cn.savory.esmanage.contract.request.DocumentUpdateRequest;
import cn.savory.esmanage.contract.vo.DocumentBasicVo;
import cn.savory.esmanage.contract.vo.DocumentExtendedVo;
import cn.savory.esmanage.repository.entity.DocumentEntity;

public interface IDocumentConvertor {

    /**
     * request => entity
     */
    DocumentEntity toEntity(DocumentCreateRequest request);

    /**
     * request => entity
     */
    DocumentEntity toEntity(DocumentUpdateRequest request);

    /**
     * entity => basicVo
     */
    DocumentBasicVo toBasicVo(DocumentEntity entity);

    /**
     * entityList => basicVoList
     */
    List<DocumentBasicVo> toBasicVoList(List<DocumentEntity> entityList);

    /**
     * entity => extendedVo
     */
    DocumentExtendedVo toExtendedVo(DocumentEntity entity);

    /**
     * entityList => extendedVoList
     */
    List<DocumentExtendedVo> toExtendedVoList(List<DocumentEntity> entityList);
}
