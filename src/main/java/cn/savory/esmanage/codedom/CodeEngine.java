package cn.savory.esmanage.codedom;

import java.util.Iterator;
import java.util.Map;

public class CodeEngine {

    public void generateDataObject(DataObject dataObject, CodeWriter codeWriter, GenerateOptions options, boolean endWithLine) {
        if (dataObject == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        boolean hasDataValueMap = dataObject.getDataValueMap() != null && !dataObject.getDataValueMap().isEmpty();
        boolean hasDataArrayMap = dataObject.getDataArrayMap() != null && !dataObject.getDataArrayMap().isEmpty();
        boolean hasDataObjectMap = dataObject.getDataObjectMap() != null && !dataObject.getDataObjectMap().isEmpty();

        codeWriter.write(Marks.LEFT_BRACE);

        if (hasDataValueMap || hasDataArrayMap || hasDataObjectMap) {
            codeWriter.writeLine();

            options.pushIndent();

            buildDataValueMap(dataObject.getDataValueMap(), codeWriter, options, hasDataArrayMap || hasDataObjectMap);

            buildDataArrayMap(dataObject.getDataArrayMap(), codeWriter, options, hasDataObjectMap);

            buildDataObjectMap(dataObject.getDataObjectMap(), codeWriter, options);

            options.popIndent();

            codeWriter.write(options.getIndentString());
        }

        codeWriter.write(Marks.RIGHT_BRACE);

        if (endWithLine) {
            codeWriter.writeLine();
        }
    }

    private void buildDataValueMap(Map<String, DataValue> dataValueMap, CodeWriter codeWriter, GenerateOptions options, boolean endWithComma) {
        if (dataValueMap == null || dataValueMap.isEmpty()) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        Iterator<Map.Entry<String, DataValue>> enumerator = dataValueMap.entrySet().iterator();
        boolean moveNext = enumerator.hasNext();
        while (moveNext) {
            Map.Entry<String, DataValue> item = enumerator.next();
            codeWriter.write(options.getIndentString()).write("\"" + item.getKey() + "\"").write(": ");
            if (item.getValue() == null) {
                codeWriter.write("null");
            } else {
                if (item.getValue().getValue() == null) {
                    codeWriter.write("null");
                } else {
                    codeWriter.write(item.getValue().getValue());
                }
            }

            moveNext = enumerator.hasNext();
            if (moveNext || endWithComma) {
                codeWriter.write(",");
            }
            codeWriter.writeLine();
        }
    }

    private void buildDataArrayMap(Map<String, DataArray> dataArrayMap, CodeWriter codeWriter, GenerateOptions options, boolean endWithComma) {
        if (dataArrayMap == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        Iterator<Map.Entry<String, DataArray>> enumerator = dataArrayMap.entrySet().iterator();
        boolean moveNext = enumerator.hasNext();
        while (moveNext) {
            Map.Entry<String, DataArray> dataArrayItem = enumerator.next();

            codeWriter.write(options.getIndentString()).write("\"" + dataArrayItem.getKey() + "\": ");

            buildDataArray(dataArrayItem.getValue(), codeWriter, options);

            moveNext = enumerator.hasNext();
            if (moveNext || endWithComma) {
                codeWriter.write(",");
            }
            codeWriter.writeLine();
        }
    }

    private void buildDataArray(DataArray dataArray, CodeWriter codeWriter, GenerateOptions options) {
        if (dataArray.getItems() == null || dataArray.getItems().isEmpty()) {
            codeWriter.write("[]");
        } else {
            codeWriter.write("[");

            boolean first = true;
            Iterator<DataValueOrObject> enumerator = dataArray.getItems().iterator();
            boolean moveNext = enumerator.hasNext();
            while (moveNext) {
                DataValueOrObject current = enumerator.next();

                if (current instanceof DataObject) {
                    generateDataObject((DataObject) current, codeWriter, options, false);

                    moveNext = enumerator.hasNext();
                    if (moveNext) {
                        codeWriter.write(", ");
                    }
                } else if (current instanceof DataValue) {
                    if (first) {
                        codeWriter.writeLine();
                    }
                    options.pushIndent();
                    codeWriter.write(options.getIndentString()).write(((DataValue) current).getValue());
                    options.popIndent();

                    moveNext = enumerator.hasNext();
                    if (moveNext) {
                        codeWriter.write(",");
                    }
                    codeWriter.writeLine();
                    if (!moveNext) {
                        codeWriter.write(options.getIndentString());
                    }
                } else {
                    moveNext = enumerator.hasNext();
                }

                first = false;
            }

            codeWriter.write("]");
        }
    }

    private void buildDataObjectMap(Map<String, DataObject> dataObjectMap, CodeWriter codeWriter, GenerateOptions options) {
        if (dataObjectMap == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        Iterator<Map.Entry<String, DataObject>> enumerator = dataObjectMap.entrySet().iterator();
        boolean moveNext = enumerator.hasNext();
        while (moveNext) {
            Map.Entry<String, DataObject> item = enumerator.next();

            codeWriter.write(options.getIndentString()).write("\"" + item.getKey() + "\": ");

            generateDataObject(item.getValue(), codeWriter, options, false);

            moveNext = enumerator.hasNext();
            if (moveNext) {
                codeWriter.writeLine(",");
            } else {
                codeWriter.writeLine();
            }
        }
    }
}