package cn.savory.esmanage.contract;

import cn.savory.esmanage.contract.request.*;
import cn.savory.esmanage.contract.response.*;

public interface IMappingService {

    MappingPreviewResponse preview(MappingPreviewRequest request) throws Exception;

    MappingCommitResponse commit(MappingCommitRequest request) throws Exception;
}
