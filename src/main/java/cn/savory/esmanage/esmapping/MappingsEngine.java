package cn.savory.esmanage.esmapping;

import cn.savory.esmanage.codedom.*;

public class MappingsEngine {

    public String generate(MappingsFile mappingsFile) {

        DataObject dataObject = fromMappingsFile(mappingsFile);

        StringBuffer stringBuffer = new StringBuffer();

        new CodeEngine().generateDataObject(dataObject, new CodeWriter(stringBuffer), new GenerateOptions(), false);

        return stringBuffer.toString();
    }

    private DataObject fromMappingsFile(MappingsFile mappingsFile) {

        DataObject dataObject = new DataObject();

        if (mappingsFile.getAliases() != null && !mappingsFile.getAliases().isEmpty()) {
            DataObject array = dataObject.addDataObject("aliases");
            for (String alias : mappingsFile.getAliases()) {
                array.addDataObject(alias, new DataObject());
            }
        }

        if (mappingsFile.getSettings() != null) {
            DataObject settingsDataObject = fromSettings(mappingsFile.getSettings());
            dataObject.addDataObject("settings", settingsDataObject);
        }

        if (mappingsFile.getDocument() != null) {
            DataObject documentDataObject = fromDocument(mappingsFile.getDocument());
            if (documentDataObject != null) {
                String indexName = mappingsFile.getDocument().getName() != null ? mappingsFile.getDocument().getName() : "_doc";
                dataObject.addDataObject("mappings").addDataObject(indexName, documentDataObject);
            }
        }

        return dataObject;
    }

    private DataObject fromSettings(Settings settings) {
        if (settings == null) {
            return null;
        }

        DataObject dataObject = new DataObject();

        if (settings.getNumberOfShards() != null) {
            dataObject.addDataValue("number_of_shards", DataValue.fromIntValue(settings.getNumberOfShards()));
        }
        if (settings.getNumberOfReplicas() != null) {
            dataObject.addDataValue("number_of_replicas", DataValue.fromIntValue(settings.getNumberOfReplicas()));
        }
        if (settings.getMappingTotalFieldsLimit() != null) {
            dataObject.addDataValue("mapping.total_fields.limit", DataValue.fromIntValue(settings.getMappingTotalFieldsLimit()));
        }

        return dataObject;
    }

    private DataObject fromDocument(Document document) {
        if (document == null) {
            return null;
        }

        DataObject dataObject = new DataObject();

        if (document.getDynamic() != null) {
            dataObject.addDataValue("dynamic", DataValue.fromBooleanValue(document.getDynamic()));
        }

        if (document.getFields() != null && !document.getFields().isEmpty()) {
            DataObject propertiesDataObject = dataObject.addDataObject("properties");
            for (Field field : document.getFields()) {
                DataObject fieldDataObject = propertiesDataObject.addDataObject(field.getFieldName());

                fieldDataObject.addDataValue("type", DataValue.fromStringValue(field.getFieldType()));
                if (field.getIgnoreAbove() != null) {
                    fieldDataObject.addDataValue("ignore_above", DataValue.fromIntValue(field.getIgnoreAbove()));
                }
            }
        }

        return dataObject;
    }
}
