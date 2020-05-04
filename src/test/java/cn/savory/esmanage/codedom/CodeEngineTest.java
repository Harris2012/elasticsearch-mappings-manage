package cn.savory.esmanage.codedom;

import org.junit.Test;

public class CodeEngineTest {

    @Test
    public void generateDataObject() {

        DataObject dataObject = new DataObject();
        dataObject.addDataValue("name", DataValue.fromStringValue("tom"));
        dataObject.addDataValue("age", DataValue.fromIntValue(18));

        CodeEngine jsCodeEngine = new CodeEngine();

        StringBuffer stringBuffer = new StringBuffer();

        jsCodeEngine.generateDataObject(dataObject, new CodeWriter(stringBuffer), new GenerateOptions(), false);

        System.out.println(stringBuffer.toString());
    }
}