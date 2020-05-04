package cn.savory.esmanage.esmapping;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MappingsEngineTest {

    @Test
    public void generate() {

        MappingsFile mappingsFile = new MappingsFile();


        mappingsFile.setAliases(Lists.newArrayList("product-aliases-1", "product-aliases-2"));

        Settings settings = new Settings();
        settings.setNumberOfShards(1);
        settings.setNumberOfReplicas(4);
        settings.setMappingTotalFieldsLimit(1000);
        mappingsFile.setSettings(settings);

        Document document = new Document();
        document.setName("product-index-1");
        document.setDynamic(false);
        List<Field> fields = Lists.newArrayListWithCapacity(4);
        document.setFields(fields);
        fields.add(toField("id", "integer"));
        fields.add(toField("productId", "long"));
        fields.add(toField("productName", "keyword", 128));
        fields.add(toField("FullText", "text"));
        mappingsFile.setDocument(document);

        MappingsEngine mappingsEngine = new MappingsEngine();

        String content = mappingsEngine.generate(mappingsFile);

        System.out.println(content);
    }

    private Field toField(String name, String type) {
        return toField(name, type, null);
    }

    private Field toField(String name, String type, Integer ignoreAbove) {
        Field field = new Field();
        field.setFieldName(name);
        field.setFieldType(type);
        field.setIgnoreAbove(ignoreAbove);
        return field;
    }
}